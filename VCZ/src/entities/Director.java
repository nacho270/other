package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import vo.DirectorVO;

@Entity
@Table(name="directores")
public class Director 
{
	private int codigoDirector;
	private String nombreDirector;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO, generator = "RHQ_xxx")
	public int getCodigoDirector() {
		return codigoDirector;
	}
	public void setCodigoDirector(int codigoDirector) {
		this.codigoDirector = codigoDirector;
	}
	
	@Column
	public String getNombreDirector() {
		return nombreDirector;
	}
	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}
	
	@Transient
	public DirectorVO getVO()
	{
		DirectorVO vo = new DirectorVO();
		vo.setCodigoDirector(this.getCodigoDirector());
		vo.setNombreDirector(this.getNombreDirector());
		return vo;
	}
	
	public void setVO(DirectorVO vo)
	{
		this.setCodigoDirector(vo.getCodigoDirector());
		this.setNombreDirector(vo.getNombreDirector());
	}
}
