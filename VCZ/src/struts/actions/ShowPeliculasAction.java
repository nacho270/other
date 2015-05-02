package struts.actions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import struts.forms.ShowPeliculasForm;
import struts.model.BusinessDelegate;
import vo.PeliculaVO;

public class ShowPeliculasAction extends Action
{
private BusinessDelegate bd;
	
	public ShowPeliculasAction()
	{
		bd = new BusinessDelegate();
	}
	
	public ActionForward execute(ActionMapping mapping,	 ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		ArrayList<PeliculaVO> pels = (ArrayList<PeliculaVO>)bd.getPeliculas();
		
		if(pels != null)
		{
			ShowPeliculasForm f = (ShowPeliculasForm)form;
			f.setPeliculas(pels);
			return mapping.findForward("success");
		}
		else return mapping.findForward("failure");
	}
}
