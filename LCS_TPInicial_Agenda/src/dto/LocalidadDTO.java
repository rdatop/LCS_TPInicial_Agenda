package dto;

public class LocalidadDTO {
	private int idLocalidad;
	private String localidad;
	
	public LocalidadDTO (int idLocalidad, String localidad) {
		this.idLocalidad = idLocalidad;
		this.localidad = localidad; 
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
}
