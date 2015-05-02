package struts.actions;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import struts.forms.LoginForm;
import struts.model.BusinessDelegate;
import vo.UserVO;

public class LoginAction extends Action
{
	private BusinessDelegate bd;
	
	public LoginAction()
	{
		bd = new BusinessDelegate();
	}
	
	public ActionForward execute(ActionMapping mapping,	 ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		LoginForm f = (LoginForm)form;
		HttpSession ses = request.getSession(true);
		
		String user = f.getUserName();
		String pass = new BigInteger(getHash(f.getPassword(),"MD5")).toString(16);
		UserVO vo = new UserVO();
		vo.setUserName(user);
		vo.setPassword(pass);
		
		response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
		response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
		response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
		response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
		
		if(bd.validUser(vo))
		{
			//request.setAttribute("login", "si");
			ses.setAttribute("login", "si");
			ses.setAttribute("user", user);
			return mapping.findForward("success");
		}
		else
		{
			//request.setAttribute("login", "no");
			ses.setAttribute("login", "no");
			return mapping.findForward("failure");
		}
	}
	
	private byte[] getHash(String mensaje,String algoritmo) 
	{
	   try
	   {
			MessageDigest md = MessageDigest.getInstance(algoritmo);
			byte [] hash = md.digest(mensaje.getBytes());
			return (hash);
	   }
	   catch (Exception e)	
	   {
		   System.out.println(e);
	   }
	   return null;
	}
}
