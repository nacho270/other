package facade;

import java.util.Collection;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import vo.ActorVO;
import vo.DirectorVO;
import vo.GeneroVO;
import vo.IdiomaVO;
import vo.PeliculaVO;
import vo.UserVO;

import administradores.AdministradorPeliculas;
import administradores.UserAdministrator;
import facade.ServerFacadeVideo;

@Stateless
public class ServerFacadeVideoBean implements ServerFacadeVideo 
{
	@EJB private AdministradorPeliculas admPeliculas;
	@EJB private UserAdministrator admUsuarios;
	
	public void guardarPelicula(PeliculaVO vo)
	{
		admPeliculas.guardarPelicula(vo);
	}
	
	public Collection<PeliculaVO> getPeliculas()
	{
		return admPeliculas.getPeliculas();
	}
	
	public PeliculaVO getPeliculaPorNumero(int cod)
	{
		return admPeliculas.getPeliculaPorNumero(cod);
	}

	public Collection<PeliculaVO> getPeliculasByName(String nombre) 
	{
		return admPeliculas.getPeliculasByName(nombre);
	}

	public boolean existeActor(ActorVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean existeDirector(DirectorVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean existeGenero(GeneroVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean existeIdioma(IdiomaVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean existePelicula(PeliculaVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public Collection<GeneroVO> getGeneros()
	{
		return this.admPeliculas.getGeneros();
	}

	public Collection<IdiomaVO> getIdiomas() 
	{
		return this.admPeliculas.getIdiomas();
	}

	public int getNextIdActor() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNextIdDirector() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNextIdGenero() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNextIdIdioma() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Collection<PeliculaVO> getPeliculasByGenero(String genero) 
	{
		return this.admPeliculas.getPeliculasByGenero(genero);
	}

	public Collection<PeliculaVO> getPeliculasByIdioma(String idioma)
	{
		return this.admPeliculas.getPeliculasByIdioma(idioma);
	}

	public boolean validUser(UserVO vo)
	{
		return this.admUsuarios.validUser(vo);
	}

	public Collection<PeliculaVO> getPeliculasByFecha(Date fecha) 
	{
		return this.admPeliculas.getPeliculasByFecha(fecha);
	}

	public Collection<PeliculaVO> getPeliculasByActor(String nombre) 
	{
		return this.admPeliculas.getPeliculasByActor(nombre);
	}

	public Collection<PeliculaVO> getPeliculasByDirector(String nombre) 
	{
		return this.admPeliculas.getPeliculasByDirector(nombre);
	}

	public Collection<ActorVO> getActorByName(String name)
	{
		return this.admPeliculas.getActorByName(name);
	}
	
	 public Collection<DirectorVO> getDirectorByName(String name)
	 {
		 return this.admPeliculas.getDirectorByName(name);
	 }
}
