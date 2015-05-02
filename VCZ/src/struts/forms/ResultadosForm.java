package struts.forms;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import vo.ActorVO;
import vo.DirectorVO;

public class ResultadosForm extends ActionForm
{
	private static final long serialVersionUID = -7418026469089644728L;
	
	private String actorInput;
	private String directorInput;
	
	private ArrayList<ActorVO> actores;
	private ArrayList<DirectorVO> directores;
	
	public ArrayList<ActorVO> getActores() {
		return actores;
	}
	public void setActores(ArrayList<ActorVO> actores) {
		this.actores = actores;
	}
	public ArrayList<DirectorVO> getDirectores() {
		return directores;
	}
	public void setDirectores(ArrayList<DirectorVO> directores) {
		this.directores = directores;
	}
	public String getActorInput() {
		return actorInput;
	}
	public void setActorInput(String actorInput) {
		this.actorInput = actorInput;
	}
	public String getDirectorInput() {
		return directorInput;
	}
	public void setDirectorInput(String directorInput) {
		this.directorInput = directorInput;
	}
}
