package dk.dtu.campusnet.api.data;

public class FileBuilder {

	private File file;
	
	protected FileBuilder() {
		file = new File();
	}
	
	public FileBuilder withElementId(String elementId) {
		file.setElementId(elementId);
		return this;
	}
	
	public FileBuilder withFileId(String fileId) {
		file.setFileId(fileId);
		return this;
	}
	
	public FileBuilder withName(String name) {
		file.setName(name);
		return this;
	}
	
	public File done() {
		return file;
	}
	
}
