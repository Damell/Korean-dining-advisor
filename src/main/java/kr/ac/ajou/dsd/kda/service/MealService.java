package kr.ac.ajou.dsd.kda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.ajou.dsd.kda.KoreanDiningAdvisorApplication;
import kr.ac.ajou.dsd.kda.model.Meal;
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
	MealService(IMealRepository mealRepository){
		this.mealRepository = mealRepository;
	}

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

}
