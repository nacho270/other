package ar.com.iglesias.ejb.dao.api.local;

import java.util.List;

import javax.ejb.Local;
import ar.clarin.fwjava.dao.api.local.DAOLocal;
import ar.com.iglesias.web.model.Miembro;

@Local
public interface MiembroDAOLocal extends DAOLocal<Miembro, Integer> {

	public Miembro getByIdEager(Integer id);

	public List<Integer> buscarMiembrosIds(String textoBusqueda);

	public List<Miembro> getMiembrosByIds(List<Integer> idsMatchPagina);

}
