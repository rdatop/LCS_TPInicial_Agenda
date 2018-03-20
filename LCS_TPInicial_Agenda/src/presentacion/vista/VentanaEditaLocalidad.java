package presentacion.vista;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.Controlador;

public class VentanaEditaLocalidad extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLocalidad;
	private JButton btnGuardarLocalidad;
	private Controlador controlador;
	private JPanel panel;
	private JLabel lblEtiqueta;

	public VentanaEditaLocalidad(Controlador controlador) {
		super();
		setTitle("Editar Localidad");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\address_book.png"));
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 339, 129);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		this.panel = new JPanel();
		this.panel.setBounds(10, 11, 307, 76);
		this.contentPane.add(this.panel);
		this.panel.setLayout(null);

		this.lblEtiqueta = new JLabel("Localidad");
		this.lblEtiqueta.setBounds(10, 11, 113, 14);
		this.panel.add(this.lblEtiqueta);

		this.txtLocalidad = new JTextField();
		this.txtLocalidad.setBounds(133, 8, 164, 20);
		this.panel.add(this.txtLocalidad);
		this.txtLocalidad.setColumns(10);

		this.btnGuardarLocalidad = new JButton("Guardar");
		this.btnGuardarLocalidad.addActionListener(this.controlador);
		this.btnGuardarLocalidad.setBounds(208, 39, 89, 23);
		panel.add(this.btnGuardarLocalidad);

		this.setVisible(true);
	}

	public JTextField getTxtLocalidad() {
		return this.txtLocalidad;
	}

	public void setTxtLocalidad(String txtLocalidad) {
		this.txtLocalidad.setText(txtLocalidad);
	}

	public JButton getBtnGuardarLocalidad() {
		return this.btnGuardarLocalidad;
	}

}
