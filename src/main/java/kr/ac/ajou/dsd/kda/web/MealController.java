package kr.ac.ajou.dsd.kda.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.ajou.dsd.kda.model.IMeal;
import kr.ac.ajou.dsd.kda.service.IMealService;

/**
 * 
 * @author Torben Tietze <torben.tietze@googlemail.com>
 *
 */
@Controller
@RequestMapping("/meals")
public class MealController {
	
	private IMealService mealService;
	
	@Autowired
	MealController(IMealService mealService){
		this.mealService = mealService;
	}

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<IMeal> getMeals(
			@RequestParam(value="query", required=false, defaultValue="") String query, 
			@RequestParam(value="limit", required=false, defaultValue="10") int limit,
			@RequestParam(value="start", required=false, defaultValue="0") int start) {
		
		return mealService.getMeals(query, limit, start);
	}
	
}
