package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import persistencia.conexion.Conexion;
import java.awt.Toolkit;

public class Vista {
	private JFrame frmMiAgenda;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnReporte;
	private JButton btnEtiqueta;
	private JButton btnLocalidad;
	private JButton btnEditar;

	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = { "Nombre y apellido", "Telefono", "eMail", "Fecha Cumpleanos", "Domicilio",
			"Etiqueta" };

	public Vista() {
		super();
		//estilizacion de la vista hay que verlo para la proxima
		/*try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e){
			e.printStackTrace();
		}*/
		initialize();
	}

	private void initialize() {
		frmMiAgenda = new JFrame();
		frmMiAgenda.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\address_book.png"));
		frmMiAgenda.setTitle("Mi Agenda");
		frmMiAgenda.setBounds(100, 100, 743, 468);
		frmMiAgenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMiAgenda.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 705, 408);
		frmMiAgenda.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 685, 352);
		panel.add(spPersonas);

		modelPersonas = new DefaultTableModel(null, nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);

		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(3);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(2).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(3).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(3).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(4).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(4).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(5).setPreferredWidth(50);
		tablaPersonas.getColumnModel().getColumn(5).setResizable(false);

		spPersonas.setViewportView(tablaPersonas);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(24, 374, 89, 23);
		panel.add(btnAgregar);

		this.btnEditar = new JButton("Editar");
		this.btnEditar.setBounds(137, 374, 89, 23);
		panel.add(this.btnEditar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(250, 374, 89, 23);
		panel.add(btnBorrar);

		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(363, 374, 89, 23);
		panel.add(btnReporte);

		btnEtiqueta = new JButton("Etiqueta");
		btnEtiqueta.setBounds(476, 374, 89, 23);
		panel.add(btnEtiqueta);

		btnLocalidad = new JButton("Localidad");
		btnLocalidad.setBounds(589, 374, 89, 23);
		panel.add(btnLocalidad);
	}

	public void show() {
		this.frmMiAgenda.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frmMiAgenda.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(null, "Estas seguro que quieres salir de la Agenda!?",
						"Confirmaci�n", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0) {
					Conexion.getConexion().cerrarConexion();
					System.exit(0);
				}
			}
		});
		this.frmMiAgenda.setVisible(true);
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public JButton getBtnReporte() {
		return btnReporte;
	}

	public JButton getBtnEditar() {
		return this.btnEditar;
	}

	public JButton getBtnEtiqueta() {
		return btnEtiqueta;
	}

	public DefaultTableModel getModelPersonas() {
		return modelPersonas;
	}

	public JTable getTablaPersonas() {
		return tablaPersonas;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public JButton getBtnLocalidad() {
		return btnLocalidad;
	}
}
