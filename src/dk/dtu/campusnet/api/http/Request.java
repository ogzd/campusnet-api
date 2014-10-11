package dk.dtu.campusnet.api.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Request {

	private static HttpClient client;
	
	private static final Map<String, String> cache = Maps.newConcurrentMap(); 
	private static final String APPNAME  = "SYCN";
	private static final String APPTOKEN = "7f4655b9-609e-4220-88c3-db38433b8c50"; 
	
	/**
	 * Performs POST operation with additional data, returns the response document.
	 * @param url
	 * @param data
	 * @return
	 */
	public static Document post(String url, Map<String, String> data, boolean useLimitedPassword) {
		try {
			HttpClient client = useLimitedPassword ? client() : HttpClients.createDefault();
			HttpPost   post   = new HttpPost(url);
			post.setEntity(new UrlEncodedFormEntity(convertToNVPList(data), "UTF-8"));
			
			HttpResponse response = client.execute(post);
			HttpEntity   entity   = response.getEntity();
			
			if(entity != null) {
				Document doc = DocumentBuilderFactory.newInstance()
									                 .newDocumentBuilder()
									                 .parse(entity.getContent());
				doc.getDocumentElement().normalize();
				return doc;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Performs GET operation in order to return XML/HTML response from CN REST API.
	 * @param url
	 * @return
	 */
	public static Document get(String url) {
		try {
			HttpResponse response = client().execute(new HttpGet(url));
			HttpEntity   entity   = response.getEntity();
			
			if(entity != null) {
				return parseContent(entity.getContent());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	/**
	 * Performs GET operation for files, serviceUsername/servicePassword params should be included in the request.
	 * @param url
	 * @return
	 */
	public static byte[] file(String url) {
		try {
			HttpResponse response = client().execute(new HttpGet(
													new URIBuilder(url).addParameter("serviceUsername", cache.get("username"))
							   										   .addParameter("servicePassword", cache.get("limitedPassword"))
							   											.build()));
			HttpEntity entity = response.getEntity();
			if(entity != null) {
				return IOUtils.toByteArray(entity.getContent());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	/**
	 * Performs POST operation for uploading files into CampusNet. 
	 * File name should be set in header as 'X-File-Name' and file contents should be set in post data.
	 */
	public static void upload(String url, String fileName, byte[] fileContent) {
		try {
			HttpPost post = new HttpPost(url);
			post.setHeader("X-File-Name", fileName);
			post.setEntity(new ByteArrayEntity(fileContent));
			client().execute(post);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Caches key value pairs.
	 * @param key
	 * @param value
	 */
	public static void cache(String key, String value) {
		cache.put(key, value);
	}
	
	/**
	 * Ensures that HttpClient object is singleton.
	 * @return
	 */
	private static HttpClient client() {
		if(client == null) {
			Header appname  = new BasicHeader("X-appname", APPNAME);
			Header apptoken = new BasicHeader("X-token", APPTOKEN);
			
			CredentialsProvider provider = new BasicCredentialsProvider();
			provider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(cache.get("username"), 
																				   cache.get("limitedPassword")));
			client = HttpClientBuilder.create()
								     .setDefaultCredentialsProvider(provider)
								     .setDefaultHeaders(Lists.newArrayList(appname, apptoken))
								     .build();
		}
		return client;
	}
	
	/**
	 * Converts map entries to name value pairs.
	 * @param data
	 * @return
	 */
	private static List<BasicNameValuePair> convertToNVPList(Map<String, String> data) {
		List<BasicNameValuePair> pairs = new ArrayList<BasicNameValuePair>(data.size());
		
		for (Map.Entry<String, String> entry : data.entrySet()) {
			pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		
		return pairs;
	}
	
	private static Document parseContent(InputStream content) throws SAXException, IOException, ParserConfigurationException {
		Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(content);
		doc.getDocumentElement().normalize();
		return doc;
	}
	
}
