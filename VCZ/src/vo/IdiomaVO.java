package vo;

import java.io.Serializable;

public class IdiomaVO implements Serializable
{
	private static final long serialVersionUID = -8744213848332990258L;
	
	private int codigoIdioma;
	private String nombreIdioma;
	public int getCodigoIdioma() {
		return codigoIdioma;
	}
	public void setCodigoIdioma(int codigoIdioma) {
		this.codigoIdioma = codigoIdioma;
	}
	public String getNombreIdioma() {
		return nombreIdioma;
	}
	public void setNombreIdioma(String nombreIdioma) {
		this.nombreIdioma = nombreIdioma;
	}
}
