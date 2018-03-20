package presentacion.vista;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.Controlador;
import javax.swing.border.BevelBorder;

public class VentanaEditaPersona extends JFrame {
	private static final long serialVersionUID = 1L;

	/* Paneles */
	private JPanel panel;
	private JPanel contentPane;
	private JPanel panelDomicilio;

	/* Rotulos */
	private JLabel lblFechaNacimiento;
	private JLabel lblNombreYApellido;
	private JLabel lblEtiqueta;
	private JLabel lblemail;
	private JLabel lblTelfono;
	private JLabel lblCalle;
	private JLabel lblAltura;
	private JLabel lblPiso;
	private JLabel lblDepartamento;
	private JLabel lblLocalidad;

	/* Textos */
	private JTextField txtNombre;
	private JTextField txtFechaNacimiento;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtDepartamento;

	/* Desplegables */
	private JComboBox cmbEtiquetas;
	private JComboBox cmbLocalidad;

	/* Botones */
	private JButton btnModificarPersona;

	/* Otras variables */
	private Controlador controlador;

	public VentanaEditaPersona(Controlador controlador) {
		super();
		setTitle("Editar Persona");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\address_book.png"));
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 678, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/** Persona **/

		/* Paneles */
		this.panel = new JPanel();
		this.panel.setBounds(10, 11, 645, 191);
		this.contentPane.add(this.panel);
		this.panel.setLayout(null);

		/* Rotulos */
		this.lblNombreYApellido = new JLabel("Nombre y apellido");
		this.lblNombreYApellido.setBounds(10, 25, 113, 14);
		this.panel.add(this.lblNombreYApellido);

		this.lblTelfono = new JLabel("Telefono");
		this.lblTelfono.setBounds(10, 50, 113, 14);
		this.panel.add(this.lblTelfono);

		this.lblemail = new JLabel("eMail");
		this.lblemail.setBounds(10, 75, 113, 14);
		this.panel.add(this.lblemail);

		this.lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		this.lblFechaNacimiento.setBounds(10, 100, 113, 14);
		this.panel.add(this.lblFechaNacimiento);

		this.lblEtiqueta = new JLabel("Etiqueta");
		this.lblEtiqueta.setBounds(10, 125, 113, 14);
		this.panel.add(this.lblEtiqueta);

		/* Textos y ComboBoxs */
		this.txtNombre = new JTextField();
		this.txtNombre.setBounds(133, 22, 164, 20);
		this.panel.add(this.txtNombre);
		this.txtNombre.setColumns(10);

		this.txtTelefono = new JTextField();
		this.txtTelefono.setBounds(133, 47, 164, 20);
		this.panel.add(this.txtTelefono);
		this.txtTelefono.setColumns(10);

		this.txtEmail = new JTextField();
		this.txtEmail.setColumns(10);
		this.txtEmail.setBounds(133, 72, 164, 20);
		this.panel.add(this.txtEmail);

		this.txtFechaNacimiento = new JTextField();
		this.txtFechaNacimiento.setColumns(10);
		this.txtFechaNacimiento.setBounds(133, 97, 164, 20);
		this.panel.add(this.txtFechaNacimiento);

		this.cmbEtiquetas = new JComboBox();
		this.cmbEtiquetas.setBounds(133, 122, 164, 20);
		this.panel.add(this.cmbEtiquetas);

		/** Domicilio **/

		/* Paneles */
		this.panelDomicilio = new JPanel();
		this.panelDomicilio.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.panelDomicilio.setBounds(327, 11, 310, 144);
		this.panel.add(this.panelDomicilio);
		this.panelDomicilio.setLayout(null);

		/* Rotulos */
		this.lblCalle = new JLabel("Calle");
		this.lblCalle.setBounds(10, 12, 113, 14);
		this.panelDomicilio.add(this.lblCalle);

		this.lblAltura = new JLabel("Altura");
		this.lblAltura.setBounds(10, 38, 113, 14);
		this.panelDomicilio.add(this.lblAltura);

		this.lblPiso = new JLabel("Piso");
		this.lblPiso.setBounds(10, 64, 113, 14);
		this.panelDomicilio.add(this.lblPiso);

		this.lblDepartamento = new JLabel("Departamento");
		this.lblDepartamento.setBounds(10, 90, 113, 14);
		this.panelDomicilio.add(this.lblDepartamento);

		/* Textos y ComboBoxs */
		this.txtCalle = new JTextField();
		this.txtCalle.setBounds(134, 7, 164, 20);
		this.txtCalle.setColumns(10);
		this.panelDomicilio.add(this.txtCalle);

		this.txtAltura = new JTextField();
		this.txtAltura.setColumns(10);
		this.txtAltura.setBounds(134, 34, 164, 20);
		this.panelDomicilio.add(this.txtAltura);

		this.txtPiso = new JTextField();
		this.txtPiso.setColumns(10);
		this.txtPiso.setBounds(134, 61, 164, 20);
		this.panelDomicilio.add(this.txtPiso);

		this.txtDepartamento = new JTextField();
		this.txtDepartamento.setColumns(10);
		this.txtDepartamento.setBounds(134, 88, 164, 20);
		this.panelDomicilio.add(this.txtDepartamento);

		this.lblLocalidad = new JLabel("Localidad");
		this.lblLocalidad.setBounds(10, 116, 113, 14);
		this.panelDomicilio.add(this.lblLocalidad);

		/* Botones */
		this.btnModificarPersona = new JButton("Guardar");
		this.btnModificarPersona.addActionListener(this.controlador);
		this.btnModificarPersona.setBounds(548, 159, 89, 23);
		this.panel.add(this.btnModificarPersona);

		this.cmbLocalidad = new JComboBox();
		this.cmbLocalidad.setBounds(133, 115, 164, 20);
		this.panelDomicilio.add(this.cmbLocalidad);

		this.setVisible(true);
	}

	/* GETTERS */
	public JTextField getTxtNombre() {
		return this.txtNombre;
	}

	public JTextField getTxtFechaNacimiento() {
		return this.txtFechaNacimiento;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public JTextField getTxtEmail() {
		return this.txtEmail;
	}

	public JTextField getTxtCalle() {
		return this.txtCalle;
	}

	public JTextField getTxtAltura() {
		return this.txtAltura;
	}

	public JTextField getTxtPiso() {
		return txtPiso;
	}

	public JTextField getTxtDepartamento() {
		return this.txtDepartamento;
	}

	public JComboBox getCmbEtiquetas() {
		return this.cmbEtiquetas;
	}

	public JComboBox getCmbLocalidad() {
		return cmbLocalidad;
	}

	public JButton getBtnModificarPersona() {
		return btnModificarPersona;
	}

	/* SETTERS */
	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);
		;
	}

	public void setTxtFechaNacimiento(String txtFechaNacimiento) {
		this.txtFechaNacimiento.setText(txtFechaNacimiento);
	}

	public void setTxtTelefono(String txtTelefono) {
		this.txtTelefono.setText(txtTelefono);
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail.setText(txtEmail);
	}

	public void setTxtCalle(String txtCalle) {
		this.txtCalle.setText(txtCalle);
	}

	public void setTxtAltura(String txtAltura) {
		this.txtAltura.setText(txtAltura);
	}

	public void setTxtPiso(String txtPiso) {
		this.txtPiso.setText(txtPiso);
	}

	public void setTxtDepartamento(String txtDepartamento) {
		this.txtDepartamento.setText(txtDepartamento);
	}

	public void setCmbEtiquetas(JComboBox cmbEtiquetas) {
		this.cmbEtiquetas = cmbEtiquetas;
	}

	public void setCmbLocalidad(JComboBox cbxLocalidad) {
		this.cmbLocalidad = cbxLocalidad;
	}

	public void agregarEtiquetaCombo(String etiqueta) {
		this.cmbEtiquetas.addItem(etiqueta);
	}

	public void agregarLocalidadCombo(String localidad) {
		this.cmbLocalidad.addItem(localidad);
	}

}
