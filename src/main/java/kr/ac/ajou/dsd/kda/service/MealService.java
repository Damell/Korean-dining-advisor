package kr.ac.ajou.dsd.kda.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.ajou.dsd.kda.KoreanDiningAdvisorApplication;
import kr.ac.ajou.dsd.kda.model.Meal;
import kr.ac.ajou.dsd.kda.model.Rating;
import kr.ac.ajou.dsd.kda.repository.IImageRepository;
import kr.ac.ajou.dsd.kda.repository.IMealRepository;

/**
 * Meal service implementation
 */
@Service
public class MealService implements IMealService{
	final private Logger logger = Logger.getLogger(MealService.class); 
	
	@Autowired
	private IMealRepository mealRepository;

	@Autowired
	private IImageRepository imageRepository;

	@Override
	public List<Meal> getMeals(String query, int limit, int start) {
		if(query.equals("")) {
			return mealRepository.findAll(new PageRequest(start, limit)).getContent();
		}
		return mealRepository.findByEnglishNameOrTransliteratedNameIgnoreCase(query, new PageRequest(start, limit));
	}

	@Override
	public Meal getMealById(UUID uuid) {
		Meal meal = mealRepository.findOne(uuid);
		meal.setViewNum(meal.getViewNum() + 1);
		mealRepository.saveAndFlush(meal);
		return meal;
	}

	@Override
	public void addMeal(Meal meal) {
		mealRepository.save(meal);
	}

	@Override
	public void updateMeal(Meal meal) {
		
		logger.info("meal before storing: " + meal.getId());
		logger.info("meal before storing: " + meal.getPhotoUrl());
		logger.info("meal before storing: " + meal.getKoreanName());
		Meal mTmp = mealRepository.saveAndFlush(meal);
		logger.info("meal after storing: " + mTmp.getId());
		logger.info("meal before storing: " + mTmp.getPhotoUrl());
	}

	@Override
	public void deleteMealById(UUID uuid) {
		mealRepository.delete(uuid);		
	}

	/**
	 * @author Daniel Chabr
	 * Gets image file from the repository
	 * @param path to the image
	 * @return byte [] of the image
	 */
	@Override
	public byte[] getImage(String path) {
		File file = imageRepository.getImage(path);
		try {
			return Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			logger.warn("Problem by reading " + path + " - " + e.getMessage());
			return null;
		}
	}

	/**
	 * @author Daniel Chabr
	 * Saves image file to repository
	 * @param file image file
	 * @param fileName name of the image
	 * @return path to the saved file
	 */
	@Override
	public String saveImage(MultipartFile file, String fileName) throws IOException {
		return imageRepository.saveImage(file, fileName);
	}

}
