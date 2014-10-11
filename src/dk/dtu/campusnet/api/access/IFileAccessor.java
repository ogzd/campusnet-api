package dk.dtu.campusnet.api.access;

import java.util.List;

import dk.dtu.campusnet.api.data.File;
import dk.dtu.campusnet.api.data.Folder;

public interface IFileAccessor {
	
	/**
	 * Returns info about amount newest files from specified group, starting from first.
	 * @param first
	 * @param amount
	 * @return
	 */
	public List<File> getNewestFiles(int first, int amount);
	
	/**
	 * Returns all files in the file sharing.
	 * @return
	 */
	public Folder getRootFolder();
	
}
