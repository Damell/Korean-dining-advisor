package kr.ac.ajou.dsd.kda.web;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import kr.ac.ajou.dsd.kda.KoreanDiningAdvisorApplication;
import kr.ac.ajou.dsd.kda.model.User;
import kr.ac.ajou.dsd.kda.model.UserPublic;
import kr.ac.ajou.dsd.kda.service.IUserService;



@Controller
@RequestMapping("/Users")
public class UserController {
	
	static final Logger logger = Logger.getLogger(KoreanDiningAdvisorApplication.class.getName());
	
	private IUserService userService;
	
	
	@Autowired
	UserController(IUserService userService) {
		
		this.userService = userService;
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void addUser(@RequestBody(required=true) UserPublic userPublic){
		logger.info("add user");
		userService.createUser(userPublic);
	}
	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody boolean autenticate(@RequestBody(required=true) UserPublic userPublic) {
		
		return userService.authenticate(userPublic);
		
	}
	
	
	
	

}
