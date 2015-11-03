package kr.ac.ajou.dsd.kda.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import kr.ac.ajou.dsd.kda.model.Meal;

public interface IMealRepository {
	public Meal getMeal(UUID uuid);
	public Collection<? extends Meal> getMealsByName(String query);

	public void add(Meal meal);
	public void update(Meal meal);

	public void delete(UUID uuid);
	public List<Meal> getAll();

}
