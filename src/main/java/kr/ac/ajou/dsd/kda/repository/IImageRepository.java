package kr.ac.ajou.dsd.kda.repository;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IImageRepository {

	public String saveImage(MultipartFile file, String fileName) throws IOException;
	
	public File getImage(String fileName);
	
}
