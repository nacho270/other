package ar.com.iglesias.ejb.dao.impl;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ar.clarin.fwjava.dao.impl.GenericDAO;
import ar.clarin.fwjava.util.StringUtil;
import ar.com.iglesias.ejb.dao.api.local.MiembroDAOLocal;
import ar.com.iglesias.web.model.Miembro;

@Stateless
@SuppressWarnings("unchecked")
public class MiembroDAO extends GenericDAO<Miembro, Integer> implements MiembroDAOLocal {

	@Override
	public Miembro getByIdEager(Integer id) {
		Miembro miembro = getById(id);
		miembro.getSexo().getNombre();
		miembro.getEstadoCivil().getNombre();
		miembro.getEducacionCristiana().size();
		return miembro;
	}

	@Override
	public List<Integer> buscarMiembrosIds(String textoBusqueda) {
		boolean textoVacio = StringUtil.isNullOrEmpty(textoBusqueda);
		Query query = getEntityManager().createQuery("SELECT m.id FROM Miembro m " +
													 (textoVacio ? "" : " WHERE lower(m.nombre) LIKE :textoBusqueda OR lower(m.apellido) LIKE :textoBusqueda "));
		if(!textoVacio) {
			query.setParameter("textoBusqueda", "%" + textoBusqueda.trim().toLowerCase() + "%");
		}
		List<Integer> miembrosIds = query.getResultList();
		return miembrosIds;
	}

	@Override
	public List<Miembro> getMiembrosByIds(List<Integer> idsMatchPagina) {
		if(idsMatchPagina.isEmpty()) {
			return Collections.emptyList();
		} else {
			Query query = getEntityManager().createQuery("SELECT m FROM Miembro m WHERE m.id IN (:ids)");
			query.setParameter("ids", idsMatchPagina);
			return query.getResultList();
		}
	}

}