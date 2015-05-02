package struts.forms;

import java.util.List;

import org.apache.struts.action.ActionForm;

import vo.PeliculaVO;

public class ShowPeliculasForm extends ActionForm
{
	private static final long serialVersionUID = -3380535759360796339L;
	
	private List<PeliculaVO> peliculas;

	public List<PeliculaVO> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<PeliculaVO> peliculas) {
		this.peliculas = peliculas;
	}
}
