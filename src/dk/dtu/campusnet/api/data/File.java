package dk.dtu.campusnet.api.data;

import java.util.Collections;
import java.util.TreeMap;

import com.google.common.collect.Maps;

import dk.dtu.campusnet.api.http.Request;

public class File extends ElementMember {

	private TreeMap<Integer, FileVersion> fileVersions;
	
	private String fileId;
	private String name;
	
	protected File() {
		fileVersions = Maps.newTreeMap(Collections.reverseOrder());
	}
	
	public static FileBuilder newBuilder() {
		return new FileBuilder();
	}
	
	protected void setFileId(String fileId) {
		this.fileId = fileId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFileId() {
		return this.fileId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addFileVersion(FileVersion subVersion) {
		fileVersions.put(subVersion.getVersion(), subVersion);
	}
	
	// TODO: Throw FileVersionNotFoundException
	public FileVersion getFileVersion(int version) {
		return fileVersions.get(version);
	}
	
	// TODO: Throw FileVersionNotFoundException
	public FileVersion getLatestVersion() {
		return fileVersions.firstEntry().getValue();
	}
	
	public byte[] getBytes() {
		return Request.file(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Elements/%s/Files/%s/Bytes", 
				elementId, fileId));
	}
	
}
