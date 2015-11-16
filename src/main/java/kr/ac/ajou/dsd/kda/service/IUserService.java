package kr.ac.ajou.dsd.kda.service;

import kr.ac.ajou.dsd.kda.model.User;
import kr.ac.ajou.dsd.kda.model.UserPublic;

public interface IUserService {
	
	public void createUser(UserPublic userPublic);
	
	public boolean authenticate(UserPublic userPublic);

}
