package struts.forms;

import org.apache.struts.action.ActionForm;

public class DeleteForm extends ActionForm
{
	private static final long serialVersionUID = -8411766353622005903L;
	
	private boolean[] borrar;
	private String[] codigos;
	
	public boolean[] getBorrar() {
		return borrar;
	}
	public void setBorrar(boolean[] borrar) {
		this.borrar = borrar;
	}
	
	public String[] getCodigos()
	{
		return codigos;
	}
	
	public void setCodigos(String[] codigos)
	{
		this.codigos=codigos;
	}
}
