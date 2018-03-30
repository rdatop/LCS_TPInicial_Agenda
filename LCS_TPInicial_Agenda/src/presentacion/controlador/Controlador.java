package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;

import dto.DomicilioDTO;
import dto.EtiquetaDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import modelo.Agenda;
import modelo.Fechas;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaEditaEtiqueta;
import presentacion.vista.VentanaEditaLocalidad;
import presentacion.vista.VentanaEditaPersona;
import presentacion.vista.VentanaEtiqueta;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import presentacion.vista.VistaEtiqueta;
import presentacion.vista.VistaLocalidad;

public class Controlador implements ActionListener {

	private Agenda agenda;

	/* PERSONA */
	private Vista vista;
	private VentanaPersona ventanaPersona;
	private VentanaEditaPersona ventanaEditaPersona;
	private List<PersonaDTO> personas_en_tabla;

	/* ETIQUETA */
	private VistaEtiqueta vistaEtiqueta;
	private VentanaEtiqueta ventanaEtiqueta;
	private VentanaEditaEtiqueta ventanaEditaEtiqueta;
	private List<EtiquetaDTO> etiquetas_en_tabla;

	/* LOCALIDAD */
	private VistaLocalidad vistaLocalidad;
	private VentanaLocalidad ventanaLocalidad;
	private VentanaEditaLocalidad ventanaEditaLocalidad;
	private List<LocalidadDTO> localidades_en_tabla;

	/* DOMICILIO */

	public Controlador(Vista vista, Agenda agenda) {
		this.vista = vista;
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnEditar().addActionListener(this);
		this.vista.getBtnBorrar().addActionListener(this);
		this.vista.getBtnReporte().addActionListener(this);
		this.vista.getBtnEtiqueta().addActionListener(this);
		this.vista.getBtnLocalidad().addActionListener(this);
		this.agenda = agenda;
		this.personas_en_tabla = null;
		this.etiquetas_en_tabla = null;
	}

	public void inicializar() {
		this.llenarTablaPersonas();
		this.vista.show();
	}

	/* actualizar tabla de personas */
	private void llenarTablaPersonas() {
		this.vista.getModelPersonas().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelPersonas().setColumnCount(0);
		this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());

		this.personas_en_tabla = agenda.obtenerPersonas();
		for (int i = 0; i < this.personas_en_tabla.size(); i++) {
			Object[] fila = { this.personas_en_tabla.get(i).getNombre(), 
					this.personas_en_tabla.get(i).getApellido(), 
					this.personas_en_tabla.get(i).getTelefono(),
					this.personas_en_tabla.get(i).getEmail(), 
					this.personas_en_tabla.get(i).getFeNacimiento(),
					this.agenda.obtenerDomicilio(this.personas_en_tabla.get(i).getIdDomicilio()),
					this.agenda.obtenerEtiqueta(this.personas_en_tabla.get(i).getIdEtiqueta()) };
			this.vista.getModelPersonas().addRow(fila);
		}
	}

	/* actualizar tabla de etiquetas */
	private void llenarTablaEtiquetas() {
		this.vistaEtiqueta.getModelEtiquetas().setRowCount(0); // Para vaciar la tabla
		this.vistaEtiqueta.getModelEtiquetas().setColumnCount(0);
		this.vistaEtiqueta.getModelEtiquetas().setColumnIdentifiers(this.vistaEtiqueta.getNombreColumnas());
		this.etiquetas_en_tabla = agenda.obtenerEtiquetas();
		for (int i = 0; i < this.etiquetas_en_tabla.size(); i++) {
			Object[] fila = { this.etiquetas_en_tabla.get(i).getEtiqueta() };
			this.vistaEtiqueta.getModelEtiquetas().addRow(fila);
		}
	}

	/* Carga las localidades y etiquetas en la ventana de alta de personas */
	private void llenarComboBoxNuevaPersona() {
		this.etiquetas_en_tabla = agenda.obtenerEtiquetas();
		for (int i = 0; i < this.etiquetas_en_tabla.size(); i++) {
			this.ventanaPersona.agregarEtiquetaCombo(this.etiquetas_en_tabla.get(i).getEtiqueta());
		}
		this.localidades_en_tabla = agenda.obtenerLocalidades();
		for (int i = 0; i < this.localidades_en_tabla.size(); i++) {
			this.ventanaPersona.agregarLocalidadCombo(this.localidades_en_tabla.get(i).getLocalidad());
		}
	}

	/* Carga las localidades y etiquetas en la ventana de edici�n de personas */
	private void llenarComboBoxEditarPersona(String etiqueta, String localidad) {
		this.etiquetas_en_tabla = agenda.obtenerEtiquetas();
		for (int i = 0; i < this.etiquetas_en_tabla.size(); i++) {
			this.ventanaEditaPersona.agregarEtiquetaCombo(this.etiquetas_en_tabla.get(i).getEtiqueta());
			if (this.etiquetas_en_tabla.get(i).getEtiqueta().equals(etiqueta)) {
				this.ventanaEditaPersona.getCmbEtiquetas().setSelectedIndex(i);
			}
		}

		this.localidades_en_tabla = agenda.obtenerLocalidades();
		for (int i = 0; i < this.localidades_en_tabla.size(); i++) {
			this.ventanaEditaPersona.agregarLocalidadCombo(this.localidades_en_tabla.get(i).getLocalidad());
			if (this.localidades_en_tabla.get(i).getLocalidad().equals(localidad)) {
				this.ventanaEditaPersona.getCmbLocalidad().setSelectedIndex(i);
			}
		}
	}

	/* actualizar tabla de localidades */
	private void llenarTablaLocalidades() {
		this.vistaLocalidad.getModelLocalidades().setRowCount(0); // Para vaciar la tabla
		this.vistaLocalidad.getModelLocalidades().setColumnCount(0);
		this.vistaLocalidad.getModelLocalidades().setColumnIdentifiers(this.vistaLocalidad.getNombreColumnas());

		this.localidades_en_tabla = agenda.obtenerLocalidades();
		for (int i = 0; i < this.localidades_en_tabla.size(); i++) {
			Object[] fila = { this.localidades_en_tabla.get(i).getLocalidad() };
			this.vistaLocalidad.getModelLocalidades().addRow(fila);
		}
	}

	/* obtener elemento seleccionado del JcomboBox */
	private String obtenerElementoSelecciona(JComboBox comboBox) {
		return comboBox.getSelectedItem().toString();
	}
	

	public void actionPerformed(ActionEvent e) {

		/** Vista Persona **/
		/* Ventana de Alta de persona */
		if (e.getSource() == this.vista.getBtnAgregar()) {
			this.ventanaPersona = new VentanaPersona(this);
			this.ventanaPersona.getBtnEtiqueta().addActionListener(this);
			this.llenarComboBoxNuevaPersona();
		}
		/* Agrega una nueva persona */
		else if (this.ventanaPersona != null && e.getSource() == this.ventanaPersona.getBtnAgregarPersona()) {			
			/** Crea el domicilio **/
			DomicilioDTO nuevoDomicilio = new DomicilioDTO(0, 
					this.ventanaPersona.getTxtCalle().getText(),
					this.ventanaPersona.getTxtAltura().getText(), 
					this.ventanaPersona.getTxtPiso().getText(),
					this.ventanaPersona.getTxtDepartamento().getText(), 
					this.agenda.obtenerIdLocalidad(this.obtenerElementoSelecciona(this.ventanaPersona.getCmbLocalidad())));
					this.agenda.agregarDocimilio(nuevoDomicilio); /** Guarda el domicilio en la DB **/
			/** Crea la persona **/
			PersonaDTO nuevaPersona = new PersonaDTO(0, this.ventanaPersona.getTxtNombre().getText(),
					this.ventanaPersona.getTxtApellido().getText(),
					this.ventanaPersona.getTxtTelefono().getText(), 
					this.ventanaPersona.getTxtEmail().getText(),
					this.ventanaPersona.getTxtFechaNacimiento(), 
					this.agenda.obtenerIdDomicilio(nuevoDomicilio), /* Busca el id del domicilio guardado anteriormente */
					this.agenda.obtenerIdEtiqueta(this.obtenerElementoSelecciona(this.ventanaPersona.getCmbEtiquetas())));
			
			if(Validador.validaVentanaPersona(ventanaPersona)) {
				return;
			}else {
				this.agenda.agregarPersona(nuevaPersona);/** Guarda la persona en la DB **/
				this.llenarTablaPersonas();
				this.ventanaPersona.dispose();	
			}
		}
		/* Borra una persona seleccionada */
		else if (e.getSource() == this.vista.getBtnBorrar()) {
			int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filas_seleccionadas) {
				this.agenda.borrarPersona(this.personas_en_tabla.get(fila).getIdPersona());
				this.agenda.borrarDomicilio(this.personas_en_tabla.get(fila).getIdDomicilio());
			}
			this.llenarTablaPersonas(); // Actualiza la tabla de personas
		}
		/* Abrir la ventana de edici�n de personas */
		else if (e.getSource() == this.vista.getBtnEditar()) {
			this.ventanaEditaPersona = new VentanaEditaPersona(this);
			int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			String etiqueta = "";
			String localidad = "";
			for (int fila : filas_seleccionadas) {
				this.ventanaEditaPersona.setTxtNombre(this.personas_en_tabla.get(fila).getNombre());
				this.ventanaEditaPersona.setTxtApellido(this.personas_en_tabla.get(fila).getApellido());
				this.ventanaEditaPersona.setTxtTelefono(this.personas_en_tabla.get(fila).getTelefono());
				this.ventanaEditaPersona.setTxtEmail(this.personas_en_tabla.get(fila).getEmail());
				this.ventanaEditaPersona.setTxtFechaNacimiento((this.personas_en_tabla.get(fila).getFeNacimiento()));
				/* Completa los campos de domicilio */
				this.ventanaEditaPersona.setTxtCalle(
						this.agenda.obtenerDomicilioDTO(this.personas_en_tabla.get(fila).getIdDomicilio()).getCalle());
				this.ventanaEditaPersona.setTxtAltura(
						this.agenda.obtenerDomicilioDTO(this.personas_en_tabla.get(fila).getIdDomicilio()).getAltura());
				this.ventanaEditaPersona.setTxtPiso(
						this.agenda.obtenerDomicilioDTO(this.personas_en_tabla.get(fila).getIdDomicilio()).getPiso());
				this.ventanaEditaPersona.setTxtDepartamento(this.agenda
						.obtenerDomicilioDTO(this.personas_en_tabla.get(fila).getIdDomicilio()).getDepartamento());
				etiqueta = this.agenda.obtenerEtiqueta(this.personas_en_tabla.get(fila).getIdEtiqueta());
				localidad = this.agenda.obtenerLocalidad(this.agenda
						.obtenerDomicilioDTO(this.personas_en_tabla.get(fila).getIdDomicilio()).getIdLocalidad());
			}
			this.llenarComboBoxEditarPersona(etiqueta, localidad);
			this.ventanaEditaPersona.setVisible(true);
			this.ventanaEditaPersona.getBtnEtiqueta().addActionListener(this);
		}
		/* Abrir la ventana para crear etiquetas dentro del abrir personas*/
		else if (this.ventanaPersona != null && e.getSource() == this.ventanaPersona.getBtnEtiqueta()) {
				this.vistaEtiqueta = new VistaEtiqueta(this);
				this.llenarTablaEtiquetas();
				this.vistaEtiqueta.setVisible(true);
		}
		
		/* Edita la persona */
		else if (this.ventanaEditaPersona != null
				&& e.getSource() == this.ventanaEditaPersona.getBtnModificarPersona()) {
			
			int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filas_seleccionadas) {
				/* Edito primero el domicilio */
				
				if(Validador.validaVentanaEditarPersona(this.ventanaEditaPersona)) {
					return;
				}else{
				this.agenda.editarDomicilio(this.ventanaEditaPersona.getTxtCalle().getText(),
						this.ventanaEditaPersona.getTxtAltura().getText(),
						this.ventanaEditaPersona.getTxtPiso().getText(),
						this.ventanaEditaPersona.getTxtDepartamento().getText(),
						this.agenda.obtenerIdLocalidad(
								this.obtenerElementoSelecciona(this.ventanaEditaPersona.getCmbLocalidad())),
						this.personas_en_tabla.get(fila).getIdDomicilio());

				/* Edita a la persona */
				this.agenda.editarPersona(this.ventanaEditaPersona.getTxtNombre().getText(),
						this.ventanaEditaPersona.getTxtApellido().getText(),
						this.ventanaEditaPersona.getTxtTelefono().getText(),
						this.ventanaEditaPersona.getTxtEmail().getText(),
						Fechas.deDateToString(this.ventanaEditaPersona.getTxtFechaNacimiento()),
						this.personas_en_tabla.get(fila).getIdDomicilio(),
						this.agenda.obtenerIdEtiqueta(
								this.obtenerElementoSelecciona(this.ventanaEditaPersona.getCmbEtiquetas())),
						this.personas_en_tabla.get(fila).getIdPersona());
				}
			}
			this.llenarTablaPersonas();
			this.ventanaEditaPersona.setVisible(false);
		}
		
		/* Abrir la ventana para crear etiquetas dentro del editar de  personas*/
		else if (this.ventanaEditaPersona != null && e.getSource() == this.ventanaEditaPersona.getBtnEtiqueta()) {
				this.vistaEtiqueta = new VistaEtiqueta(this);
				this.llenarTablaEtiquetas();
				this.vistaEtiqueta.setVisible(true);
		}
		
		/** Vista Etiqueta **/
		/* Abrir la ventana de Etiquetar (lista de etiquetas y botones ABM */
		else if (e.getSource() == this.vista.getBtnEtiqueta()) {
			this.vistaEtiqueta = new VistaEtiqueta(this);
			this.llenarTablaEtiquetas();
			this.vistaEtiqueta.setVisible(true);
		}
		/* Agrega una nueva persona */
		else if (this.vistaEtiqueta != null && e.getSource() == this.vistaEtiqueta.getBtnAgregarEtiqueta()) {
			this.ventanaEtiqueta = new VentanaEtiqueta(this);
		}
		/* Abre la ventana de edici�n de etiquetas */
		else if (this.vistaEtiqueta != null && e.getSource() == this.vistaEtiqueta.getBtnEditarEtiqueta()) {
			this.ventanaEditaEtiqueta = new VentanaEditaEtiqueta(this);
			int[] filas_seleccionadas = this.vistaEtiqueta.getTablaEtiqueta().getSelectedRows();
			for (int fila : filas_seleccionadas) {
				this.ventanaEditaEtiqueta.setTxtEtiqueta(this.etiquetas_en_tabla.get(fila).getEtiqueta());
				;
			}
			this.ventanaEditaEtiqueta.setVisible(true);
		}
		/* Abre la ventana de cambiar la etiqueta */
		else if (this.ventanaEditaEtiqueta != null
				&& e.getSource() == this.ventanaEditaEtiqueta.getBtnGuardarEtiqueta()) {
			int[] filas_seleccionadas = this.vistaEtiqueta.getTablaEtiqueta().getSelectedRows();
			for (int fila : filas_seleccionadas) {
				this.agenda.editarEtiqueta(this.ventanaEditaEtiqueta.getTxtEtiqueta().getText(),
						this.etiquetas_en_tabla.get(fila));
			}
			this.llenarTablaEtiquetas();
			this.ventanaEditaEtiqueta.setVisible(false);
		}
		/* Agrega una nueva etiqueta */
		else if (this.ventanaEtiqueta != null && e.getSource() == this.ventanaEtiqueta.getBtnAgregarEtiqueta()) {
			EtiquetaDTO nuevaEtiqueta = new EtiquetaDTO(0, this.ventanaEtiqueta.getTxtEtiqueta().getText());
			this.agenda.agregarEtiqueta(nuevaEtiqueta);
			this.llenarTablaEtiquetas();
			this.ventanaEtiqueta.dispose();
		}
		/* Borrar una etiqueta seleccionada */
		else if (this.vistaEtiqueta != null && e.getSource() == this.vistaEtiqueta.getBtnBorrarEtiqueta()) {
			int[] filas_seleccionadas = this.vistaEtiqueta.getTablaEtiqueta().getSelectedRows();
			for (int fila : filas_seleccionadas) {
				this.agenda.borrarEtiqueta(this.etiquetas_en_tabla.get(fila).getIdEtiqueta());
			}
			this.llenarTablaEtiquetas();
		}

		/** Vista Localidad **/
		/* Abrir la ventana de Localidad (lista de etiquetas y botones ABM */
		else if (e.getSource() == this.vista.getBtnLocalidad()) {
			this.vistaLocalidad = new VistaLocalidad(this);
			this.llenarTablaLocalidades();
			this.vistaLocalidad.setVisible(true);
		}
		/* Agrega una nueva persona */
		else if (this.vistaLocalidad != null && e.getSource() == this.vistaLocalidad.getBtnAgregarLocalidad()) {
			this.ventanaLocalidad = new VentanaLocalidad(this);
		}
		/* Abre la ventana de edici�n de localidad */
		else if (this.vistaLocalidad != null && e.getSource() == this.vistaLocalidad.getBtnEditarLocalidad()) {
			this.ventanaEditaLocalidad = new VentanaEditaLocalidad(this);
			int[] filas_seleccionadas = this.vistaLocalidad.getTablaLocalidad().getSelectedRows();
			for (int fila : filas_seleccionadas) {
				this.ventanaEditaLocalidad.setTxtLocalidad(this.localidades_en_tabla.get(fila).getLocalidad());
			}
			this.ventanaEditaLocalidad.setVisible(true);
		}
		/* Abre la ventana de cambiar la localidad */
		else if (this.ventanaEditaLocalidad != null
				&& e.getSource() == this.ventanaEditaLocalidad.getBtnGuardarLocalidad()) {
			int[] filas_seleccionadas = this.vistaLocalidad.getTablaLocalidad().getSelectedRows();
			for (int fila : filas_seleccionadas) {
				this.agenda.editarLocalidad(this.ventanaEditaLocalidad.getTxtLocalidad().getText(),
						this.localidades_en_tabla.get(fila));
			}
			this.llenarTablaLocalidades();
			this.ventanaEditaLocalidad.setVisible(false);
		}
		/* Agrega una nueva localidad */
		else if (this.ventanaLocalidad != null && e.getSource() == this.ventanaLocalidad.getBtnAgregarLocalidad()) {
			LocalidadDTO nuevaLocalidad = new LocalidadDTO(0, this.ventanaLocalidad.getTxtLocalidad().getText());
			this.agenda.agregarLocalidad(nuevaLocalidad);
			this.llenarTablaLocalidades();
			this.ventanaLocalidad.dispose();
		}
		/* Borrar una localidad seleccionada */
		else if (this.vistaLocalidad != null && e.getSource() == this.vistaLocalidad.getBtnBorrarLocalidad()) {
			int[] filas_seleccionadas = this.vistaLocalidad.getTablaLocalidad().getSelectedRows();
			for (int fila : filas_seleccionadas) {
				this.agenda.borrarLocalidad(this.localidades_en_tabla.get(fila).getIdLocalidad());
			}
			this.llenarTablaLocalidades();
		}

		/** Reporte **/
		else if (e.getSource() == this.vista.getBtnReporte()) {
			ReporteAgenda reporte  = new ReporteAgenda(this.agenda.getPersonaReporte());
			reporte.mostrar();
		}
	}
 
	public Agenda getAgenda() {
		return this.agenda;
	}

}
