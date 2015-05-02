package ar.com.iglesias.ejb.dao.impl;

import javax.ejb.Stateless;

import ar.clarin.fwjava.dao.impl.GenericDAO;
import ar.com.iglesias.ejb.dao.api.local.SexoDAOLocal;
import ar.com.iglesias.web.model.basic.Sexo;

@Stateless
public class SexoDAO extends GenericDAO<Sexo, Integer> implements SexoDAOLocal {

}
