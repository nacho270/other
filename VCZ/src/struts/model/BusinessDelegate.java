package struts.model;

import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import utils.Constantes;
import vo.ActorVO;
import vo.DirectorVO;
import vo.GeneroVO;
import vo.IdiomaVO;
import vo.PeliculaVO;
import vo.UserVO;
import facade.ServerFacadeVideo;

public class BusinessDelegate 
{
	private ServerFacadeVideo modCD = null;
	private String naming = Constantes.BEAN_STRING;
	
	public BusinessDelegate()
	{
		super();
		this.getConnection();
	}
	
	
	@SuppressWarnings("unchecked")
	protected void getConnection()
	{
		try
		{
	    	Hashtable props = new Hashtable();
			props.put(InitialContext.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			props.put(InitialContext.PROVIDER_URL,"jnp://"+Constantes.IP_VIDEO + ":1099");
			InitialContext context = new InitialContext(props);
			this.modCD = (ServerFacadeVideo) context.lookup(naming);
		}
		catch (Exception e) 
		{
			System.out.println("puteo el lookup");
			e.printStackTrace();
		}
    }    
	 
    @SuppressWarnings("unused")
	private static Context getInitialContext() throws javax.naming.NamingException 
	{
        return new javax.naming.InitialContext();
    }
    
    public Collection<ActorVO> getActorByName(String name)
    {
    	return this.getModCD().getActorByName(name);
    }
    
    public Collection<DirectorVO> getDirectorByName(String name)
    {
    	return this.getModCD().getDirectorByName(name);
    }
    
    public void guardarPelicula(PeliculaVO vo)
    {
    	this.getModCD().guardarPelicula(vo);
    }
    
    public Collection<PeliculaVO> getPeliculas()
    {
    	return this.getModCD().getPeliculas();
    }

    public PeliculaVO getPeliculaPorNumero(int cod)
    {
    	return this.getModCD().getPeliculaPorNumero(cod);
    }
    
    public Collection<PeliculaVO> getPeliculasByName(String nombre)
    {
    	return this.getModCD().getPeliculasByName(nombre);
    }
    
    public Collection<PeliculaVO> getPeliculasByActor(String nombre)
    {
    	return this.getModCD().getPeliculasByActor(nombre);
    }
    
    public Collection<PeliculaVO> getPeliculasByIdioma(String idioma)
    {
    	return this.getModCD().getPeliculasByIdioma(idioma);
    }
    
	public Collection<PeliculaVO> getPeliculasByGenero(String genero)
	{
		return this.getModCD().getPeliculasByGenero(genero);
	}
	
	public Collection<PeliculaVO> getPeliculasByDirector(String nombre)
	{
		return this.getModCD().getPeliculasByDirector(nombre);
	}
	
	public Collection<PeliculaVO> getPeliculasByFecha(Date fecha)
	{
		return this.getModCD().getPeliculasByFecha(fecha);
	}
	
	public int getNextIdGenero()
	{
		return this.getModCD().getNextIdGenero();
	}
	
	public int getNextIdDirector()
	{
		return this.getModCD().getNextIdDirector();
	}
	
	public int getNextIdActor()
	{
		return this.getModCD().getNextIdActor();
	}
	
	public int getNextIdIdioma()
	{
		return this.getModCD().getNextIdIdioma();
	}
	
	public boolean existeActor(ActorVO vo)
	{
		return this.getModCD().existeActor(vo);
	}
	
	public boolean existeDirector(DirectorVO vo)
	{
		return this.getModCD().existeDirector(vo);
	}
	
	public boolean existeGenero(GeneroVO vo)
	{
		return this.getModCD().existeGenero(vo);
	}
	
	public boolean existePelicula(PeliculaVO vo)
	{
		return this.getModCD().existePelicula(vo);
	}
	
	public boolean existeIdioma(IdiomaVO vo)
	{
		return this.getModCD().existeIdioma(vo);
	}
	
	public Collection<IdiomaVO> getIdiomas()
	{
		return this.getModCD().getIdiomas();
	}
	
	public Collection<GeneroVO> getGeneros()
	{
		return this.getModCD().getGeneros();
	}
	
	public boolean validUser(UserVO vo)
	{
		return this.getModCD().validUser(vo);
	}
    
    
	public ServerFacadeVideo getModCD() 
	{
		return modCD;
	}
}
