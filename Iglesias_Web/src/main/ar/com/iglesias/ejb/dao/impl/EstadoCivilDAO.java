package ar.com.iglesias.ejb.dao.impl;

import javax.ejb.Stateless;

import ar.clarin.fwjava.dao.impl.GenericDAO;
import ar.com.iglesias.ejb.dao.api.local.EstadoCivilDAOLocal;
import ar.com.iglesias.web.model.basic.EstadoCivil;

@Stateless
public class EstadoCivilDAO extends GenericDAO<EstadoCivil, Integer> implements EstadoCivilDAOLocal {

}
