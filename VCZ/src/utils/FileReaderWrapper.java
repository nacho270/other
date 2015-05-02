/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.DataInputStream;
import java.io.InputStream;

public class FileReaderWrapper 
{
	@SuppressWarnings("deprecation")
	public String obtenerContenido(InputStream file)
	{
		StringBuffer contenido = new StringBuffer();
		try
		{
			DataInputStream input = new DataInputStream(file);
			
			while (input.available() !=0)
				contenido.append(input.readLine());
			
			input.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error al leer el contenido del archivo");
		}
		return contenido.toString();
	}
}
