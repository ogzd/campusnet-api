package dk.dtu.campusnet.api.reader;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dk.dtu.campusnet.api.data.File;
import dk.dtu.campusnet.api.data.FileVersion;
import dk.dtu.campusnet.api.data.Folder;

public class FolderReader implements DocumentReader {

	private Document document;
	
	@Override
	public FolderReader from(Document document) {
		this.document = document;
		return this;
	}

	public Folder getRootFolder(String elementId) {
		Node rootNode = document.getChildNodes().item(0);
		return getFolder(rootNode, elementId);
	}
	
	// TODO: Refactor this spaghetti code.
	private Folder getFolder(Node parentNode, String elementId) {
		Folder parentFolder = NodeParser.parseFolder(parentNode, elementId);
		
		NodeList childNodes = parentNode.getChildNodes();
		for(int i = 0; i < childNodes.getLength(); ++i) {
			Node node = childNodes.item(i);
			if(node.getNodeName().equals("Folder")) {
				Folder subFolder = getFolder(node, elementId);
				parentFolder.addFolder(subFolder);
			}
			else if(node.getNodeName().equals("File")) {
				File subFile = NodeParser.parseFile(node, elementId);
				parentFolder.addFile(subFile);
				NodeList versionNodes = node.getChildNodes();
				for(int j = 0; j < versionNodes.getLength(); ++j) {
					Node versionNode = versionNodes.item(j);
					FileVersion subVersion = NodeParser.parseFileVersion(versionNode, elementId, subFile.getFileId());
					subFile.addFileVersion(subVersion);
				}
			}
		}
		
		return parentFolder;
	}
}
