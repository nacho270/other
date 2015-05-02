package entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import vo.ActorVO;
import vo.PeliculaVO;

@Entity
@Table(name="Peliculas")
public class Pelicula 
{
	private int codigo;
	private String nombre;
	private Genero genero;
	private Collection<Actor> actores;
	private Director director;
	private String filePath;
	private String sinopsis;
	private Idioma idioma;
	private Date fechaAlta;
	private boolean mostrar;
	
	@Temporal(TemporalType.DATE)
	public Date getFechaAlta() {
		return fechaAlta;
	}

	@Column
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public boolean getMostrar() {
		return mostrar;
	}

	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}

	@OneToOne(cascade={CascadeType.ALL})
	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	@Column
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Column
	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	@OneToOne(cascade={CascadeType.ALL})
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Id
	@Column
	public int getCodigo() 
	{
		return codigo;
	}
	
	public void setCodigo(int codigo) 
	{
		this.codigo = codigo;
	}
	
	@Column
	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	@Transient
	public PeliculaVO getVO()
	{
		PeliculaVO vo = new PeliculaVO();
		vo.setCodigo(this.getCodigo());
		vo.setNombre(this.getNombre());
		vo.setDirector(this.getDirector().getVO());
		vo.setFilePath(this.getFilePath());
		vo.setGenero(this.getGenero().getVO());
		vo.setSinopsis(this.getSinopsis());
		
		Iterator it = this.getActores().iterator();
		ArrayList<ActorVO> actoresvo = new ArrayList<ActorVO>();
		
		while(it.hasNext())
			actoresvo.add(((Actor)it.next()).getVO());
		vo.setActores(actoresvo);
		vo.setIdioma(this.getIdioma().getVO());
		vo.setFechaAlta(this.getFechaAlta());
		vo.setMostrar(this.getMostrar());
		
		return vo;
	}
	
	public void setVO(PeliculaVO vo)
	{
		this.setCodigo(vo.getCodigo());
		this.setNombre(vo.getNombre());
		this.setFilePath(vo.getFilePath());
		this.setSinopsis(vo.getSinopsis());
		
		Idioma i = new Idioma();
		i.setVO(vo.getIdioma());
		this.setIdioma(i);
		
		Director d = new Director();
		d.setVO(vo.getDirector());
		this.setDirector(d);
		
		Genero g = new Genero();
		g.setVo(vo.getGenero());
		this.setGenero(g);
		
		Collection<Actor> actores = new ArrayList<Actor>();
		Iterator it = vo.getActores().iterator();
		
		while(it.hasNext())
		{
			Actor a = new Actor();
			a.setVO((ActorVO)it.next());
			actores.add(a);
		}
		
		this.setActores(actores);
		
		this.setMostrar(vo.getMostrar());
		this.setFechaAlta(vo.getFechaAlta());
	}

	@OneToMany(cascade={CascadeType.ALL})
	public Collection<Actor> getActores() {
		return actores;
	}

	public void setActores(Collection<Actor> actores) {
		this.actores = actores;
	}

	@OneToOne(cascade={CascadeType.ALL})
	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}
}
