package kr.ac.ajou.dsd.kda.model;

import kr.ac.ajou.dsd.kda.util.PasswordUtil;

public class User {
	
	private String username;
	private String email;
	private String salt;
	private String pwHashed;

	public boolean checkPassword(String password) {
		return PasswordUtil.checkPassword(this.pwHashed, this.salt, password);
	}

	public void setPassword(String password) {
		this.salt = PasswordUtil.getRandomString(32);
		this.pwHashed = PasswordUtil.encoder.encodeToString(PasswordUtil.createPasswordHash(password, salt));
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
