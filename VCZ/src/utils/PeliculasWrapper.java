package utils;

import java.util.ArrayList;

import vo.PeliculaVO;

public class PeliculasWrapper 
{
	private ArrayList<PeliculaVO> peliculas = new ArrayList<PeliculaVO>();

	public ArrayList<PeliculaVO> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(ArrayList<PeliculaVO> peliculas) {
		this.peliculas = peliculas;
	}
}
