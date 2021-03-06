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
 * 
 * @author Torben Tietze <torben.tietze@googlemail.com>
 *
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
		List<Meal> meals = mealRepository.findByEnglishNameOrTransliteratedNameContainingIgnoreCase(query, query, new PageRequest(start, limit));
		if (meals == null) 
			return new ArrayList<Meal>();
		else 
			return meals;
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

	@Override
	public String saveImage(MultipartFile file, String fileName) throws IOException {
		return imageRepository.saveImage(file, fileName);
	}

}
