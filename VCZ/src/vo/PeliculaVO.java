package vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class PeliculaVO implements Serializable 
{
	private static final long serialVersionUID = 8836458744138797689L;
	
	private int codigo;
	private String nombre;
	private GeneroVO genero;
	private ArrayList<ActorVO> actores;
	private DirectorVO director;
	private String filePath;
	private String sinopsis;
	private IdiomaVO idioma;
	private Date fechaAlta;
	private boolean mostrar;
	
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public boolean getMostrar() {
		return mostrar;
	}
	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}
	public IdiomaVO getIdioma() {
		return idioma;
	}
	public void setIdioma(IdiomaVO idioma) {
		this.idioma = idioma;
	}
	public ArrayList<ActorVO> getActores() {
		return actores;
	}
	public void setActores(ArrayList<ActorVO> actores) {
		this.actores = actores;
	}
	public DirectorVO getDirector() {
		return director;
	}
	public void setDirector(DirectorVO director) {
		this.director = director;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public GeneroVO getGenero() {
		return genero;
	}
	public void setGenero(GeneroVO genero) {
		this.genero = genero;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
