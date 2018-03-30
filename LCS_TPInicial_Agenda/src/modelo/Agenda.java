package modelo;

import java.util.ArrayList;
import java.util.List;

import dto.DomicilioDTO;
import dto.EtiquetaDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.DomicilioDAO;
import persistencia.dao.interfaz.EtiquetaDAO;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;

public class Agenda {
	private PersonaDAO persona;
	private EtiquetaDAO etiqueta;
	private LocalidadDAO localidad;
	private DomicilioDAO domicilio;
	
	public Agenda(DAOAbstractFactory metodo_persistencia) {
		this.persona = metodo_persistencia.createPersonaDAO();
		this.etiqueta = metodo_persistencia.createEtiquetaDAO();
		this.localidad = metodo_persistencia.createLocalidadDAO();
		this.domicilio = metodo_persistencia.createDomicilioDAO();
	}

	/** PERSONA **/
	public void agregarPersona(PersonaDTO nuevaPersona) {
		this.persona.insert(nuevaPersona);
	}

	public void borrarPersona(int idpersona_a_eliminar) {
		this.persona.delete(idpersona_a_eliminar);
	}

	public List<PersonaDTO> obtenerPersonas() {
		return this.persona.readAll();
	}
	
	public void editarPersona (String nuevoNombre, String nuevoApellido, String nuevoTelefono, String nuevoEmail, String nuevaFechaNacimiento, int nuevoIdDomicilio, int nuevoIdEtiqueta, int idPersona_a_editar) {
		this.persona.edit(nuevoNombre, nuevoApellido, nuevoTelefono, nuevoEmail, nuevaFechaNacimiento, nuevoIdDomicilio, nuevoIdEtiqueta, idPersona_a_editar);
	}

	/** ETIQUETA **/
	public void agregarEtiqueta(EtiquetaDTO nuevaEtiqueta) {
		this.etiqueta.insert(nuevaEtiqueta);
	}

	public void borrarEtiqueta(int idetiqueta_a_eliminar) {
		this.etiqueta.delete(idetiqueta_a_eliminar);
	}

	public void editarEtiqueta(String nueva_etiqueta, EtiquetaDTO etiqueta_a_editar) {
		this.etiqueta.edit(nueva_etiqueta, etiqueta_a_editar);
	}

	public List<EtiquetaDTO> obtenerEtiquetas() {
		return this.etiqueta.readAll();
	}
	
	public int obtenerIdEtiqueta(String etiqueta) {
		return this.etiqueta.obtenerIdEtiqueta(etiqueta);
	}
	
	public String obtenerEtiqueta(int idEtiqueta) {
		return this.etiqueta.readEtiqueta(idEtiqueta);
	}
	
	/** LOCALIDAD **/
	public void agregarLocalidad(LocalidadDTO nuevaLocalidad) {
		this.localidad.insert(nuevaLocalidad);
	}

	public void borrarLocalidad(int idlocalidad_a_eliminar) {
		this.localidad.delete(idlocalidad_a_eliminar);
	}

	public void editarLocalidad(String nueva_localidad, LocalidadDTO localidad_a_editar) {
		this.localidad.edit(nueva_localidad, localidad_a_editar);
	}

	public List<LocalidadDTO> obtenerLocalidades() {
		return this.localidad.readAll();
	}
	
	public int obtenerIdLocalidad(String localidad) {
		return this.localidad.obtenerIdLocaldiad(localidad);
	}
	
	public String obtenerLocalidad(int idLocalidad) {
		return this.localidad.obtenerLocalidad(idLocalidad);
	}
	
	/** DOMICILIO **/
	public void agregarDocimilio(DomicilioDTO nuevoDomicilio) {
		this.domicilio.insert(nuevoDomicilio);
	}

	public void borrarDomicilio(int iddomicilio_a_eliminar) {
		this.domicilio.delete(iddomicilio_a_eliminar);
	}

	public List<DomicilioDTO> obtenerDomicilio() {
		return this.domicilio.readAll();
	}
	
	public int obtenerIdDomicilio(DomicilioDTO domicilio) {
		return this.domicilio.readIdDomicilio(domicilio);
	}
	
	public String obtenerDomicilio(int idDomicilio) {
		return this.domicilio.readDomicilio(idDomicilio);
	}
	
	public DomicilioDTO obtenerDomicilioDTO (int idDomicilio) {
		return this.domicilio.readDomicilioDTO(idDomicilio);
	}

	public void editarDomicilio (String nuevaCalle, String nuevaAltura, String nuevoPiso, String nuevoDepartamento, int nuevoIdLocalidad, int idDomicilio_a_modificar) {
		this.domicilio.edit(nuevaCalle, nuevaAltura, nuevoPiso, nuevoDepartamento, nuevoIdLocalidad, idDomicilio_a_modificar);
	}
	
	/* Reporte Persona */
	public List<PersonaReporte> getPersonaReporte(){
		ArrayList<PersonaReporte> ret = new ArrayList<PersonaReporte>();
		ArrayList<PersonaDTO> personas = (ArrayList<PersonaDTO>) this.obtenerPersonas();
		for (PersonaDTO p : personas) {
			ret.add(new PersonaReporte(p.getApellido(), p.getNombre(), p.getTelefono(), p.getEmail(), Fechas.deDateToString(p.getFeNacimiento()), this.obtenerDomicilio(p.getIdDomicilio()), this.obtenerEtiqueta(p.getIdEtiqueta())));			
		}
		return ret;
	}

}
