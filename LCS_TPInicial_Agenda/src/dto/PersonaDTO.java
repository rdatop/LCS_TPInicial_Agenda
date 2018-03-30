package dto;

import java.util.Date;

import modelo.Fechas;

public class PersonaDTO {
	private int idPersona;
	private String nombre;
	private String apellido;
	private String telefono;
	private EtiquetaDTO etiqueta;
	private String email;
	private Date feNacimiento;
	private int idDomicilio;
	private int idEtiqueta;

	public PersonaDTO(int idPersona, String nombre, String apellido, String telefono, String email, Date feNacimiento,
			int idDomicilio, int idEtiqueta) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.feNacimiento = feNacimiento;
		this.idDomicilio = idDomicilio;
		this.idEtiqueta = idEtiqueta;
	}

	public int getIdDomicilio() {
		return idDomicilio;
	}

	public String getApellido() {
		return this.apellido;
	}
	
	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public int getIdEtiqueta() {
		return idEtiqueta;
	}

	public void setIdEtiqueta(int idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public EtiquetaDTO getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(EtiquetaDTO etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFeNacimiento() {
		return this.feNacimiento;
	}

	public void setFeNacimiento(String feNacimiento) {
		this.feNacimiento = Fechas.deStringToDate(feNacimiento);
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
