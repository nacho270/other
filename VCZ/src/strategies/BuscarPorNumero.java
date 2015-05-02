package strategies;

import java.util.ArrayList;

import struts.model.BusinessDelegate;
import vo.PeliculaVO;

public class BuscarPorNumero extends EstrategiaDeBusqueda
{
	public BuscarPorNumero(BusinessDelegate bd) 
	{
		super(bd);
	}

	@Override
	public ArrayList<PeliculaVO> buscar(String param) 
	{
		int num = Integer.parseInt(param);
		System.out.println("busco por numero");
		PeliculaVO vo = this.getBd().getPeliculaPorNumero(num);
		ArrayList<PeliculaVO> ret = new ArrayList<PeliculaVO>();
		
		if(vo != null) ret.add(vo);
		
		return ret;
	}
}
