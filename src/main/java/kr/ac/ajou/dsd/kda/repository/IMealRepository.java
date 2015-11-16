package kr.ac.ajou.dsd.kda.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import kr.ac.ajou.dsd.kda.model.Meal;

public interface IMealRepository extends CrudRepository<Meal, UUID> {
	
	//Meal findById(UUID uuid);
	
	//Iterable<Meal> findByKoreanName(String query);

//	<S extends Meal> S save(Meal meal);
//
//	void delete(Meal meal);
//	
	List<Meal> findAll();

}
