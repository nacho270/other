package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import vo.UserVO;

@Entity
@Table(name="usuarios")
public class User 
{
	private String userName;
	private String password;
		
	@Column
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Id
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Transient
	public UserVO getVO()
	{
		UserVO vo = new UserVO();
		vo.setUserName(this.getUserName());
		vo.setPassword(this.getPassword());
		return vo;
	}
	
	public void setVO(UserVO vo)
	{
		this.setPassword(vo.getPassword());
		this.setUserName(vo.getUserName());
	}
}
