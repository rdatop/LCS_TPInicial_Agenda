package presentacion.vista;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JCalendar;



import presentacion.controlador.Controlador;


import java.awt.Font;

public class VentanaPersona extends JFrame {
	private static final long serialVersionUID = 1L;

	/* Paneles */
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
	private JCalendar txtFechaNacimiento;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtDepartamento;

	/* Despligables */
	@SuppressWarnings("rawtypes")
	private JComboBox cmbEtiquetas;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbLocalidad;

	/* Botones */
	private JButton btnAgregarPersona;

	/* Otras variables */
	private Controlador controlador;
	private JLabel label_1;

	public VentanaPersona(Controlador controlador) {
		super();
		setTitle("Nueva Persona");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\address_book.png"));
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 711, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setAutoscrolls(true);
		panel.setBounds(10, 11, 675, 264);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 25, 113, 14);
		panel.add(lblNombreYApellido);

		txtNombre = new JTextField();
		txtNombre.setBounds(133, 22, 192, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 50, 113, 14);
		panel.add(lblTelfono);

		txtTelefono = new JFormattedTextField();
		txtTelefono.setToolTipText("");
		txtTelefono.setBounds(133, 47, 192, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		lblemail = new JLabel("eMail");
		lblemail.setBounds(10, 75, 113, 14);
		panel.add(lblemail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(133, 72, 192, 20);
		panel.add(txtEmail);

		lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(10, 100, 113, 14);
		panel.add(lblFechaNacimiento);

		txtFechaNacimiento = new JCalendar();
		////////verificar
		//txtFechaNacimiento.setTodayButtonText("");
		txtFechaNacimiento.setToolTipText("");//esto lo hice para prbar
		txtFechaNacimiento.setName("fecha de nacimiento");
		txtFechaNacimiento.setFocusCycleRoot(true);
		txtFechaNacimiento.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtFechaNacimiento.setWeekOfYearVisible(false);
		txtFechaNacimiento.setBounds(133, 97, 192, 131);
		panel.add(txtFechaNacimiento);

		lblEtiqueta = new JLabel("Etiqueta");
		lblEtiqueta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEtiqueta.setBounds(10, 236, 113, 14);
		panel.add(lblEtiqueta);

		cmbEtiquetas = new JComboBox();
		cmbEtiquetas.setBounds(133, 233, 192, 20);
		panel.add(cmbEtiquetas);

		panelDomicilio = new JPanel();
		panelDomicilio.setAutoscrolls(true);
		panelDomicilio.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelDomicilio.setBounds(355, 50, 310, 144);
		panel.add(panelDomicilio);
		panelDomicilio.setLayout(null);

		lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 12, 113, 14);
		panelDomicilio.add(lblCalle);

		txtCalle = new JTextField();
		txtCalle.setBounds(134, 7, 164, 20);
		txtCalle.setColumns(10);
		panelDomicilio.add(txtCalle);

		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 38, 113, 14);
		panelDomicilio.add(lblAltura);

		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(134, 34, 164, 20);
		panelDomicilio.add(txtAltura);

		lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 64, 113, 14);
		panelDomicilio.add(lblPiso);

		txtPiso = new JTextField();
		txtPiso.setColumns(10);
		txtPiso.setBounds(134, 61, 164, 20);
		panelDomicilio.add(txtPiso);

		lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(10, 90, 113, 14);
		panelDomicilio.add(lblDepartamento);

		txtDepartamento = new JTextField();
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(134, 88, 164, 20);
		panelDomicilio.add(txtDepartamento);

		lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 116, 113, 14);
		panelDomicilio.add(lblLocalidad);

		cmbLocalidad = new JComboBox();
		cmbLocalidad.setBounds(133, 115, 164, 20);
		panelDomicilio.add(cmbLocalidad);

		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.addActionListener(this.controlador);
		btnAgregarPersona.setBounds(576, 205, 89, 23);
		panel.add(btnAgregarPersona);
		//Validacion.validaForm(txtNombre, label_1);
		
		JLabel label = new JLabel("Domicilio");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(464, 28, 113, 14);
		panel.add(label);
		
		//prueba de validacion
		label_1 = new JLabel("!!Campo OBLIGATORIO¡¡");
		label_1.setForeground(Color.RED);
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(361, 219, 135, 14);
		label_1.setVisible(false);
		panel.add(label_1);
						
		this.setVisible(true);
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public Date getTxtFechaNacimiento() {
		return txtFechaNacimiento.getDate();
	}

	public void setTxtFechaNacimiento(Date txtFechaNacimiento) {
		this.txtFechaNacimiento.setDate(txtFechaNacimiento);;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtCalle() {
		return txtCalle;
	}

	public void setTxtCalle(JTextField txtCalle) {
		this.txtCalle = txtCalle;
	}

	public JTextField getTxtAltura() {
		return txtAltura;
	}

	public void setTxtAltura(JTextField txtAltura) {
		this.txtAltura = txtAltura;
	}

	public JTextField getTxtPiso() {
		return txtPiso;
	}

	public void setTxtPiso(JTextField txtPiso) {
		this.txtPiso = txtPiso;
	}

	public JTextField getTxtDepartamento() {
		return txtDepartamento;
	}

	public void setTxtDepartamento(JTextField txtDepartamento) {
		this.txtDepartamento = txtDepartamento;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCmbEtiquetas() {
		return cmbEtiquetas;
	}

	@SuppressWarnings("rawtypes")
	public void setCmbEtiquetas(JComboBox cmbEtiquetas) {
		this.cmbEtiquetas = cmbEtiquetas;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCmbLocalidad() {
		return cmbLocalidad;
	}

	@SuppressWarnings("rawtypes")
	public void setCmbLocalidad(JComboBox cbxLocalidad) {
		this.cmbLocalidad = cbxLocalidad;
	}

	public JButton getBtnAgregarPersona() {
		return btnAgregarPersona;
	}

	public void setBtnAgregarPersona(JButton btnAgregarPersona) {
		this.btnAgregarPersona = btnAgregarPersona;
	}

	@SuppressWarnings("unchecked")
	public void agregarEtiquetaCombo(String etiqueta) {
		this.cmbEtiquetas.addItem(etiqueta);
	}

	@SuppressWarnings("unchecked")
	public void agregarLocalidadCombo(String localidad) {
		this.cmbLocalidad.addItem(localidad);
	}
}
