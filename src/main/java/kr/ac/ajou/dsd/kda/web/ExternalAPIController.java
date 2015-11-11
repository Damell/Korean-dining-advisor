package kr.ac.ajou.dsd.kda.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.ajou.dsd.kda.api.ITranslateAPI;


@Controller
public class ExternalAPIController {
	
	ITranslateAPI trans;
	
	@RequestMapping(value = "/translate", method=RequestMethod.GET)
	public @ResponseBody String getTranslateToEng (
			@RequestParam(value="koreanName", defaultValue="김치") String koreanName) {
		
		return trans.translateToEng(koreanName);
		
	}
	
	@RequestMapping(value = "/transliterate", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getTransliterateToEng (
			@RequestParam(value="koreanName", defaultValue="김치") String koreanName) {
		
		return trans.transliteratToEng(koreanName);
		
	}
	
	

}
