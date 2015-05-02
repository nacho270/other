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

public class CargarGenerosServlet extends HttpServlet
{
	private static final long serialVersionUID = -66071875308792108L;
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
	}
}
