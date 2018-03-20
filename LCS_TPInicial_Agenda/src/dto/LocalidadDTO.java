package dto;

public class LocalidadDTO {
	//variables de instancia
	private int idLocalidad;
	private String localidad;
	
	//constructor
	public LocalidadDTO(int idLocalidad, String localidad){
		this.idLocalidad=idLocalidad;
		this.localidad=localidad;
	}
	
	//lectura protegida y cargado de parametros
	//id localidad
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	public int getIdLocalidad() {
		return idLocalidad;
	}
	//localidad
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getLocalidad() {
		return localidad;
	}
}
