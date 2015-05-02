package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import vo.IdiomaVO;

@Entity
@Table(name="idiomas")
public class Idioma 
{
	private int codigoIdioma;
	private String nombreIdioma;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO, generator = "RHQ_xxx")
	public int getCodigoIdioma() {
		return codigoIdioma;
	}
	public void setCodigoIdioma(int codigoIdioma) {
		this.codigoIdioma = codigoIdioma;
	}
	@Column
	public String getNombreIdioma() {
		return nombreIdioma;
	}
	public void setNombreIdioma(String nombreIdioma) {
		this.nombreIdioma = nombreIdioma;
	}
	
	@Transient
	public IdiomaVO getVO()
	{
		IdiomaVO vo = new IdiomaVO();
		vo.setCodigoIdioma(this.getCodigoIdioma());
		vo.setNombreIdioma(this.getNombreIdioma());
		return vo;
	}
	
	public void setVO(IdiomaVO vo)
	{
		this.setCodigoIdioma(vo.getCodigoIdioma());
		this.setNombreIdioma(vo.getNombreIdioma());
	}
}
