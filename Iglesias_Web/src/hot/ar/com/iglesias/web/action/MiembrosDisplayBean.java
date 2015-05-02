package ar.com.iglesias.web.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.log.Log;

import ar.clarin.fwjava.util.DateUtil;
import ar.com.iglesias.ejb.dao.api.local.EstadoCivilDAOLocal;
import ar.com.iglesias.ejb.dao.api.local.LocalidadDAOLocal;
import ar.com.iglesias.ejb.dao.api.local.MiembroDAOLocal;
import ar.com.iglesias.ejb.dao.api.local.ProvinciaDAOLocal;
import ar.com.iglesias.ejb.dao.api.local.SexoDAOLocal;
import ar.com.iglesias.web.model.Miembro;
import ar.com.iglesias.web.model.basic.CursoEducacionCristiana;
import ar.com.iglesias.web.model.basic.EstadoCivil;
import ar.com.iglesias.web.model.basic.Localidad;
import ar.com.iglesias.web.model.basic.Provincia;
import ar.com.iglesias.web.model.basic.Sexo;
import ar.com.iglesias.web.util.DataPage;
import ar.com.iglesias.web.util.DataSource;
import ar.com.iglesias.web.util.PagedListDataModel;

@Stateful
@Scope(ScopeType.SESSION)
@Name("miembrosDisplay")
public class MiembrosDisplayBean extends DataSource implements MiembrosDisplay {

	public MiembrosDisplayBean() {
		super("");
	}

	protected MiembrosDisplayBean(String defaultSortColumn) {
		super(defaultSortColumn);
	}

	@Logger
	private Log log;

	@EJB
	private MiembroDAOLocal miembroDAO;
	
	@EJB
	private SexoDAOLocal sexoDAO;

	@EJB
	private EstadoCivilDAOLocal estadoCivilDAO;
	
	@EJB
	private ProvinciaDAOLocal provinciaDAO;
	
	@EJB
	private LocalidadDAOLocal localidadDAO;
	
	@DataModel
	private List<Miembro> miembros;

	private List<Integer> idsMatchBusqueda = new ArrayList<Integer>(pageSize);

	private String textoBusqueda;

	private List<SelectItem> itemsMiembros;
	
	private Integer idProvinciaElegida;
	
	@In(required=false)
	@Out(required=false)
	private Miembro miembro;

	private Integer idProvinciaElegidaEmpresa;
	
	@RequestParameter
	private String nombreCurso;
	
	@Remove
	public void destroy() {
	}
	
	@Override
	public void agregarCurso(){
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String,String> m =  context.getExternalContext().getRequestParameterMap();
		CursoEducacionCristiana c = new CursoEducacionCristiana();
		c.setFechaFin(DateUtil.stringToDate(m.get("form_edit_miembro:j_id17:0:fechaFinCurso"), DateUtil.SHORT_DATE));
		c.setFechaInicio(DateUtil.stringToDate(m.get("form_edit_miembro:j_id17:0:fechaInicioCurso"), DateUtil.SHORT_DATE));
		c.setNombreCurso((String)m.get("form_edit_miembro:j_id17:0:nombreCursoTxt"));
		getMiembro().getEducacionCristiana().add(c);
	}

	@Override
	public List<Miembro> getMiembros() {
		return miembros;
	}

	@Override
	public void deleteMiembro(Miembro miembro) {
		miembroDAO.removeById(miembro.getId());
		idsMatchBusqueda.clear();
	}

	@Override
	public Miembro getMiembro() {
		return miembro;
	}

	@Override
	@Begin
	public void prepareNewMiembro() {
		this.miembro = new Miembro();
		this.miembro.setSexo(new Sexo());
		this.miembro.setEstadoCivil(new EstadoCivil());
		this.miembro.setProvincia(new Provincia());
		this.miembro.setLocalidad(new Localidad());
		this.miembro.setProvinciaEmpresa(new Provincia());
		this.miembro.setLocalidadEmpresa(new Localidad());
		this.idProvinciaElegida = null;
		this.idProvinciaElegidaEmpresa = null;
	}

	@Override
	@Begin
	public String prepareEditMiembro(Miembro miembro) {
		this.miembro = miembroDAO.getByIdEager(miembro.getId());
		return "/miembroDisplay.xhtml";
	}

	@End
	@Override
	public String cancelEditMiembro() {
		this.miembro = null;
		return "/miembros.xhtml";
	}

	@End
	@Override
	public String confirmEditMiembro() {
		miembro = miembroDAO.save(miembro);
		idsMatchBusqueda.clear();
		return "/miembros.xhtml";
	}
	
	@Override
	@Factory(value="itemsMiembros")
	public List<SelectItem> getItemsMiembros() {
		itemsMiembros = new ArrayList<SelectItem>();
		for(Miembro m : getMiembros()){
			itemsMiembros.add(new SelectItem(m, m.getApellido()));
		}
		return itemsMiembros;
	}

	@Override
	public String selectSexo(ValueChangeEvent event) {
		if(event.getNewValue() == null) {
			miembro.setSexo(null);
		} else {
			miembro.setSexo(sexoDAO.getReferenceById(Integer.valueOf(event.getNewValue().toString())));
		}
		return "";
	}

	@Override
	public String selectEstadoCivil(ValueChangeEvent event) {
		if(event.getNewValue() == null) {
			miembro.setEstadoCivil(null);
		} else {
			miembro.setEstadoCivil(estadoCivilDAO.getReferenceById(Integer.valueOf(event.getNewValue().toString())));
		}
		return "";
	}

	@Override
	public String getTextoBusqueda() {
		return textoBusqueda;
	}

	@Override
	public void setTextoBusqueda(String textoBusqueda) {
		this.textoBusqueda = textoBusqueda;
	}

	@Override
	public String buscarMiembros() {
		this.idsMatchBusqueda = miembroDAO.buscarMiembrosIds(getTextoBusqueda());
		log.debug("Busco en DB todos los miembros que matchean con '" + getTextoBusqueda() + "'");
		onePageDataModel.setDirtyData();
		onePageDataModel.setRowIndex(0);
		return "/miembros.xhtml";
	}
	
    private DataPage<Miembro> getDataPage(int startRow, int pageSize) {
        // Retrieve the total number of customers from the database.  This
        // number is required by the DataPage object so the paginator will know
        // the relative location of the page data.

    	if(idsMatchBusqueda == null || idsMatchBusqueda.isEmpty()) {
    		idsMatchBusqueda = miembroDAO.buscarMiembrosIds("");
    		log.debug("Busco en DB todos los miembros... ");
    	}

        int totalMiembros = idsMatchBusqueda.size();

        // Calculate indices to be displayed in the ui.
        int endIndex = startRow + pageSize;
        if (endIndex > totalMiembros) {
            endIndex = totalMiembros;
        }

        // Query database for sorted results.
        List<Integer> idsMatchPaginaSublist = idsMatchBusqueda.subList(startRow, endIndex);
        List<Miembro> pageMiembro = Collections.emptyList();
        if(!idsMatchPaginaSublist.isEmpty()) {
        	pageMiembro = miembroDAO.getMiembrosByIds(idsMatchPaginaSublist);
        }

        // Reset the dirtyData flag.
        onePageDataModel.setDirtyData(false);

        return new DataPage<Miembro>(totalMiembros, startRow, pageMiembro);
    }
	
    /**
     * Bound to DataTable value in the ui.
     */
    public javax.faces.model.DataModel getData() {
        onePageDataModel = new LocalDataModel(pageSize);
        return onePageDataModel;
    }

	@Override
	protected boolean isDefaultAscending(String sortColumn) {
		return false;
	}

    private class LocalDataModel extends PagedListDataModel<Miembro> {
        public LocalDataModel(int pageSize) {
            super(pageSize);
        }
        public DataPage<Miembro> fetchPage(int startRow, int pageSize) {
            return getDataPage(startRow, pageSize);
        }
    }

	@Override 
	public List<SelectItem> getLocalidades() {
		List<SelectItem> lisaRet = new ArrayList<SelectItem>();
		if(idProvinciaElegida==null && getMiembro().getLocalidad() == null){
			lisaRet.add(new SelectItem(null, "--Seleccione--"));
			return lisaRet;
		}
		idProvinciaElegida = getMiembro().getProvincia()!=null && getMiembro().getProvincia().getId()!=null?getMiembro().getProvincia().getId():idProvinciaElegida;
		List<Localidad> localidadesProvincia = localidadDAO.getLocalidadesByProvincia(idProvinciaElegida);
		for(Localidad l : localidadesProvincia){
			lisaRet.add(new SelectItem(l.getId().toString(), l.getNombre()));
		}
		return lisaRet;
	}
	
	@Override 
	public List<SelectItem> getLocalidadesEmpresa() {
		List<SelectItem> lisaRet = new ArrayList<SelectItem>();
		if(idProvinciaElegidaEmpresa==null && getMiembro().getLocalidadEmpresa() == null){
			lisaRet.add(new SelectItem(null, "--Seleccione--"));
			return lisaRet;
		}
		idProvinciaElegidaEmpresa = getMiembro().getProvinciaEmpresa() !=null&& getMiembro().getProvinciaEmpresa().getId()!=null?getMiembro().getProvinciaEmpresa().getId():idProvinciaElegidaEmpresa;
		List<Localidad> localidadesProvincia = localidadDAO.getLocalidadesByProvincia(idProvinciaElegidaEmpresa);
		for(Localidad l : localidadesProvincia){
			lisaRet.add(new SelectItem(l.getId().toString(), l.getNombre()));
		}
		return lisaRet;
	}

	@Override
	public String selectProvincia(ValueChangeEvent event) {
		if(event.getNewValue() == null) {
			miembro.setProvincia(new Provincia());
			idProvinciaElegida = null;
		} else {
			Integer idProvincia = Integer.valueOf(event.getNewValue().toString());
			Provincia prov = provinciaDAO.getById(idProvincia);
			prov.getLocalidades().size();
			miembro.setProvincia(prov);
			idProvinciaElegida = idProvincia;
		}
		return "";
	}

	@Override
	public String selectLocalidad(ValueChangeEvent event) {
		if(event.getNewValue() == null) {
			miembro.setLocalidad(new Localidad());
		} else {
			miembro.setLocalidad(localidadDAO.getReferenceById(Integer.valueOf(event.getNewValue().toString())));
		}
		return "";
	}

	@Override
	public String selectProvinciaEmpresa(ValueChangeEvent event) {
		if(event.getNewValue() == null) {
			miembro.setProvinciaEmpresa(new Provincia());
			idProvinciaElegidaEmpresa = null;
		} else {
			Integer idProvincia = Integer.valueOf(event.getNewValue().toString());
			Provincia prov = provinciaDAO.getById(idProvincia);
			prov.getLocalidades().size();
			miembro.setProvinciaEmpresa(prov);
			idProvinciaElegidaEmpresa = idProvincia;
		}
		return "";
	}

	@Override
	public String selectLocalidadEmpresa(ValueChangeEvent event) {
		if(event.getNewValue() == null) {
			miembro.setLocalidadEmpresa(new Localidad());
		} else {
			miembro.setLocalidadEmpresa(localidadDAO.getReferenceById(Integer.valueOf(event.getNewValue().toString())));
		}
		return "";
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	@Override
	public void borrarCurso(CursoEducacionCristiana curso) {
		getMiembro().getEducacionCristiana().remove(curso);
	}
}