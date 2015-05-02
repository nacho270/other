package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import struts.model.BusinessDelegate;
import vo.GeneroVO;
import vo.IdiomaVO;

public class CargarDataServlet extends HttpServlet
{
	private static final long serialVersionUID = -767977669031930949L;
	
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
		response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write("<data>");
        response.getWriter().write("<idiomas>");
		
		ArrayList<IdiomaVO> idiomas = (ArrayList<IdiomaVO>)bd.getIdiomas();
		
		if(idiomas != null)
		{
			for(int i = 0; i<idiomas.size();i++)
			{
				response.getWriter().write("<idioma>");
				response.getWriter().write("<nombre>" + idiomas.get(i).getNombreIdioma() + "</nombre>");
				response.getWriter().write("</idioma>");
			}
		}
		response.getWriter().write("</idiomas>");
		
		response.getWriter().write("<generos>");
		
		ArrayList<GeneroVO> generos = (ArrayList<GeneroVO>)bd.getGeneros();
		
		if(generos != null)
		{
			for(int i = 0; i<generos.size();i++)
			{
				response.getWriter().write("<genero>");
				response.getWriter().write("<nombre>" + generos.get(i).getNombreGenero() + "</nombre>");
				response.getWriter().write("</genero>");
			}
		}
		response.getWriter().write("</generos>");
		response.getWriter().write("</data>");
	}

}
