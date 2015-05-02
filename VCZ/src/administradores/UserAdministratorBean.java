package administradores;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.User;
import vo.UserVO;
import administradores.UserAdministrator;

@Stateless
public class UserAdministratorBean implements UserAdministrator 
{
	@PersistenceContext(unitName="VideoZetta")
	private EntityManager em;
	
	public boolean validUser(UserVO vo) 
	{
		User u = em.find(User.class, vo.getUserName());
		
		if(u == null) return false;
		else
		{
			if(vo.getPassword().compareTo(u.getPassword()) == 0) return true;
			else return false;
		}
	}
}
