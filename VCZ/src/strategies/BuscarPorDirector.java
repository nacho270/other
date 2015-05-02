package strategies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import struts.model.BusinessDelegate;
import vo.PeliculaVO;

public class BuscarPorDirector extends EstrategiaDeBusqueda
{
	public BuscarPorDirector(BusinessDelegate bd) 
	{
		super(bd);
	}

	@Override
	public ArrayList<PeliculaVO> buscar(String param) 
	{
		System.out.println("Busco por director");
		Collection<PeliculaVO> pelsco = this.getBd().getPeliculasByDirector(param);
		ArrayList<PeliculaVO> pels = new ArrayList<PeliculaVO>();
		
		if(pelsco != null)
		{
			Iterator i = pelsco.iterator();
			
			while(i.hasNext())
			{
				PeliculaVO vo = (PeliculaVO)i.next();
				pels.add(vo);
			}
		}
		return pels;
	}

}
