package administradores;

import javax.ejb.Remote;

import vo.UserVO;

@Remote
public interface UserAdministrator 
{
	public boolean validUser(UserVO vo);
}
