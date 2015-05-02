package struts.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import struts.forms.DeleteForm;
import struts.model.BusinessDelegate;

public class DeleteAction extends Action
{
	private BusinessDelegate bd;
	
	public DeleteAction()
	{
		bd = new BusinessDelegate();
	}
	
	public ActionForward execute(ActionMapping mapping,	 ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		DeleteForm f = (DeleteForm)form;
		System.out.println(f.getBorrar().length + "\n" + f.getCodigos().length + "\n\n");
		
		/*for(int i = 0; i<f.getCodigos().length;i++)
			System.out.println(f.getBorrar()[i] + "\n" + f.getCodigos()[i] + "\n\n");*/
		
		return mapping.findForward("success");
	}
}
