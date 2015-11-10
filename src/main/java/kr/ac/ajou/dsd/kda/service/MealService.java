package kr.ac.ajou.dsd.kda.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.ajou.dsd.kda.KoreanDiningAdvisorApplication;
import kr.ac.ajou.dsd.kda.model.Meal;
import kr.ac.ajou.dsd.kda.repository.IImageRepository;
import kr.ac.ajou.dsd.kda.repository.IMealRepository;

/**
 * 
 * @author Torben Tietze <torben.tietze@googlemail.com>
 *
 */
@Service
public class MealService implements IMealService{
	final private Logger log = Logger.getLogger(KoreanDiningAdvisorApplication.class.getName()); 
	
	@Autowired
	private IMealRepository mealRepository;

	@Autowired
	private IImageRepository imageRepository;

	@Override
	public List<Meal> getMeals(String query, int limit, int start) {
		return mealRepository.findAll();
	}

	@Override
	public Meal getMealById(UUID uuid) {
		return mealRepository.findOne(uuid);
	}

	@Override
	public void addMeal(Meal meal) {
		mealRepository.save(meal);
	}

	@Override
	public void updateMeal(Meal meal) {
		mealRepository.save(meal);
	}

	@Override
	public void deleteMealById(UUID uuid) {
		mealRepository.delete(uuid);		
	}

	@Override
	public byte[] getImage(String path) {
		File file = imageRepository.getImage(path);
		try {
			return Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String saveImage(MultipartFile file, String fileName) throws IOException {
		return imageRepository.saveImage(file, fileName);
	}

}
