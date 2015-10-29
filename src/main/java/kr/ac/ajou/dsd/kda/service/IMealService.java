package kr.ac.ajou.dsd.kda.service;

import java.util.List;
import java.util.UUID;

import kr.ac.ajou.dsd.kda.model.IMeal;

public interface IMealService {
	public List<IMeal> getMeals(String query, int limit, int start);
	public IMeal getMealById(UUID uuid);
	
	public void insertMeal(IMeal meal);
	public void updateMeal(IMeal meal);
	
	public void deleteMealById(UUID uuid);
}
