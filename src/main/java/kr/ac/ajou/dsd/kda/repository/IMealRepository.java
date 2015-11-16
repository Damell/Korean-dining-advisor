package kr.ac.ajou.dsd.kda.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.ac.ajou.dsd.kda.model.Meal;

public interface IMealRepository extends JpaRepository<Meal, UUID> {
	
	//Iterable<Meal> findByKoreanName(String query);

//	<S extends Meal> S save(Meal meal);
//
//	void delete(Meal meal);
//	
	List<Meal> findAll();

}
