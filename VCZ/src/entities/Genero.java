package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import vo.GeneroVO;

@Entity
@Table(name="generos")
public class Genero 
{
	private int codigoGenero;
	private String nombreGenero;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO, generator = "RHQ_xxx")
	public int getCodigoGenero() {
		return codigoGenero;
	}
	
	public void setCodigoGenero(int codigoGenero) {
		this.codigoGenero = codigoGenero;
	}
	
	@Column
	public String getNombreGenero() {
		return nombreGenero;
	}
	
	public void setNombreGenero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}
	
	@Transient
	public GeneroVO getVO()
	{
		GeneroVO vo = new GeneroVO();
		vo.setCodigoGenero(this.getCodigoGenero());
		vo.setNombreGenero(this.getNombreGenero());
		return vo;
	}
	
	public void setVo(GeneroVO vo)
	{
		this.setCodigoGenero(vo.getCodigoGenero());
		this.setNombreGenero(vo.getNombreGenero());
	}
}
