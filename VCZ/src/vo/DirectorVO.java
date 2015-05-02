package vo;

import java.io.Serializable;

public class DirectorVO implements Serializable
{
	private static final long serialVersionUID = 1613509888446414627L;
	
	private int codigoDirector;
	private String nombreDirector;
	public int getCodigoDirector() {
		return codigoDirector;
	}
	public void setCodigoDirector(int codigoDirector) {
		this.codigoDirector = codigoDirector;
	}
	public String getNombreDirector() {
		return nombreDirector;
	}
	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}
}
