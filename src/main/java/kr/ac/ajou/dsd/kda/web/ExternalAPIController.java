package kr.ac.ajou.dsd.kda.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.ajou.dsd.kda.api.ITranslateAPI;


@Controller
public class ExternalAPIController {
	
	
	private ITranslateAPI trans;
	
	@Autowired
	ExternalAPIController(ITranslateAPI trans) {
		
		this.trans = trans;
		
	}
	
	@RequestMapping(value = "/translate/{koreanName}", method=RequestMethod.GET)
	public @ResponseBody String getTranslateToEng (
			@PathVariable(value="koreanName") String koreanName) {
		
		return trans.translateToEng(koreanName);
		
	}
	
	@RequestMapping(value = "/transliterate/{koreanName}", method=RequestMethod.GET)
	public @ResponseBody String getTransliterateToEng (
			@PathVariable(value="koreanName") String koreanName) {
		
		return trans.transliteratToEng(koreanName);
		
	}
	
	

}
