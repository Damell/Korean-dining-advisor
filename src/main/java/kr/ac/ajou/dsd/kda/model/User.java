package kr.ac.ajou.dsd.kda.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.DatatypeConverter;

import kr.ac.ajou.dsd.kda.util.PasswordUtil;


/**
 * @author all team
 */
@Entity
public class User {
	
	@Id
	private String username;
	
	
	private String email;
	private String salt;
	private String pwHashed;


	/**
	 * checks password by generating hash of clear text password combined with salt and compares it to hashed password saved in the database
	 * @param password by user input 
	 * @return boolean true if password matches
	 */
	public boolean checkPassword(String password) {
		return PasswordUtil.checkPassword(this.pwHashed, this.salt, password);
	}

	/**
	 * set password by hashing with password and salt
	 * @param password by user input
	 * 
	 */
	public void setPassword(String password) {
		this.salt = PasswordUtil.getRandomString(32);
		this.pwHashed = DatatypeConverter.printBase64Binary(PasswordUtil.createPasswordHash(password, salt));
	}

	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		setPassword(password);
	}

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getSalt() {
		return salt;
	}

}
