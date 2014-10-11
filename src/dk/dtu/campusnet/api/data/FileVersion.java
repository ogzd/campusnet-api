package dk.dtu.campusnet.api.data;

import java.util.Date;

import dk.dtu.campusnet.api.http.Request;

public class FileVersion extends ElementMember {
	
	private String fileId;
	private int version;
	private int kbSize;
	private Date createdDate;
	private String creatorId;
	private String note;
	
	protected FileVersion() {
		
	}
	
	public static FileVersionBuilder newBuilder() {
		return new FileVersionBuilder();
	}
	
	protected void setFileId(String fileId) {
		this.fileId = fileId;
	}
	
	protected void setVersion(int version) {
		this.version = version;
	}
	
	protected void setKbSize(int kbSize) {
		this.kbSize = kbSize;
	}
	
	protected void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	protected void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	
	protected void setNote(String note) {
		this.note = note;
	}
	
	public int getVersion() {
		return version;
	}
	
	public int getKbSize() {
		return kbSize;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public String getCreatorId() {
		return creatorId;
	}
	
	public String getNote() {
		return note;
	}
	
	public byte[] getBytes() {
		return Request.file(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Elements/%s/Files/%s/Versions/%s/Bytes", 
				elementId, fileId, version));
	}
	
}
