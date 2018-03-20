package dto;

import java.util.Date;

import modelo.Fechas;

public class PersonaDTO 
{
	//variables de instancia
	private int idPersona;
	private String nombre;
	private String telefono;
	private DomicilioDTO domicilio;
	private EtiquetaDTO etiqueta;
	private String email;
	private Date feNacimiento;
	private int idDomicilio;
	private int idEtiqueta;

	//constructor
	public PersonaDTO(int idPersona, String nombre, String telefono){
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	//consultar por que tres constructores
	public PersonaDTO(int idPersona, String nombre, String telefono, String email, String feNacimiento, DomicilioDTO domicilio, EtiquetaDTO etiqueta) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.feNacimiento=Fechas.deStringToDate(feNacimiento);
		this.domicilio = domicilio;
		this.etiqueta = etiqueta;
	}
	public PersonaDTO(int idPersona, String nombre, String telefono, String email, String feNacimiento, int idDomicilio, int idEtiqueta) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.feNacimiento=Fechas.deStringToDate(feNacimiento);;
		this.idDomicilio = idDomicilio;
		this.idEtiqueta = idEtiqueta;
	}
	
	public PersonaDTO(int idPersona, String nombre, String telefono, String email, Date feNacimiento, int idDomicilio, int idEtiqueta) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.feNacimiento=feNacimiento;
		this.idDomicilio = idDomicilio;
		this.idEtiqueta = idEtiqueta;
	}
	
	//lectura protegida y carga de parametros
	//id persona
	public int getIdPersona() 
	{
		return this.idPersona;
	}
	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}
	//nombre
	public String getNombre() 
	{
		return this.nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	//telefono
	public String getTelefono() 
	{
		return this.telefono;
	}
	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	//domicilio
	public DomicilioDTO getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
	}
	//id domicilio
	public int getIdDomicilio() {
		return idDomicilio;
	}
	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}
	//etiqueta
	public EtiquetaDTO getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(EtiquetaDTO etiqueta) {
		this.etiqueta = etiqueta;
	}
	//id etiqueta
	public int getIdEtiqueta() {
		return idEtiqueta;
	}
	public void setIdEtiqueta(int idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}
	//e-mail
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//feca de nacimiento
	public Date getFeNacimiento() {
		return this.feNacimiento;
	}
	public void setFeNacimiento(String feNacimiento) {
		this.feNacimiento = Fechas.deStringToDate(feNacimiento);
	}
	//obtiene domicilio
	public String obtenerDomicilio() {
		return this.domicilio.toString();
	}
}
