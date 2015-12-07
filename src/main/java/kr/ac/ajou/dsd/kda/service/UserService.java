package kr.ac.ajou.dsd.kda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.ajou.dsd.kda.model.User;
import kr.ac.ajou.dsd.kda.model.UserPublic;
import kr.ac.ajou.dsd.kda.repository.IUserRepository;


/**
 * @author Jae wook
 *  UserService class that can create and authenticate user  
 */

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	
	/**
	 * create User  
	 * @param UserPublic is user class that have public password 
	 */
	@Override
	public void createUser(UserPublic userPublic) {
		User user = new User(userPublic.getUsername(), userPublic.getEmail(), userPublic.getPassword());
		userRepository.save(user);
	}
	
	
	/**
	 * authenticate User
	 * @param UserPublic is userclass that have public password 
	 * @return boolean true if password matches
	 */
	
	@Override
	public boolean authenticate(UserPublic userPublic) {
		
		User user = userRepository.findOne(userPublic.getUsername());
		
		if(user != null) {
		
			return user.checkPassword(userPublic.getPassword());
			
		}
		else {
			
			return false;
			
		}
		
		
	}

	
}
