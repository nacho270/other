package ar.com.iglesias.ejb.dao.api.local;

import javax.ejb.Local;

import ar.clarin.fwjava.dao.api.local.DAOLocal;
import ar.com.iglesias.web.model.basic.Provincia;

@Local
public interface ProvinciaDAOLocal extends DAOLocal<Provincia, Integer>{

}
