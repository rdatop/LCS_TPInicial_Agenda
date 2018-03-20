package presentacion.vista;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.Controlador;

public class VentanaEtiqueta extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEtiqueta;
	private JButton btnAgregarEtiqueta;
	private Controlador controlador;

	public VentanaEtiqueta(Controlador controlador) {
		super();
		setTitle("Nueva Etiqueta");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\address_book.png"));
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 339, 129);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 307, 76);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblEtiqueta = new JLabel("Etiqueta");
		lblEtiqueta.setBounds(10, 11, 113, 14);
		panel.add(lblEtiqueta);

		txtEtiqueta = new JTextField();
		txtEtiqueta.setBounds(133, 8, 164, 20);
		panel.add(txtEtiqueta);
		txtEtiqueta.setColumns(10);

		btnAgregarEtiqueta = new JButton("Agregar");
		btnAgregarEtiqueta.addActionListener(this.controlador);
		btnAgregarEtiqueta.setBounds(208, 39, 89, 23);
		panel.add(btnAgregarEtiqueta);

		this.setVisible(true);
	}

	public JTextField getTxtEtiqueta() {
		return txtEtiqueta;
	}

	public JButton getBtnAgregarEtiqueta() {
		return btnAgregarEtiqueta;
	}

}
