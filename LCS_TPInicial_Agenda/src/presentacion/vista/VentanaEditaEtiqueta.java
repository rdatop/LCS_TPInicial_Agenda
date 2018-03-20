package presentacion.vista;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.Controlador;

public class VentanaEditaEtiqueta extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField txtEtiqueta;
	private JButton btnGuardarEtiqueta;
	private Controlador controlador;

	public VentanaEditaEtiqueta(Controlador controlador) {
		super();
		setTitle("Editar Etiqueta");
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

		this.txtEtiqueta = new JFormattedTextField();
		this.txtEtiqueta.setBounds(133, 8, 164, 20);
		panel.add(this.txtEtiqueta);
		this.txtEtiqueta.setColumns(10);

		btnGuardarEtiqueta = new JButton("Guardar");
		btnGuardarEtiqueta.addActionListener(this.controlador);
		btnGuardarEtiqueta.setBounds(208, 39, 89, 23);
		panel.add(btnGuardarEtiqueta);

		this.setVisible(true);
	}

	public JTextField getTxtEtiqueta() {
		return txtEtiqueta;
	}
	
	public void setTxtEtiqueta(String txtEtiqueta) {
		this.txtEtiqueta.setText(txtEtiqueta);
	}

	public JButton getBtnGuardarEtiqueta() {
		return btnGuardarEtiqueta;
	}

}
