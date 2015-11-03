package kr.ac.ajou.dsd.kda.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;


import kr.ac.ajou.dsd.kda.model.Meal;
import kr.ac.ajou.dsd.kda.model.Rating;

/**
 * 
 * @author Torben Tietze <torben.tietze@googlemail.com>
 *
 */
@Repository
public class MealRepository implements IMealRepository{
	private Map<UUID, Meal> meals;
	
	public MealRepository() {
		String[] str = new String[10];
		byte[] byt = new byte[10];
		this.meals = new HashMap<UUID, Meal>();
		Meal meal1 = new Meal("김치찌개","kimchi stew", "kimchiggigae","most famous korean food", str, byt, new Rating(), 10, 10);
		Meal meal2 = new Meal("불고기","meat", "bulgogi","most famous korean food", str, byt, new Rating(), 10, 10);
		Meal meal3 = new Meal("라면","noodle", "raman","most famous korean food", str, byt, new Rating(), 10, 10);
		meals.put(meal1.getId(), meal1);
		meals.put(meal2.getId(), meal2);
		meals.put(meal3.getId(), meal3);
	}

	@Override
	public Meal getMeal(UUID uuid) {
		return meals.get(uuid);
	}

	@Override
	public void add(Meal meal) {
		meals.put(meal.getId(), meal);
	}

	@Override
	public void update(Meal meal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID uuid) {
		meals.remove(uuid);		
	}

	@Override
	public Collection<? extends Meal> getMealsByName(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meal> getAll() {
		return new ArrayList<Meal>(meals.values());
	}
	

}
