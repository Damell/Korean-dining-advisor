package kr.ac.ajou.dsd.kda.repository;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.ajou.dsd.kda.util.EnvVariables;

/**
 * @author Daniel Chabr
 * Repository for images
 */
@Repository
public class ImageRepository implements IImageRepository {

	/**
	 * Saves image file to file system
	 * @param file the image file
	 * @param fileName the name of the image file
	 * @return file path to the image used for accessing it later
	 */
	@Override
	public String saveImage(MultipartFile file, String fileName) throws IOException {
		String filePath = UUID.randomUUID().toString() + fileName;
		String fullFilePath = EnvVariables.getImageDir() + filePath;
    	new File(EnvVariables.getImageDir()).mkdirs();
        byte[] bytes = file.getBytes();
        BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(fullFilePath));
        stream.write(bytes);
        stream.close();
        return filePath;
	}

	/**
	 * Retrieves image file from the file system
	 * @param fileName the name of the file to be retrieved
	 * @return the image file
	 */
	@Override
	public File getImage(String fileName) {
		String filePath = EnvVariables.getImageDir() + fileName;
		Logger logger = Logger.getLogger(ImageRepository.class);
		logger.log(Level.DEBUG, filePath);
		return new File(filePath);
	}

}
