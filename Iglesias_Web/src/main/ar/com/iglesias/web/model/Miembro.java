package ar.com.iglesias.web.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jboss.seam.annotations.Name;

import ar.clarin.fwjava.util.DateUtil;
import ar.com.iglesias.web.model.basic.CursoEducacionCristiana;
import ar.com.iglesias.web.model.basic.EstadoCivil;
import ar.com.iglesias.web.model.basic.Localidad;
import ar.com.iglesias.web.model.basic.Provincia;
import ar.com.iglesias.web.model.basic.Sexo;

@Entity
@Table(name = "T_MIEMBRO")
@Name(value = "miembro")
public class Miembro {

	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	private Date fechaNacimiento;
	private Sexo sexo;
	private EstadoCivil estadoCivil;
	private Provincia provincia;
	private Localidad localidad;
	private String calle;
	private String altura;
	private String piso;
	private String dto;

	/*
	 * Datos adicionales
	 */
	private Boolean cabezaDeFamilia;
	private Date fechaUnionIglesia;
	private Boolean activo;
	private String jerarquia;
	private Boolean seguimiento;
	private List<CursoEducacionCristiana> educacionCristiana;
	// falta grupo que no se que es

	/*
	 * Datos laborales
	 */
	private String nombreEmpresa;
	private Provincia provinciaEmpresa;
	private Localidad localidadEmpresa;
	private String calleEmpresa;
	private String alturaEmpresa;
	private String pisoEmpresa;
	private String dtoEmpresa;
	private String telefonoFijoEmpresa;
	private String internoEmpresa;
	private String emailEmpresa;
	private String telAlternativoFax;

	public Miembro() {
		this.educacionCristiana = new ArrayList<CursoEducacionCristiana>();
	}

	@Id
	@Column(name = "P_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "A_NOMBRE", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "A_APELLIDO", nullable = false)
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "A_EMAIL", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "A_FECHA_NACIMIENTO", nullable = false)
	public java.util.Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(java.util.Date fechaNacimiento) {
		if (fechaNacimiento == null) {
			this.fechaNacimiento = null;
		} else {
			this.fechaNacimiento = new Date(fechaNacimiento.getTime());
		}
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "F_SEXO_P_ID", nullable = false)
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "F_ESTADO_CIVIL_P_ID", nullable = false)
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Miembro other = (Miembro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Transient
	public Integer getEdad() {
		if (getFechaNacimiento() == null) {
			return null;
		} else {
			return DateUtil.calcularEdad(getFechaNacimiento());
		}
	}

	@Transient
	public String getCodPostal() {
		if (getLocalidad() == null) {
			return null;
		} else {
			return getLocalidad().getCodPostal();
		}
	}
	
	@Transient
	public String getCodPostalEmpresa() {
		if (getLocalidadEmpresa() == null) {
			return null;
		} else {
			return getLocalidadEmpresa().getCodPostal();
		}
	}

	@Column(name = "A_CABEZA_FLIA", nullable = false, columnDefinition = "INT DEFAULT 0")
	public Boolean getCabezaDeFamilia() {
		return cabezaDeFamilia;
	}

	public void setCabezaDeFamilia(Boolean cabezaDeFamilia) {
		this.cabezaDeFamilia = cabezaDeFamilia;
	}

	@Column(name = "A_FECHA_UNION", nullable = false)
	public java.util.Date getFechaUnionIglesia() {
		return fechaUnionIglesia;
	}

	public void setFechaUnionIglesia(java.util.Date fechaUnionIglesia) {
		if (fechaUnionIglesia == null) {
			this.fechaUnionIglesia = null;
		} else {
			this.fechaUnionIglesia = new Date(fechaUnionIglesia.getTime());
		}
	}

	@Column(name = "A_ACTIVO", nullable = false, columnDefinition = "INT DEFAULT 0")
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Column(name = "A_JERARQUIA", nullable = false)
	public String getJerarquia() {
		return jerarquia;
	}

	public void setJerarquia(String jerarquia) {
		this.jerarquia = jerarquia;
	}

	@Column(name = "A_SEGUIMIENTO", nullable = false, columnDefinition = "INT DEFAULT 0")
	public Boolean getSeguimiento() {
		return seguimiento;
	}

	public void setSeguimiento(Boolean seguimiento) {
		this.seguimiento = seguimiento;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="F_PROVINCIA_P_ID",nullable=false)
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="F_LOCALIDAD_P_ID",nullable=false)
	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	@Column(name="A_CALLE",nullable=false)
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	@Column(name="A_ALTURA",nullable=false)
	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	@Column(name="A_PISO",nullable=true)
	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	@Column(name="A_DTO",nullable=true)
	public String getDto() {
		return dto;
	}

	public void setDto(String dto) {
		this.dto = dto;
	}

	@Column(name="A_NOMBRE_EMPRESA",nullable=true)
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="F_PROVINCIA_EMP_P_ID",nullable=true)
	public Provincia getProvinciaEmpresa() {
		return provinciaEmpresa;
	}

	public void setProvinciaEmpresa(Provincia provinciaEmpresa) {
		this.provinciaEmpresa = provinciaEmpresa;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="F_LOCALIDAD_EMP_P_ID",nullable=true)
	public Localidad getLocalidadEmpresa() {
		return localidadEmpresa;
	}

	public void setLocalidadEmpresa(Localidad localidadEmpresa) {
		this.localidadEmpresa = localidadEmpresa;
	}

	@Column(name="A_CALLE_EMP",nullable=true)
	public String getCalleEmpresa() {
		return calleEmpresa;
	}

	public void setCalleEmpresa(String calleEmpresa) {
		this.calleEmpresa = calleEmpresa;
	}

	@Column(name="A_ALTURA_EMP",nullable=true)
	public String getAlturaEmpresa() {
		return alturaEmpresa;
	}

	public void setAlturaEmpresa(String alturaEmpresa) {
		this.alturaEmpresa = alturaEmpresa;
	}

	@Column(name="A_PISO_EMP",nullable=true)
	public String getPisoEmpresa() {
		return pisoEmpresa;
	}

	public void setPisoEmpresa(String pisoEmpresa) {
		this.pisoEmpresa = pisoEmpresa;
	}

	@Column(name="A_DTO_EMP",nullable=true)
	public String getDtoEmpresa() {
		return dtoEmpresa;
	}

	public void setDtoEmpresa(String dtoEmpresa) {
		this.dtoEmpresa = dtoEmpresa;
	}

	@Column(name="A_INTERNO_EMPRESA",nullable=true)
	public String getInternoEmpresa() {
		return internoEmpresa;
	}

	public void setInternoEmpresa(String internoEmpresa) {
		this.internoEmpresa = internoEmpresa;
	}

	@Column(name="A_EMAIL_EMPRESA",nullable=true)
	public String getEmailEmpresa() {
		return emailEmpresa;
	}

	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	@Column(name="A_TEL_ALT_FAX_EMPRESA",nullable=true)
	public String getTelAlternativoFax() {
		return telAlternativoFax;
	}

	public void setTelAlternativoFax(String telAlternativoFax) {
		this.telAlternativoFax = telAlternativoFax;
	}

	@Column(name="A_TEL_EMPRESA",nullable=true)
	public String getTelefonoFijoEmpresa() {
		return telefonoFijoEmpresa;
	}

	public void setTelefonoFijoEmpresa(String telefonoFijoEmpresa) {
		this.telefonoFijoEmpresa = telefonoFijoEmpresa;
	}

	@OneToMany(fetch=FetchType.LAZY,cascade={CascadeType.ALL})
	@JoinColumn(name="F_MIEMBRO_P_ID",nullable=true)
	public List<CursoEducacionCristiana> getEducacionCristiana() {
		return educacionCristiana;
	}

	public void setEducacionCristiana(List<CursoEducacionCristiana> educacionCristiana) {
		this.educacionCristiana = educacionCristiana;
	}
}