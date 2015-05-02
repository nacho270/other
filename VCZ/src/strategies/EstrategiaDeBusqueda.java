package strategies;

import java.util.ArrayList;

import struts.model.BusinessDelegate;
import vo.PeliculaVO;

public abstract class EstrategiaDeBusqueda 
{
	private BusinessDelegate bd;
	
	public EstrategiaDeBusqueda(BusinessDelegate bd)
	{
		this.bd = bd;
	}
	
	public abstract ArrayList<PeliculaVO> buscar(String param);

	public BusinessDelegate getBd() {
		return bd;
	}
}
