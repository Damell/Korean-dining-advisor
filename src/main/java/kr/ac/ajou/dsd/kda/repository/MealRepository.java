package kr.ac.ajou.dsd.kda.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import kr.ac.ajou.dsd.kda.model.IMeal;
import kr.ac.ajou.dsd.kda.model.Meal;

/**
 * 
 * @author Torben Tietze <torben.tietze@googlemail.com>
 *
 */
@Repository
public class MealRepository implements IMealRepository{
	private Map<UUID, IMeal> meals;
	
	public MealRepository() {
		this.meals = new HashMap<UUID, IMeal>();
		IMeal m = new Meal();
		meals.put(m.getUUID(), m);
	}

	@Override
	public IMeal getMeal(UUID uuid) {
		return meals.get(uuid);
	}

	@Override
	public Map<UUID, IMeal> search(String query) {
		// TODO implement searching
		return meals;
	}

	@Override
	public void add(IMeal meal) {
		meals.put(meal.getUUID(), meal);
	}

	@Override
	public void update(IMeal meal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID uuid) {
		meals.remove(uuid);		
	}

	@Override
	public Collection<? extends IMeal> findInAllNames(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IMeal> getall() {
		return new ArrayList<IMeal>(meals.values());
	}
	

}
