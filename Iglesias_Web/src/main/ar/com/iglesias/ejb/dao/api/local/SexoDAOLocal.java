package ar.com.iglesias.ejb.dao.api.local;

import javax.ejb.Local;
import ar.clarin.fwjava.dao.api.local.DAOLocal;
import ar.com.iglesias.web.model.basic.Sexo;

@Local
public interface SexoDAOLocal extends DAOLocal<Sexo, Integer> {

}
