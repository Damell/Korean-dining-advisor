package kr.ac.ajou.dsd.kda.model;

public class User implements IUser {
	
	private String userName;
	private String eMail;
	private String passWord;
	private String salt;
	private String pwHashed;
	


	public String getPwHashed() {
		return pwHashed;
	}

	public void setPwHashed(String pwHashed) {
		this.pwHashed = pwHashed;
	}

	public User(String userName, String eMail, String passWord) {
		super();
		this.userName = userName;
		this.eMail = eMail;
		this.passWord = passWord;
		this.salt = Creatpassword.getRandomString(32);
		this.pwHashed = Creatpassword.encoder.encodeToString(Creatpassword.createPasswordHash(passWord, salt));
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	
	
	

}
