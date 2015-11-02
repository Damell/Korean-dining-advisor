package kr.ac.ajou.dsd.kda.service;

import java.util.List;
import java.util.UUID;

import kr.ac.ajou.dsd.kda.model.Meal;

public interface IMealService {
	public List<Meal> getMeals(String query, int limit, int start);
	public Meal getMealById(UUID uuid);
	
	public void insertMeal(Meal meal);
	public void updateMeal(Meal meal);
	
	public void deleteMealById(UUID uuid);
}
