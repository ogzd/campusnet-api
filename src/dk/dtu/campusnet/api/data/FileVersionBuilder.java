package dk.dtu.campusnet.api.data;

import java.util.Date;

public class FileVersionBuilder {

	private FileVersion fileVersion;
	
	protected FileVersionBuilder() {
		fileVersion = new FileVersion();
	}
	
	public FileVersionBuilder withFileId(String fileId) {
		fileVersion.setFileId(fileId);
		return this;
	}
	
	public FileVersionBuilder withElementId(String elementId) {
		fileVersion.setElementId(elementId);
		return this;
	}
	
	public FileVersionBuilder withVersion(int version) {
		fileVersion.setVersion(version);
		return this;
	}
	
	public FileVersionBuilder withCreatedDate(Date createdDate) {
		fileVersion.setCreatedDate(createdDate);
		return this;
	}
	
	public FileVersionBuilder withCreatorId(String creatorId) {
		fileVersion.setCreatorId(creatorId);
		return this;
	}
	
	public FileVersionBuilder withKbSize(int kbSize) {
		fileVersion.setKbSize(kbSize);
		return this;
	}
	
	public FileVersionBuilder withNote(String note) {
		fileVersion.setNote(note);
		return this;
	}
	
	public FileVersion done() {
		return fileVersion;
	}
	
}
