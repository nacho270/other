package administradores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Actor;
import entities.Director;
import entities.Genero;
import entities.Idioma;
import entities.Pelicula;
import vo.ActorVO;
import vo.DirectorVO;
import vo.GeneroVO;
import vo.IdiomaVO;
import vo.PeliculaVO;
import administradores.AdministradorPeliculas;

@Stateless
public class AdministradorPeliculasBean implements AdministradorPeliculas 
{
	@PersistenceContext(unitName="VideoZetta")
	private EntityManager em;

	public void guardarPelicula(PeliculaVO vo) 
	{
		Pelicula p = new Pelicula();
		p.setVO(vo);
		em.persist(p);
	}

	public Collection<PeliculaVO> getPeliculas() 
	{
		Query q = em.createQuery("SELECT p FROM Pelicula p");
		List l = q.getResultList();
		ArrayList<PeliculaVO> ret = new ArrayList<PeliculaVO>();
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			PeliculaVO vo = ((Pelicula)it.next()).getVO();
			ret.add(vo);
		}
		
		return ret;
	}

	public PeliculaVO getPeliculaPorNumero(int cod) 
	{
		Pelicula p = em.find(Pelicula.class, cod);
		
		if(p != null) return p.getVO();
		else return null;
	}

	public Collection<PeliculaVO> getPeliculasByName(String nombre) 
	{
		Query q = em.createQuery("SELECT p FROM Pelicula p WHERE p.nombre LIKE ?1");
		q.setParameter(1,"%" + nombre + "%");
		List l = q.getResultList();
		ArrayList<PeliculaVO> ret = new ArrayList<PeliculaVO>();
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			PeliculaVO vo = ((Pelicula)it.next()).getVO();
			ret.add(vo);
		}
		
		return ret;
	}
	
	public Collection<PeliculaVO> getPeliculasByGenero(String genero) 
	{
		Query q = em.createQuery("SELECT p FROM Pelicula p WHERE p.genero.nombreGenero =:name");
		q.setParameter("name",genero);
		List l = q.getResultList();
		ArrayList<PeliculaVO> ret = new ArrayList<PeliculaVO>();
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			PeliculaVO vo = ((Pelicula)it.next()).getVO();
			ret.add(vo);
		}
		
		return ret;
	}

	public Collection<PeliculaVO> getPeliculasByIdioma(String idioma)
	{
		Query q = em.createQuery("SELECT p FROM Pelicula p WHERE p.idioma.nombreIdioma =:name");
		q.setParameter("name",idioma);
		List l = q.getResultList();
		ArrayList<PeliculaVO> ret = new ArrayList<PeliculaVO>();
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			PeliculaVO vo = ((Pelicula)it.next()).getVO();
			ret.add(vo);
		}
		
		return ret;
	}

	public int getNextIdActor()
	{
		Query q = em.createQuery("SELECT MAX(a.codigoActor) FROM Actor a");
		List l = q.getResultList();
		if(l.get(0) == null){
			return 1;
		}else{
			int a = (Integer) l.get(0);
			return a+1;
		}
	}

	public int getNextIdDirector() 
	{
		Query q = em.createQuery("SELECT MAX(d.codigoDirector) FROM Director d");
		List l = q.getResultList();
		if(l.get(0) == null){
			return 1;
		}else{
			int a = (Integer) l.get(0);
			return a+1;
		}
	}

	public int getNextIdGenero() 
	{
		Query q = em.createQuery("SELECT MAX(g.codigoGenero) FROM Genero g");
		List l = q.getResultList();
		if(l.get(0) == null){
			return 1;
		}else{
			int a = (Integer) l.get(0);
			return a+1;
		}
	}
	
	public int getNextIdIdioma() 
	{
		Query q = em.createQuery("SELECT MAX(i.codigoIdioma) FROM Idioma i");
		List l = q.getResultList();
		if(l.get(0) == null){
			return 1;
		}else{
			int a = (Integer) l.get(0);
			return a+1;
		}
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

	public boolean existePelicula(PeliculaVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean existeIdioma(IdiomaVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public Collection<GeneroVO> getGeneros()
	{
		Query q = em.createQuery("SELECT g FROM Genero g");
		List l = q.getResultList();
		ArrayList<GeneroVO> ret = new ArrayList<GeneroVO>();
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			GeneroVO vo = ((Genero)it.next()).getVO();
			ret.add(vo);
		}
		
		return ret;
	}

	public Collection<IdiomaVO> getIdiomas() 
	{
		Query q = em.createQuery("SELECT i FROM Idioma i");
		List l = q.getResultList();
		ArrayList<IdiomaVO> ret = new ArrayList<IdiomaVO>();
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			IdiomaVO vo = ((Idioma)it.next()).getVO();
			ret.add(vo);
		}
		
		return ret;
	}

	public Collection<PeliculaVO> getPeliculasByFecha(Date fecha) 
	{
		Query q = em.createQuery("SELECT p FROM Pelicula p WHERE p.fechaAlta < :fecha");
		q.setParameter("fecha",fecha);
		List l = q.getResultList();
		ArrayList<PeliculaVO> ret = new ArrayList<PeliculaVO>();
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			PeliculaVO vo = ((Pelicula)it.next()).getVO();
			ret.add(vo);
		}
		
		return ret;
	}

	
	public Collection<PeliculaVO> getPeliculasByActor(String nombre) 
	{
		//Query q = em.createQuery("SELECT p FROM Pelicula p, IN (p.actores) allactores, Actor a WHERE a.nombreActor LIKE ?1 AND a MEMBER OF allactores");
		//q.setParameter(1,"%" + nombre + "%");
		//Query q = em.createQuery("SELECT p FROM Pelicula p"); //anda pero es chapusa
		Query q = em.createQuery("SELECT p FROM Pelicula p, Actor a WHERE a.nombreActor LIKE ?1 AND a MEMBER OF p.actores");
		q.setParameter(1,"%" + nombre + "%");
		List l = q.getResultList();
		ArrayList<PeliculaVO> ret = new ArrayList<PeliculaVO>();
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			PeliculaVO vo = ((Pelicula)it.next()).getVO();
			
			/*Collection<ActorVO> actores = vo.getActores(); // para que funque, descomentar esto y lo chapusa....comentar el resto
			Iterator iter = actores.iterator();
			
			while(iter.hasNext())
			{
				ActorVO avo = (ActorVO)iter.next();
				
				if(avo.getNombreActor().contains(nombre))
				{
					if(!(ret.contains(vo)))
							ret.add(vo);
				}					
			}*/
			ret.add(vo);
		}
		
		return ret;	
	}
	
	public Collection<PeliculaVO> getPeliculasByDirector(String nombre)
	{
		Query q = em.createQuery("SELECT p FROM Pelicula p WHERE p.director.nombreDirector LIKE ?1");
		q.setParameter(1,"%" + nombre + "%");
		List l = q.getResultList();
		ArrayList<PeliculaVO> ret = new ArrayList<PeliculaVO>();
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			PeliculaVO vo = ((Pelicula)it.next()).getVO();
			ret.add(vo);
		}
		
		return ret;
	}

	public Collection<ActorVO> getActorByName(String name) 
	{
		Query q = em.createQuery("SELECT a FROM Actor a WHERE a.nombreActor LIKE ?1");
		q.setParameter(1,"%" + name + "%");
		List l = q.getResultList();
		ArrayList<ActorVO> ret = new ArrayList<ActorVO>();
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			ActorVO vo = ((Actor)it.next()).getVO();
			ret.add(vo);
		}
		
		return ret;
	}
	
	public Collection<DirectorVO> getDirectorByName(String name) 
	{
		Query q = em.createQuery("SELECT d FROM Director d WHERE d.nombreDirector LIKE ?1");
		q.setParameter(1,"%" + name + "%");
		List l = q.getResultList();
		ArrayList<DirectorVO> ret = new ArrayList<DirectorVO>();
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			DirectorVO vo = ((Director)it.next()).getVO();
			ret.add(vo);
		}
		
		return ret;
	}
}
