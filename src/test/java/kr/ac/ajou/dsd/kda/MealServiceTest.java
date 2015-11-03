package kr.ac.ajou.dsd.kda;

import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.ajou.dsd.kda.model.Meal;
import kr.ac.ajou.dsd.kda.model.Rating;
import kr.ac.ajou.dsd.kda.service.IMealService;

@Transactional
public class MealServiceTest extends KoreanDiningAdvisorApplicationTests {

	@Autowired
	private IMealService mealService;
	
	@Before
	public void setUp(){
	
	}
	
	@After
	public void tearDown(){
		//cleanup after the test
	}
	
	@Test
	public void testFindAll(){
		final int numberOfMealsToGet = 1;
		Collection<Meal> list = mealService.getMeals("", numberOfMealsToGet, 0);
		Assert.assertNotNull("failure - expected not null", list);

		// can be used when mealServide.getMeals() is completely implemented
//		Assert.assertEquals("failure - wrong number of expected meals", numberOfMealsToGet, list.size() );
	}
	
	@Test
	public void testAddAndFindById(){
		Meal m1 = new Meal("떡볶이", "Hot rice cake", "Tteokbokki", "", null, null, new Rating(), 0, 4);
		Meal m2 = new Meal("떡볶이", "Hot rice cake", "Tteokbokki", "", null, null, new Rating(), 0, 4);
		Assert.assertNotNull("failure - expected not null", m1);
		
		mealService.addMeal(m1);
		Meal receivedMeal = mealService.getMealById(m1.getId());

		Assert.assertEquals(receivedMeal, m1);
		Assert.assertNotEquals(receivedMeal, m2);
		
		
	}
}
