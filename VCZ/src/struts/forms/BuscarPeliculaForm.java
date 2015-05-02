package struts.forms;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import vo.ActorVO;
import vo.DirectorVO;
import vo.PeliculaVO;

public class BuscarPeliculaForm extends ActionForm
{
	private static final long serialVersionUID = -3520427461458495759L;
	
	private int codigo;
	private PeliculaVO pelicula;
	
	private String nombre;
	private String idioma;
	private String genero;
	private String actor;
	private String director;
	
	private String select;
	private String input;
	
	private ArrayList<PeliculaVO> pels;
	
	private ArrayList<ActorVO> actores;
	private ArrayList<DirectorVO> directores;
	
	public ArrayList<ActorVO> getActores() {
		return actores;
	}
	public void setActores(ArrayList<ActorVO> actores) {
		this.actores = actores;
	}
	public ArrayList<DirectorVO> getDirectores() {
		return directores;
	}
	public void setDirectores(ArrayList<DirectorVO> directores) {
		this.directores = directores;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<PeliculaVO> getPels() {
		return pels;
	}
	public void setPels(ArrayList<PeliculaVO> pels) {
		this.pels = pels;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public PeliculaVO getPelicula() {
		return pelicula;
	}
	public void setPelicula(PeliculaVO pelicula) {
		this.pelicula = pelicula;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
}
