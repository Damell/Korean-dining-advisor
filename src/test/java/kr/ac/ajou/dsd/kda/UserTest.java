package kr.ac.ajou.dsd.kda;

import org.junit.Assert;
import org.junit.Test;

import kr.ac.ajou.dsd.kda.model.User;

public class UserTest {

	@Test
	public void createUserAndCheckPasswordTest () {
		User user = new User();
		user.setPassword("mypass");
		Assert.assertTrue(user.checkPassword("mypass"));
		Assert.assertFalse(user.checkPassword("wrongpassword"));
	}
	
}
