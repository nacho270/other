package ar.com.iglesias.web.action;

import java.util.List;

import javax.ejb.Local;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import ar.com.iglesias.web.model.Miembro;
import ar.com.iglesias.web.model.basic.CursoEducacionCristiana;

@Local
public interface MiembrosDisplay {

	public List<Miembro> getMiembros();

	public void destroy();
	
	public void deleteMiembro(Miembro miembro);

	Miembro getMiembro();

	void prepareNewMiembro();

	public String prepareEditMiembro(Miembro miembro);

	String cancelEditMiembro();

	String confirmEditMiembro();

	List<SelectItem> getItemsMiembros();
	
	public String selectSexo(ValueChangeEvent event);
	
	public String selectEstadoCivil(ValueChangeEvent event);
	
	public String selectProvincia(ValueChangeEvent event);
	
	public String selectLocalidad(ValueChangeEvent event);
	
	public String selectProvinciaEmpresa(ValueChangeEvent event);
	
	public String selectLocalidadEmpresa(ValueChangeEvent event);
	
	public List<SelectItem> getLocalidades();
	
	public List<SelectItem> getLocalidadesEmpresa();

	public String getTextoBusqueda();

	public void setTextoBusqueda(String textoBusqueda);

	public String buscarMiembros();

	public javax.faces.model.DataModel getData();

	public void agregarCurso();
	
	public void borrarCurso(CursoEducacionCristiana curso);
}