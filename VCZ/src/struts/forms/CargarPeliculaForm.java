package struts.forms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class CargarPeliculaForm extends ActionForm
{
	private static final long serialVersionUID = 2131818515684332331L;
	private FormFile fileXML;
	private FormFile fileZIP;

	public FormFile getFileXML() {
		return fileXML;
	}

	public void setFileXML(FormFile fileXML) {
		this.fileXML = fileXML;
	}

	public FormFile getFileZIP() {
		return fileZIP;
	}

	public void setFileZIP(FormFile fileZIP) {
		this.fileZIP = fileZIP;
	}
}
