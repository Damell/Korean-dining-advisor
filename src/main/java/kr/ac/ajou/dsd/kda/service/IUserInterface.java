package kr.ac.ajou.dsd.kda.service;

import kr.ac.ajou.dsd.kda.model.User;

public interface IUserInterface {
	
	public void createUser(User user);
	
	public boolean authenticate(User user);

}
