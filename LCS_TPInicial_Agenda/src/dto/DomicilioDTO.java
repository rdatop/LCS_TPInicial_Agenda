package dto;

public class DomicilioDTO {

	private int idDomicilio;
	private String calle;
	private String altura;
	private String piso;
	private String departamento;
	private LocalidadDTO localidad;
	private int idLocalidad;

	public DomicilioDTO(int idDomicilio, String calle, String altura, String piso, String departamento,
			LocalidadDTO localidad) {
		this.idDomicilio = idDomicilio;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.departamento = departamento;
		this.localidad = localidad;
	}

	public DomicilioDTO(int idDomicilio, String calle, String altura, String piso, String departamento,
			int idLocalidad) {
		this.idDomicilio = idDomicilio;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.departamento = departamento;
		this.idLocalidad = idLocalidad;
	}

	public int getIdDomicilio() {
		return idDomicilio;
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public LocalidadDTO getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadDTO localidad) {
		this.localidad = localidad;
	}

	public String toString() {
		String ret = this.calle + " " + this.altura + ", " + this.piso + " " + this.departamento + " ("
				+ this.localidad.getLocalidad() + ")";
		return ret;
	}

}
