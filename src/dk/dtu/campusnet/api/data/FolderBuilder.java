package dk.dtu.campusnet.api.data;

import java.util.Date;

public class FolderBuilder {

	private Folder folder;
	
	protected FolderBuilder() {
		folder = new Folder();
	}
	
	public FolderBuilder withElementId(String elementId) {
		folder.setElementId(elementId);
		return this;
	}
	
	public FolderBuilder withFolderId(String folderId) {
		folder.setFolderId(folderId);
		return this;
	}
	
	public FolderBuilder withCreatedDate(Date createdDate) {
		folder.setCreatedDate(createdDate);
		return this;
	}
	
	
	public FolderBuilder withMayUpload(boolean mayUpload) {
		folder.setMayUpload(mayUpload);
		return this;
	}
	
	public FolderBuilder withName(String name) {
		folder.setName(name);
		return this;
	}
	
	public FolderBuilder withNote(String note) {
		folder.setNote(note);
		return this;
	}
	
	public Folder done() {
		return folder;
	}
}
