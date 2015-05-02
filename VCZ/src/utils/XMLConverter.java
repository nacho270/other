package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class XMLConverter 
{
	public PeliculasWrapper getPeliculasWrapperFromXML(InputStream file)
	{
		FileReaderWrapper frw = new FileReaderWrapper();
		String xml = frw.obtenerContenido(file);
		System.out.println(xml);
		
		SAXBuilder builder = new SAXBuilder();
		Reader in = new StringReader(xml);
		Document doc;
		
		try 
		{
			doc = builder.build(in);
			Element root = doc.getRootElement();
			List items = root.getChildren();
			
			if(items != null)
			{
				System.out.println("llegue al converter y los items no son null");
				
				for(Object cliente : items)
				{
					System.out.println("Nombre: " + ((Element)cliente).getChild("nombre").getText());
					System.out.println("Apellido: " + ((Element)cliente).getChild("apellido").getText());
					System.out.println("Sueldo: " + ((Element)cliente).getChild("sueldo").getText());
					System.out.println("================================");
				}
			}
			else System.out.println("llegue al converter y los items SON null fuck");
		}
		catch (JDOMException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
