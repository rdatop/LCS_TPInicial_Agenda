package presentacion.vista;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import presentacion.controlador.Controlador;

public class VistaLocalidad extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable tablaLocalidades;
	private Controlador controlador;
	private JButton btnAgregarLocalidad;
	private JButton btnBorrarLocalidad;
	private JButton btnEditarLocalidad;
	private DefaultTableModel modelLocalidad;
	private String[] nombreColumnas = { "Localidad" };

	public VistaLocalidad(Controlador controlador) {
		super();
		setTitle("Localidades");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\address_book.png"));
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 320, 300);
		getContentPane().setLayout(null);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 306, 262);
		getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane spLocalidad = new JScrollPane();
		spLocalidad.setBounds(10, 11, 287, 182);
		panel.add(spLocalidad);

		modelLocalidad = new DefaultTableModel(null, nombreColumnas);
		tablaLocalidades = new JTable(modelLocalidad);
		tablaLocalidades.getColumnModel().getColumn(0).setPreferredWidth(30);
		tablaLocalidades.getColumnModel().getColumn(0).setResizable(false);

		spLocalidad.setViewportView(tablaLocalidades);

		btnAgregarLocalidad = new JButton("Agregar");
		btnAgregarLocalidad.addActionListener(this.controlador);
		btnAgregarLocalidad.setBounds(10, 228, 89, 23);
		panel.add(btnAgregarLocalidad);

		btnEditarLocalidad = new JButton("Editar");
		btnEditarLocalidad.addActionListener(this.controlador);
		btnEditarLocalidad.setBounds(109, 228, 89, 23);
		panel.add(btnEditarLocalidad);

		btnBorrarLocalidad = new JButton("Borrar");
		btnBorrarLocalidad.addActionListener(this.controlador);
		btnBorrarLocalidad.setBounds(208, 228, 89, 23);
		panel.add(btnBorrarLocalidad);
	}

	public JButton getBtnAgregarLocalidad() {
		return btnAgregarLocalidad;
	}

	public JButton getBtnBorrarLocalidad() {
		return btnBorrarLocalidad;
	}
	
	public JButton getBtnEditarLocalidad() {
		return btnEditarLocalidad;
	}

	public DefaultTableModel getModelLocalidades() {
		return modelLocalidad;
	}

	public JTable getTablaLocalidad() {
		return tablaLocalidades;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}


}
