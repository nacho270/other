package vo;

import java.io.Serializable;

public class ActorVO implements Serializable
{
	private static final long serialVersionUID = 1501204704871494675L;
	
	private int codigoActor;
	private String nombreActor;
	public int getCodigoActor() {
		return codigoActor;
	}
	public void setCodigoActor(int codigoActor) {
		this.codigoActor = codigoActor;
	}
	public String getNombreActor() {
		return nombreActor;
	}
	public void setNombreActor(String nombreActor) {
		this.nombreActor = nombreActor;
	}
}
