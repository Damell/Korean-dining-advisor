package kr.ac.ajou.dsd.kda.web;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.websocket.server.PathParam;

import org.apache.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.ajou.dsd.kda.KoreanDiningAdvisorApplication;
import kr.ac.ajou.dsd.kda.model.Meal;
import kr.ac.ajou.dsd.kda.repository.ImageRepository;
import kr.ac.ajou.dsd.kda.service.IMealService;


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
	@ResponseStatus(value = HttpStatus.CREATED)
	public void addMeal(@RequestBody(required=true) Meal meal){
		logger.info("add a meal");
		mealService.addMeal(meal);
	}
	
	/*
	@RequestMapping(value = "/{uuid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Meal getByMeal(@PathVariable(value = "uuid") UUID uuid) {
		return mealService.getMealById(uuid);
	}
	*/
	
	
	@RequestMapping(value="/images/upload", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> uploadImage(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
            try {
            	String filePath = mealService.saveImage(file, name);
                return new ResponseEntity<String>("You successfully uploaded file to " + filePath + "!", HttpStatus.CREATED);
            } catch (Exception e) {
            	return new ResponseEntity<String>("You failed to upload file: " + e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<String>("You failed to upload because the file was empty.", HttpStatus.BAD_REQUEST);
        }
	}
	
	@RequestMapping(value="/images/{path:.+}", method=RequestMethod.GET)
	public ResponseEntity<byte []> getImage(@PathVariable(value = "path") String path) {
		byte[] image = mealService.getImage(path);
		if (image == null) {
			return new ResponseEntity<byte[]>(image, HttpStatus.NOT_FOUND);
		}

		HttpHeaders headers = new HttpHeaders();
		if (path.toLowerCase().endsWith(".jpg")) {
			headers.setContentType(MediaType.IMAGE_JPEG);
		} else if (path.toLowerCase().endsWith(".png")) {
			headers.setContentType(MediaType.IMAGE_PNG);
		} else if (path.toLowerCase().endsWith(".gif")) {
			headers.setContentType(MediaType.IMAGE_GIF);
		}	
		headers.setContentLength(image.length);
		return new ResponseEntity<byte[]>(image, headers, HttpStatus.OK);
	}
	
}
