package modelo;

public class PersonaReporte {
	private String apellido, nombre, telefono, email, fechaNacimiento, domicilio, etiqueta;
	
	public PersonaReporte(String apellido, String nombre, String telefono, String email, String fechaNacimiento, String domicilio, String etiqueta) {
		this.apellido =  apellido;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.etiqueta = etiqueta;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

}
