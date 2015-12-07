package kr.ac.ajou.dsd.kda.repository;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Daniel Chabr
 * Interface for saving and retrieving images
 */
public interface IImageRepository {

	/**
	 * @param file the image file
	 * @param fileName the name of the image file
	 * @return file path to the image used for accessing it later
	 */
	public String saveImage(MultipartFile file, String fileName) throws IOException;
	
	/**
	 * @param fileName the name of the file to be retrieved
	 * @return the image file
	 */
	public File getImage(String fileName);
	
}
