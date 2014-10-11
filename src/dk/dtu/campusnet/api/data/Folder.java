package dk.dtu.campusnet.api.data;

import java.util.Date;
import java.util.Map;

import com.google.common.collect.Maps;

import dk.dtu.campusnet.api.http.Request;

public class Folder extends ElementMember {
	
	private Map<String, Folder> subFolders;
	private Map<String, File> subFiles;
	
	private String folderId;
	private String name;
	private String note;
	private Date createdDate;
	private boolean mayUpload;
	
	protected Folder() {
		subFolders = Maps.newHashMap();
		subFiles   = Maps.newHashMap();
	}
	
	/**
	 * Access point in order to created a Folder instance.
	 * @return
	 */
	public static FolderBuilder newBuilder() {
		return new FolderBuilder();
	}
	
	/**
	 * Setter methods are declared protected, so only appropriate
	 * builder classes can touch them.
	 */
	
	protected void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	protected void setMayUpload(boolean mayUpload) {
		this.mayUpload = mayUpload;
	}
	
	protected void setFolderId(String folderId) {
		this.folderId = folderId;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected void setNote(String note) {
		this.note = note;
	}
	
	public void addFolder(Folder subFolder) {
		subFolders.put(subFolder.getFolderId(), subFolder);
	}
	
	public void addFile(File subFile) {
		subFiles.put(subFile.getFileId(), subFile);
	}
	
	public Date getCreatedDate() {
		return this.createdDate;
	}
	
	public boolean getMayUpload() {
		return this.mayUpload;
	}
	
	public String getFolderId() {
		return this.folderId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getNote() {
		return this.note;
	}
	
	// TODO: Throw FileNotFoundException
	public File getFileById(String fileId) {
		return subFiles.get(fileId);
	}
	
	// TODO: Throw FileNotFoundException
	public File getFileByName(String fileName) {
		for(File file : subFiles.values()) {
			if(file.getName().equals(fileName))
				return file;
		}
		return null;
	}
	
	// TODO: Throw FolderNotFoundException
	public Folder getSubFolderById(String folderId) {
		return subFolders.get(folderId);
	}
	
	// TODO: Throw FolderNotFoundException
	public Folder getSubFolderByName(String folderName) {
		for(Folder folder : subFolders.values()) {
			if(folder.getName().equals(folderName))
				return folder;
		}
		return null;
	}
	
	public void upload(String fileName, byte[] fileContent) {
		Request.upload(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Elements/%s/Files/Upload?folderId=%s", elementId, folderId),
				fileName, fileContent);
	}
	
	public void printFolderNames() {
		for(Folder subFolder : subFolders.values())
			System.out.println(subFolder.getName());
	}
	
}
