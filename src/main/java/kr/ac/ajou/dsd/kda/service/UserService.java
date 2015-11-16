package kr.ac.ajou.dsd.kda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.ajou.dsd.kda.model.User;
import kr.ac.ajou.dsd.kda.model.UserPublic;
import kr.ac.ajou.dsd.kda.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public void createUser(UserPublic userPublic) {
		User user = new User(userPublic.getUsername(), userPublic.getEmail(), userPublic.getPassword());
		userRepository.save(user);
	}
	
	@Override
	public boolean authenticate(UserPublic userPublic) {
		
		return false;
	}

	
}
