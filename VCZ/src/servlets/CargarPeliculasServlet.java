package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import struts.model.BusinessDelegate;
import vo.ActorVO;
import vo.DirectorVO;
import vo.GeneroVO;
import vo.IdiomaVO;
import vo.PeliculaVO;

public class CargarPeliculasServlet extends HttpServlet
{
	private static final long serialVersionUID = -4236484492078750437L;
	
	@SuppressWarnings("unused")
	private ServletContext context;
	private BusinessDelegate bd;
	
	public void init(ServletConfig config) throws ServletException 
	{
        this.context = config.getServletContext();
       	bd = new BusinessDelegate();
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse  response)throws IOException, ServletException 
	{
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*Collection<PeliculaVO> ret = bd.getPeliculasByFecha(bd.getPeliculaPorNumero(1).getFechaAlta());
		System.out.println("Hay " + ret.size() + " peliculas");
		Iterator ite = ret.iterator();
		
		while(ite.hasNext())
			System.out.println(((PeliculaVO)ite.next()).getNombre());
		*/
		response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write("<peliculas>");
		
		ArrayList<PeliculaVO> pels = (ArrayList<PeliculaVO>)bd.getPeliculas();
		
		if(pels != null)
		{
			System.out.println("hay " + pels.size() + " peliculas");
			for(int i = 0; i<pels.size();i++)
			{
				response.getWriter().write("<pelicula>");
				response.getWriter().write("<codigo>" + pels.get(i).getCodigo() + "</codigo>");
				response.getWriter().write("<nombre>" + pels.get(i).getNombre() + "</nombre>");
				response.getWriter().write("<fecha>"  + pels.get(i).getFechaAlta() + "</fecha>");
				response.getWriter().write("<path>"  + pels.get(i).getFilePath() + "</path>");
				response.getWriter().write("</pelicula>");
			}
		}
		response.getWriter().write("</peliculas>");
		
		this.loadTestMovies();
    }
	
	/**
	 * 
	 * FECHA:
	 * 		-DIA -> NO HAY DRAMA
	 * 		-MES -> 11 MAS DEL QUE QUERES. EJ: PARA DICIEMBRE (12), PONER 23
	 *		-AÑO -> UNO MENOS DEL QUE QUERES. EJ: PARA 2008, PONER 2007
	 *		-PARA DEFINIR UNA FECHA: Date fe = new GregorianCalendar(2007, 23, 23).getTime();
	 */
	
	
	@SuppressWarnings("deprecation")
	private void loadTestMovies()
	{
		System.out.println("Cargo peliculas");
		PeliculaVO pvo = new PeliculaVO();
		
		GeneroVO g = new GeneroVO();
		g.setCodigoGenero(1);
		g.setNombreGenero("accion");
		pvo.setGenero(g);
		
		IdiomaVO i = new IdiomaVO();
		i.setCodigoIdioma(1);
		i.setNombreIdioma("ingles");
		pvo.setIdioma(i);
		
		ArrayList<ActorVO> la = new ArrayList<ActorVO>();
		ActorVO a = new ActorVO();
		a.setCodigoActor(1);
		a.setNombreActor("nacho");
		la.add(a);
		
		a = new ActorVO();
		a.setCodigoActor(2);
		a.setNombreActor("melanie");
		la.add(a);
		
		pvo.setActores(la);
		
		DirectorVO d = new DirectorVO();
		d.setCodigoDirector(1);
		d.setNombreDirector("pepe");
		pvo.setDirector(d);
		
		pvo.setCodigo(1);
		pvo.setFilePath(pvo.getCodigo() + ".jpg");
		pvo.setNombre("pelicula 1");
		pvo.setSinopsis("se trata de una pelicula de prueba para los testers");
		Date fe = new GregorianCalendar(2007, 23, 23).getTime();

		/*Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2008 + 1900);
		c.set(Calendar.MONTH, 12);
		c.set(Calendar.DAY_OF_MONTH, 23);
		fe.*/
		
		pvo.setFechaAlta(fe);
		pvo.setMostrar(true);
		
		if(bd.getPeliculaPorNumero(1) == null)
			bd.guardarPelicula(pvo);
		
		pvo = new PeliculaVO();
		
		g = new GeneroVO();
		g.setCodigoGenero(2);
		g.setNombreGenero("suspenso");
		pvo.setGenero(g);
		
		i = new IdiomaVO();
		i.setCodigoIdioma(2);
		i.setNombreIdioma("castellano");
		pvo.setIdioma(i);
		
		la = new ArrayList<ActorVO>();
		a = new ActorVO();
		a.setCodigoActor(3);
		a.setNombreActor("jose");
		la.add(a);
		
		a = new ActorVO();
		a.setCodigoActor(4);
		a.setNombreActor("sol");
		la.add(a);
		
		pvo.setActores(la);
		
		d = new DirectorVO();
		d.setCodigoDirector(2);
		d.setNombreDirector("lolo");
		pvo.setDirector(d);
		
		pvo.setCodigo(2);
		pvo.setFilePath(pvo.getCodigo() + ".jpg");
		pvo.setNombre("pelicula 2");
		pvo.setSinopsis("se trata de otra pelicula de prueba para los testers");
		fe = new GregorianCalendar(2007, 23, 1).getTime();
		pvo.setFechaAlta(fe);
		pvo.setMostrar(false);
		
		if(bd.getPeliculaPorNumero(2) == null)
			bd.guardarPelicula(pvo);
	}
}
