package ar.com.iglesias.ejb.dao.api.local;

import java.util.List;

import javax.ejb.Local;

import ar.clarin.fwjava.dao.api.local.DAOLocal;
import ar.com.iglesias.web.model.basic.Localidad;

@Local
public interface LocalidadDAOLocal extends DAOLocal<Localidad, Integer>{
	List<Localidad> getLocalidadesByProvincia(Integer idProvinciaElegida);
}
