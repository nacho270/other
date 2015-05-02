package struts.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import struts.forms.ResultadosForm;
import struts.model.BusinessDelegate;
import vo.ActorVO;
import vo.DirectorVO;

public class BuscarActoresYDirectoresAction extends Action
{	
	private BusinessDelegate bd;
	
	public BuscarActoresYDirectoresAction()
	{
		bd = new BusinessDelegate();
	}
	
	public ActionForward execute(ActionMapping mapping,	 ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		ResultadosForm f = (ResultadosForm) form;
		
		try
		{
			if(f.getActorInput() == null)
			{
				Collection<DirectorVO> cd = bd.getDirectorByName(f.getDirectorInput());
				Iterator i = cd.iterator();
				ArrayList<DirectorVO> ret = new ArrayList<DirectorVO>();
				
				while(i.hasNext())
				{
					DirectorVO vo = (DirectorVO)i.next();
					ret.add(vo);
				}
				
				f.setDirectores(ret);
			}
			else
			{
				Collection<ActorVO> cd = bd.getActorByName(f.getActorInput());
				Iterator i = cd.iterator();
				ArrayList<ActorVO> ret = new ArrayList<ActorVO>();
				
				while(i.hasNext())
				{
					ActorVO vo = (ActorVO)i.next();
					ret.add(vo);
				}
				
				f.setActores(ret);
			}
			
			return mapping.findForward("success");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return mapping.findForward("failure");
		}
	}
}
