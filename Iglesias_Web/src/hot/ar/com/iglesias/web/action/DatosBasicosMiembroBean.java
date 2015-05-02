package ar.com.iglesias.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.faces.model.SelectItem;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import ar.com.iglesias.ejb.dao.api.local.EstadoCivilDAOLocal;
import ar.com.iglesias.ejb.dao.api.local.ProvinciaDAOLocal;
import ar.com.iglesias.ejb.dao.api.local.SexoDAOLocal;
import ar.com.iglesias.web.model.basic.EstadoCivil;
import ar.com.iglesias.web.model.basic.Provincia;
import ar.com.iglesias.web.model.basic.Sexo;

@Stateful
@Name("datosBasicos")
public class DatosBasicosMiembroBean implements DatosBasicosMiembro {

	@Out(required=false, scope=ScopeType.SESSION)
	private List<SelectItem> listSexo;

	@Out(required=false, scope=ScopeType.SESSION)
	private List<SelectItem> listEstadosCiviles;

	@Out(required=false, scope=ScopeType.SESSION)
	private List<SelectItem> listProvincia;
	
	@EJB
	private SexoDAOLocal sexoDAO;

	@EJB
	private EstadoCivilDAOLocal estadoCivilDAO;

	@EJB
	private ProvinciaDAOLocal provinciaDAO;
	
	@Factory("listSexo")
	public void fillSexos() {
		List<Sexo> allSexos = sexoDAO.getAllOrderBy("nombre");
		listSexo = new ArrayList<SelectItem>();
		for(Sexo s : allSexos) {
			listSexo.add(new SelectItem(s.getId().toString(), s.getNombre()));
		}
	}

	@Override
	@Factory("listEstadosCiviles")
	public void fillEstadosCiviles() {
		List<EstadoCivil> allEstadosCiviles = estadoCivilDAO.getAllOrderBy("nombre");
		listEstadosCiviles = new ArrayList<SelectItem>();
		for(EstadoCivil ec : allEstadosCiviles) {
			listEstadosCiviles.add(new SelectItem(ec.getId().toString(), ec.getNombre()));
		}
	}

	@Override
	@Remove
	public void destroy() {
	}

	@Override
	@Factory("listProvincia")
	public void fillProvincias() {
		List<Provincia> provincias = provinciaDAO.getAllOrderBy("nombre");
		listProvincia = new ArrayList<SelectItem>();
		for(Provincia p : provincias){
			listProvincia.add(new SelectItem(p.getId().toString(), p.getNombre()));
		}
	}
}