package dto;

public class DomicilioDTO {
	
	//variables de instancia
	private int idDomicilio;
	private String calle;
	private String altura;
	private String piso;
	private String depto;
	private LocalidadDTO localidad;
	private int idLocalidad;
	
	//constructor
	public DomicilioDTO(int idDomicilio, String calle, String altura, 
			String piso, String depto, LocalidadDTO localidad){
		this.idDomicilio=idDomicilio;
		this.calle=calle;
		this.altura=altura;
		this.piso=piso;
		this.depto=depto;
		this.localidad=localidad;
	}
	
	//consultar por que otro constructor pon el parametro idlocalidad
	public DomicilioDTO(int idDomicilio, String calle, String altura, 
			String piso, String depto, int idLocalidad) {
		this.idDomicilio = idDomicilio;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.depto = depto;
		this.idLocalidad = idLocalidad;
	}
	
	//lectura protegida y carga de parametros
	//domicilio
	public void setIdDomicilio(int idDomicilio){
		this.idDomicilio=idDomicilio;
	}
	public int getIdDomicilio(){
		return idDomicilio;
	}
	//calle
	public void setCalle(String calle){
		this.calle=calle;
	}
	public String getCalle(){
		return calle;
	}
	//altura
	public void setAltura(String altura){
		this.altura=altura;
	}
	public String getAltura(){
		return altura;
	}
	//piso
	public void setPiso(String piso){
		this.piso=piso;
	}
	public String getPiso(){
		return piso;
	}
	//depto
	public void setDepto(String depto){
		this.depto=depto;
	}
	public String getDepto(){
		return depto;
	}
	//id localidad
	public void setIdLocalidad(int idLocalidad){
		this.idLocalidad=idLocalidad;
	}
	public int getIdLocalidad(){
		return idLocalidad;
	}
	//localidad
	public void setLocalidad(LocalidadDTO localidad){
		this.localidad=localidad;
	}
	public LocalidadDTO getLocalidad(){
		return localidad;
	}
	
	public String toString() {
		String ret = this.calle + " " + this.altura + ", " + this.piso + " " + this.depto + " ("
				+ this.localidad.getLocalidad() + ")";
		return ret;
	}
	
}
