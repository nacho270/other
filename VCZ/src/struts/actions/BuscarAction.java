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

import strategies.BuscarPorActor;
import strategies.BuscarPorDirector;
import strategies.BuscarPorGenero;
import strategies.BuscarPorIdioma;
import strategies.BuscarPorNombre;
import strategies.BuscarPorNumero;
import strategies.EstrategiaDeBusqueda;
import struts.forms.BuscarPeliculaForm;
import struts.model.BusinessDelegate;
import vo.ActorVO;
import vo.DirectorVO;

public class BuscarAction extends Action
{
	private BusinessDelegate bd;
	private EstrategiaDeBusqueda busqueda;
	
	public BuscarAction()
	{
		bd = new BusinessDelegate();
	}
	
	private ArrayList<ActorVO> buscarActores(String name)
	{
		System.out.println("busco por actor");
		Collection<ActorVO> cd = bd.getActorByName(name);
		Iterator i = cd.iterator();
		ArrayList<ActorVO> ret = new ArrayList<ActorVO>();
		
		while(i.hasNext())
		{
			ActorVO vo = (ActorVO)i.next();
			ret.add(vo);
		}
		
		return ret;
	}
	
	private ArrayList<DirectorVO> buscarDirectores(String name)
	{
		System.out.println("busco por director");
		Collection<DirectorVO> cd = bd.getDirectorByName(name);
		Iterator i = cd.iterator();
		ArrayList<DirectorVO> ret = new ArrayList<DirectorVO>();
		
		while(i.hasNext())
		{
			DirectorVO vo = (DirectorVO)i.next();
			ret.add(vo);
		}
		
		return ret;
	}
	
	public ActionForward execute(ActionMapping mapping,	 ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		BuscarPeliculaForm f = (BuscarPeliculaForm)form;
		String select = f.getSelect();

		try
		{
			if(select.equalsIgnoreCase("actor"))
			{
				f.setActores(this.buscarActores(f.getInput()));
				return mapping.findForward("actoresydirectores");
			}
			else
			{
				if(select.equalsIgnoreCase("director"))
				{					
					f.setDirectores(this.buscarDirectores(f.getInput()));
					return mapping.findForward("actoresydirectores");
				}
				else
				{
					if(select.equalsIgnoreCase("nombre"))
					{
						busqueda = new BuscarPorNombre(bd);
						f.setPels(busqueda.buscar(f.getInput()));
						return mapping.findForward("actoresydirectores");
					}
					else
					{
						if(select.equalsIgnoreCase("numero"))
						{
							busqueda = new BuscarPorNumero(bd);
							f.setPelicula(busqueda.buscar(f.getInput()).get(0));
							return mapping.findForward("pelicula");
						}
						else
						{
							if(select.equalsIgnoreCase("idioma"))
							{
								busqueda = new BuscarPorIdioma(bd);
								f.setPels(busqueda.buscar(f.getInput()));
								return mapping.findForward("actoresydirectores");
							}
							else
							{
								if(select.equalsIgnoreCase("genero"))
								{
									busqueda = new BuscarPorGenero(bd);
									f.setPels(busqueda.buscar(f.getInput()));
									return mapping.findForward("actoresydirectores");
								}
								else
								{
									if(select.equalsIgnoreCase("peliculasActor"))
									{
										busqueda = new BuscarPorActor(bd);
										f.setPels(busqueda.buscar(f.getInput()));
										return mapping.findForward("actoresydirectores");
									}
									else
									{
										if(select.equalsIgnoreCase("peliculasDirector"))
										{
											busqueda = new BuscarPorDirector(bd);
											f.setPels(busqueda.buscar(f.getInput()));
											return mapping.findForward("actoresydirectores");
										}
									}
								}
							}
						}
					}
				}
			}
			
			return mapping.findForward("failure");
		}
		catch(Exception e)
		{
			return mapping.findForward("failure");
		}
	}
}

