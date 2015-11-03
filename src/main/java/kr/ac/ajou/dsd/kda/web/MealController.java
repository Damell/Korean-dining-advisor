package kr.ac.ajou.dsd.kda.web;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import kr.ac.ajou.dsd.kda.KoreanDiningAdvisorApplication;
import kr.ac.ajou.dsd.kda.model.Meal;
import kr.ac.ajou.dsd.kda.service.IMealService;

/**
 * 
 * @author Torben Tietze <torben.tietze@googlemail.com>
 *
 */
@Controller
@RequestMapping("/meals")
public class MealController {
	static final Logger logger = Logger.getLogger(KoreanDiningAdvisorApplication.class.getName()); 
	
	private IMealService mealService;
	
	@Autowired
	MealController(IMealService mealService){
		this.mealService = mealService;
	}

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Meal> getMeals(
			@RequestParam(value="query", required=false, defaultValue="") String query, 
			@RequestParam(value="limit", required=false, defaultValue="10") int limit,
			@RequestParam(value="start", required=false, defaultValue="0") int start) {
		
		return mealService.getMeals(query, limit, start);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void addMeal(@Validated @RequestBody(required=true) Meal meal){
		logger.info("add a meal");
		mealService.addMeal(meal);
	}
	
}
