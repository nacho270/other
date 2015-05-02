package ar.com.iglesias.web.action;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

import ar.com.iglesias.web.model.UsuarioSistema;

@Stateless
@Name("authenticator")
public class AuthenticatorBean implements Authenticator
{
    @Logger private Log log;

    @In Identity identity;
    @In Credentials credentials;

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
    public boolean authenticate() {
    	Query query = entityManager.createQuery("SELECT us FROM UsuarioSistema us WHERE lower(us.miembro.email) = :email AND us.password = :password");
    	query.setParameter("email", credentials.getUsername().trim().toLowerCase());
    	query.setParameter("password", credentials.getPassword().trim());
		List<UsuarioSistema> resultList = query.getResultList();
    	log.info("authenticating {0}", credentials.getUsername());
    	return !resultList.isEmpty();
    }

}