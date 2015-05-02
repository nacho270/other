package vo;

import java.io.Serializable;

public class GeneroVO implements Serializable
{
	private static final long serialVersionUID = 6377151501791934549L;
	
	private int codigoGenero;
	private String nombreGenero;
	
	public int getCodigoGenero() {
		return codigoGenero;
	}
	
	public void setCodigoGenero(int codigoGenero) {
		this.codigoGenero = codigoGenero;
	}
	

	public String getNombreGenero() {
		return nombreGenero;
	}
	
	public void setNombreGenero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}
}
