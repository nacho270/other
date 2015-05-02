package struts.forms;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm
{
	private static final long serialVersionUID = -3218402671851135891L;
	
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
