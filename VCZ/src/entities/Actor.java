package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import vo.ActorVO;

@Entity
@Table(name="actores")
public class Actor 
{
	private int codigoActor;
	private String nombreActor;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO, generator="x")
	public int getCodigoActor() {
		return codigoActor;
	}
	public void setCodigoActor(int codigoActor) {
		this.codigoActor = codigoActor;
	}
	
	@Column
	public String getNombreActor() {
		return nombreActor;
	}
	public void setNombreActor(String nombreActor) {
		this.nombreActor = nombreActor;
	}
	
	@Transient
	public ActorVO getVO()
	{
		ActorVO vo = new ActorVO();
		vo.setCodigoActor(this.getCodigoActor());
		vo.setNombreActor(this.getNombreActor());
		return vo;
	}
	
	public void setVO(ActorVO vo)
	{
		this.setCodigoActor(vo.getCodigoActor());
		this.setNombreActor(vo.getNombreActor());
	}
}
