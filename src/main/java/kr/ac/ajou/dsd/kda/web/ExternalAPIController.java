package kr.ac.ajou.dsd.kda.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.ajou.dsd.kda.api.ITranslateAPI;

/**
 * @author Jae wook
 * Controller for accessing translation and transliteration by ExternalAPI 
 */
@Controller
public class ExternalAPIController {
	
	
	private ITranslateAPI trans;
	
	@Autowired
	ExternalAPIController(ITranslateAPI trans) {
		
		this.trans = trans;
		
	}
	
	
	
	/**
	 * korean name translate to English name 
	 * @param koranName saved in Meal
	 * @return String EnglishName translated by bing API
	 */
	
	@RequestMapping(value = "/translate/{koreanName}", method=RequestMethod.GET)
	public @ResponseBody String getTranslateToEng (
			@PathVariable(value="koreanName") String koreanName) {
		
		return trans.translateToEng(koreanName);
		
	}
	
	
	
	/**
	 * korean name transliterate to English name 
	 * @param koranName saved in Meal
	 * @return String EnglishName transliterate by glosbeAPI
	 */
	
	@RequestMapping(value = "/transliterate/{koreanName}", method=RequestMethod.GET)
	public @ResponseBody String getTransliterateToEng (
			@PathVariable(value="koreanName") String koreanName) {
		
		try {
			koreanName = new String(koreanName.getBytes("8859_1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trans.transliteratToEng(koreanName);
		
	}
	
	

}
