package ar.com.iglesias.web.action;

import javax.ejb.Local;

@Local
public interface DatosBasicosMiembro {

	public void fillSexos();

	public void fillEstadosCiviles();

	public void fillProvincias();
	
	public void destroy();
	
}