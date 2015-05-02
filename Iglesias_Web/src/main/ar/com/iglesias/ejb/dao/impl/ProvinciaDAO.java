package ar.com.iglesias.ejb.dao.impl;

import javax.ejb.Stateless;

import ar.clarin.fwjava.dao.impl.GenericDAO;
import ar.com.iglesias.ejb.dao.api.local.ProvinciaDAOLocal;
import ar.com.iglesias.web.model.basic.Provincia;

@Stateless
public class ProvinciaDAO extends GenericDAO<Provincia, Integer> implements ProvinciaDAOLocal{

}
