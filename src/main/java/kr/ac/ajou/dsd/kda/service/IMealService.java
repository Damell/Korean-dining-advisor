package kr.ac.ajou.dsd.kda.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import kr.ac.ajou.dsd.kda.model.Meal;

public interface IMealService {
	public List<Meal> getMeals(String query, int limit, int start);
	public Meal getMealById(UUID uuid);
	
	public void addMeal(Meal meal);
	public void updateMeal(Meal meal);
	
	public void deleteMealById(UUID uuid);
	public byte[] getImage(String path);
	public String saveImage(MultipartFile file, String fileName) throws IOException;
}
