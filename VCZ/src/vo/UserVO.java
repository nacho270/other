package vo;

import java.io.Serializable;

public class UserVO implements Serializable
{
	private static final long serialVersionUID = 8658095861935412510L;
	
	private String userName;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
