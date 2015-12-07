package kr.ac.ajou.dsd.kda.service;

import kr.ac.ajou.dsd.kda.model.User;
import kr.ac.ajou.dsd.kda.model.UserPublic;


/**
 * @author Jae wook
 *  Interface that can create and authenticate user  
 */
public interface IUserService {
	
	/**
	 * create User  
	 * @param UserPublic is userclass that have public password 
	 */
	public void createUser(UserPublic userPublic);
	
	/**
	 * authenticate User
	 * @param UserPublic is userclass that have public password 
	 * @return boolean true if password matches
	 */
	
	public boolean authenticate(UserPublic userPublic);

}
