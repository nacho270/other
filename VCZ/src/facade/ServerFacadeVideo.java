package facade;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Remote;

import vo.ActorVO;
import vo.DirectorVO;
import vo.GeneroVO;
import vo.IdiomaVO;
import vo.PeliculaVO;
import vo.UserVO;

@Remote
public interface ServerFacadeVideo 
{
	public void guardarPelicula(PeliculaVO vo);
	public Collection<PeliculaVO> getPeliculas();
	public PeliculaVO getPeliculaPorNumero(int cod);
	public Collection<PeliculaVO> getPeliculasByName(String nombre);
	public Collection<PeliculaVO> getPeliculasByIdioma(String idioma);
	public Collection<PeliculaVO> getPeliculasByGenero(String genero);
	public Collection<PeliculaVO> getPeliculasByFecha(Date fecha);
	public Collection<PeliculaVO> getPeliculasByActor(String nombre);
	public Collection<PeliculaVO> getPeliculasByDirector(String nombre);
	public Collection<ActorVO> getActorByName(String name);
	public Collection<DirectorVO> getDirectorByName(String name);
	public int getNextIdGenero();
	public int getNextIdDirector();
	public int getNextIdActor();
	public int getNextIdIdioma();
	public boolean existeActor(ActorVO vo);
	public boolean existeDirector(DirectorVO vo);
	public boolean existeGenero(GeneroVO vo);
	public boolean existePelicula(PeliculaVO vo);
	public boolean existeIdioma(IdiomaVO vo);
	public Collection<IdiomaVO> getIdiomas();
	public Collection<GeneroVO> getGeneros();
	public boolean validUser(UserVO vo);
}
