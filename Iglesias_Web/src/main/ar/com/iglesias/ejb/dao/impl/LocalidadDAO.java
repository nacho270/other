package ar.com.iglesias.ejb.dao.impl;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ar.clarin.fwjava.dao.impl.GenericDAO;
import ar.com.iglesias.ejb.dao.api.local.LocalidadDAOLocal;
import ar.com.iglesias.web.model.basic.Localidad;

@Stateless
public class LocalidadDAO extends GenericDAO<Localidad, Integer> implements LocalidadDAOLocal{
	@Override
	@SuppressWarnings("unchecked")
	public List<Localidad> getLocalidadesByProvincia(Integer idProvinciaElegida) {
		String hql = " SELECT l FROM Localidad l WHERE l.provincia.id = :idProv  ";
		Query q = getEntityManager().createQuery(hql);
		q.setParameter("idProv", idProvinciaElegida);
		List<Localidad> lista = q.getResultList();
		if(lista!=null && !lista.isEmpty()){
			return lista;
		}
		return Collections.emptyList();
	}

}
