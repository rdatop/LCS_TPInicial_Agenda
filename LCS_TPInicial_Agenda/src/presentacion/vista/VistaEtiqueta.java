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

public class VistaEtiqueta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable tablaEtiquetas;
	private Controlador controlador;
	private JButton btnAgregarEtiqueta;
	private JButton btnBorrarEtiqueta;
	private JButton btnEditarEtiqueta;
	private DefaultTableModel modelEtiquetas;
	private String[] nombreColumnas = { "Etiqueta" };

	public VistaEtiqueta(Controlador controlador) {
		super();
		setTitle("Etiquetas");
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

		JScrollPane spEtiqueta = new JScrollPane();
		spEtiqueta.setBounds(10, 11, 287, 182);
		panel.add(spEtiqueta);

		modelEtiquetas = new DefaultTableModel(null, nombreColumnas);
		tablaEtiquetas = new JTable(modelEtiquetas);
		tablaEtiquetas.getColumnModel().getColumn(0).setPreferredWidth(30);
		tablaEtiquetas.getColumnModel().getColumn(0).setResizable(false);

		spEtiqueta.setViewportView(tablaEtiquetas);

		btnAgregarEtiqueta = new JButton("Agregar");
		btnAgregarEtiqueta.addActionListener(this.controlador);
		btnAgregarEtiqueta.setBounds(10, 228, 89, 23);
		panel.add(btnAgregarEtiqueta);

		btnEditarEtiqueta = new JButton("Editar");
		btnEditarEtiqueta.addActionListener(this.controlador);
		btnEditarEtiqueta.setBounds(109, 228, 89, 23);
		panel.add(btnEditarEtiqueta);

		btnBorrarEtiqueta = new JButton("Borrar");
		btnBorrarEtiqueta.addActionListener(this.controlador);
		btnBorrarEtiqueta.setBounds(208, 228, 89, 23);
		panel.add(btnBorrarEtiqueta);
	}

	public JButton getBtnAgregarEtiqueta() {
		return btnAgregarEtiqueta;
	}

	public JButton getBtnBorrarEtiqueta() {
		return btnBorrarEtiqueta;
	}
	
	public JButton getBtnEditarEtiqueta() {
		return btnEditarEtiqueta;
	}

	public DefaultTableModel getModelEtiquetas() {
		return modelEtiquetas;
	}

	public JTable getTablaEtiqueta() {
		return tablaEtiquetas;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}


}
