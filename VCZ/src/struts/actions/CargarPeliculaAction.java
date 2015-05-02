package struts.actions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import struts.forms.CargarPeliculaForm;
import struts.model.BusinessDelegate;
import utils.Constantes;
import utils.PeliculasWrapper;
import utils.XMLConverter;

public class CargarPeliculaAction extends Action
{
	private BusinessDelegate bd;
	private String ret;
	
	public CargarPeliculaAction()
	{
		bd = new BusinessDelegate();
		ret = "";
	}
	
	public ActionForward execute(ActionMapping mapping,	 ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		CargarPeliculaForm f = (CargarPeliculaForm) form;
		
		try
		{
			
			PeliculasWrapper p = this.processXMLFile(f.getFileXML());
			ret += "<ul> <li>" + f.getFileXML().getFileName() + "</li></ul><ul>";
			/*for(int i = 0; i< p.getPeliculas().size();i++)
			{
				PeliculaVO voo = p.getPeliculas().get(i);
				bd.guardarPelicula(voo);
			}
			*/
			this.processZIPFile(f.getFileZIP());
			
			request.setAttribute("files", ret);
			return mapping.findForward("success");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return mapping.findForward("failure");
		}
	}
	
	private PeliculasWrapper processXMLFile(FormFile file) throws Exception
	{
		XMLConverter xc = new XMLConverter();
		return xc.getPeliculasWrapperFromXML(file.getInputStream());
	}
	
	private void processZIPFile(FormFile file)throws Exception
	{
		System.out.println("Procesando archivo zip");
        ZipEntry entry = null;
        OutputStream out = null;
        ZipInputStream zip = null;
        
        zip = new ZipInputStream(file.getInputStream());
        entry = zip.getNextEntry();
        
        while (entry != null) 
        {
            out = new FileOutputStream(Constantes.IMG_DIR + entry.getName());
            System.out.println("descomprimiendo-->" + entry.getName());
            ret += "<li>" + entry.getName() + "</li>";
            
            int longitud;
            byte[] buffer = new byte[1024];
            while ((longitud = zip.read(buffer)) > 0) 
                out.write(buffer, 0, longitud);
            
            out.close();
            entry = zip.getNextEntry();
        }
        zip.close();
        file.getInputStream().close();
        ret += "</ul>";
	}
}
