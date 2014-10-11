package dk.dtu.campusnet.api.access;

import java.util.List;

import org.w3c.dom.Document;

import dk.dtu.campusnet.api.data.File;
import dk.dtu.campusnet.api.data.Folder;
import dk.dtu.campusnet.api.http.Request;
import dk.dtu.campusnet.api.reader.FolderReader;
import dk.dtu.campusnet.api.reader.Reader;

public class FileAccessor implements IFileAccessor {

	private final String elementId;
	
	public FileAccessor(String elementId) {
		this.elementId = elementId;
	}

	// TODO: Not supported atm.
	@Override
	public List<File> getNewestFiles(int first, int amount) {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Elements/%s/Files/Newest/From/%s/Returning/%s", 
											elementId, first, amount));
		Reader.printDocument(doc, System.out);
		return null;
	}

	@Override
	public Folder getRootFolder() {
		Document doc = Request.get(String.format("https://www.campusnet.dtu.dk/data/CurrentUser/Elements/%s/Files", elementId));
		
		return Reader.load(FolderReader.class, doc)
					 .getRootFolder(elementId);
	}

}
