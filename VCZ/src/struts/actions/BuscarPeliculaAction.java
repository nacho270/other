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

import struts.forms.BuscarPeliculaForm;
import struts.model.BusinessDelegate;
import vo.PeliculaVO;

public class BuscarPeliculaAction extends Action
{
	private BusinessDelegate bd;
	
	public BuscarPeliculaAction()
	{
		bd = new BusinessDelegate();
	}
	
	public ActionForward execute(ActionMapping mapping,	 ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		try
		{
			BuscarPeliculaForm f = (BuscarPeliculaForm)form;
			int codigo = 0;
			
			if(request.getParameter("n") != null) codigo = Integer.parseInt(request.getParameter("n"));
			else codigo = f.getCodigo();
			
			PeliculaVO vo = bd.getPeliculaPorNumero(codigo);
			
			if(vo!=null)
			{
				f.setPelicula(vo);
				return mapping.findForward("success");
			}
			
			return mapping.findForward("failure");
			
//			if(f.getNombre() != null)
//			{
//				System.out.println("Busco por nombre");
//				Collection<PeliculaVO> pelsco = bd.getPeliculasByName(f.getNombre());
//				ArrayList<PeliculaVO> pels = new ArrayList<PeliculaVO>();
//				
//				if(pelsco != null)
//				{
//					Iterator i = pelsco.iterator();
//					
//					while(i.hasNext())
//					{
//						PeliculaVO vo = (PeliculaVO)i.next();
//						pels.add(vo);
//					}
//					
//					System.out.println("Encontre " + pels.size());
//					
//					f.setPels(pels);
//				}
//				return mapping.findForward("success");
//			}
//			else
//			{
//				if(f.getActor()!=null)
//				{
//					System.out.println("Busco por actor");
//					Collection<PeliculaVO> pelsco = bd.getPeliculasByActor(f.getActor());
//					ArrayList<PeliculaVO> pels = new ArrayList<PeliculaVO>();
//					
//					if(pelsco != null)
//					{
//						Iterator i = pelsco.iterator();
//						
//						while(i.hasNext())
//						{
//							PeliculaVO vo = (PeliculaVO)i.next();
//							pels.add(vo);
//						}
//						
//						System.out.println("Encontre " + pels.size());
//						
//						f.setPels(pels);
//					}
//					return mapping.findForward("success");
//				}
//				else
//				{
//					if(f.getGenero()!=null)
//					{
//						System.out.println("Busco por genero");
//						Collection<PeliculaVO> pelsco = bd.getPeliculasByGenero(f.getGenero());
//						ArrayList<PeliculaVO> pels = new ArrayList<PeliculaVO>();
//						
//						if(pelsco != null)
//						{
//							Iterator i = pelsco.iterator();
//							
//							while(i.hasNext())
//							{
//								PeliculaVO vo = (PeliculaVO)i.next();
//								pels.add(vo);
//							}
//							
//							System.out.println("Encontre " + pels.size());
//							
//							f.setPels(pels);
//						}
//						return mapping.findForward("success");
//					}
//					else
//					{
//						if(f.getIdioma()!= null)
//						{
//							System.out.println("Busco por idioma");
//							Collection<PeliculaVO> pelsco = bd.getPeliculasByIdioma(f.getIdioma());
//							ArrayList<PeliculaVO> pels = new ArrayList<PeliculaVO>();
//							
//							if(pelsco != null)
//							{
//								Iterator i = pelsco.iterator();
//								
//								while(i.hasNext())
//								{
//									PeliculaVO vo = (PeliculaVO)i.next();
//									pels.add(vo);
//								}
//								
//								System.out.println("Encontre " + pels.size());
//								
//								f.setPels(pels);
//							}
//							return mapping.findForward("success");
//						}
//						else
//						{
//							if(f.getDirector()!= null)
//							{
//								System.out.println("Busco por director");
//								Collection<PeliculaVO> pelsco = bd.getPeliculasByDirector(f.getDirector());
//								ArrayList<PeliculaVO> pels = new ArrayList<PeliculaVO>();
//								
//								if(pelsco != null)
//								{
//									Iterator i = pelsco.iterator();
//									
//									while(i.hasNext())
//									{
//										PeliculaVO vo = (PeliculaVO)i.next();
//										pels.add(vo);
//									}
//									
//									System.out.println("Encontre " + pels.size());
//									
//									f.setPels(pels);
//								}
//								return mapping.findForward("success");
//							}
//							else
//							{
//								System.out.println("Busco por numero");
//								PeliculaVO vo = bd.getPeliculaPorNumero(f.getCodigo());
//								
//								if(vo != null)
//								{
//									f.setPelicula(vo);
//									return mapping.findForward("success");
//								}
//							}
//						}
//					}
//				}
//			
//			}
//			return mapping.findForward("success");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return mapping.findForward("failure");
		}
	}
}