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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VentanaPersona extends JFrame {
	private static final long serialVersionUID = 1L;

	/* Paneles */
	private JPanel contentPane;
	private JPanel panelDomicilio;

	/* Rotulos */
	private JLabel lblFechaNacimiento;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblEtiqueta;
	private JLabel lblemail;
	private JLabel lblTelfono;
	private JLabel lblCalle;
	private JLabel lblAltura;
	private JLabel lblPiso;
	private JLabel lblDepartamento;
	private JLabel lblLocalidad;
	private JLabel chkNombre;
	private JLabel chkApellido;
	private JLabel chkTelefono;
	private JLabel chkMail;
	private JLabel chkCalle;
	private JLabel chkAltura;

	/* Textos */
	private JTextField txtNombre;
	private JTextField txtApellido;
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
	private JButton btnEtiqueta;

	/* Otras variables */
	private Controlador controlador;

	public VentanaPersona(Controlador controlador) {
		super();
		setTitle("Nueva Persona");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\address_book.png"));
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 736, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setAutoscrolls(true);
		panel.setBounds(10, 11, 706, 300);
		contentPane.add(panel);
		panel.setLayout(null);

		this.lblNombre = new JLabel("Nombre");
		this.lblNombre.setBounds(10, 25, 113, 14);
		panel.add(this.lblNombre);

		this.lblApellido = new JLabel("Apellido");
		this.lblApellido.setBounds(365, 25, 113, 14);
		panel.add(this.lblApellido);

		this.lblTelfono = new JLabel("Tel\u00E9fono");
		this.lblTelfono.setBounds(10, 50, 113, 14);
		panel.add(this.lblTelfono);

		this.lblemail = new JLabel("eMail");
		this.lblemail.setBounds(10, 75, 113, 14);
		panel.add(this.lblemail);

		this.lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		this.lblFechaNacimiento.setBounds(10, 100, 113, 14);
		panel.add(lblFechaNacimiento);

		this.lblEtiqueta = new JLabel("Etiqueta");
		this.lblEtiqueta.setBounds(10, 236, 113, 14);
		panel.add(this.lblEtiqueta);

		this.chkNombre = new JLabel("*");
		this.chkNombre.setForeground(Color.RED);
		this.chkNombre.setBounds(326, 24, 5, 16);
		panel.add(this.chkNombre);
		this.chkNombre.setVisible(false);
		
		this.txtNombre = new JTextField();
		this.txtNombre.setBounds(133, 22, 192, 20);
		panel.add(this.txtNombre);
		this.txtNombre.setColumns(10);
		
		this.chkApellido = new JLabel("*");
		this.chkApellido .setForeground(Color.RED);
		this.chkApellido .setBounds(681, 24, 5, 16);
		panel.add(this.chkApellido);
		this.chkApellido.setVisible(false);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(488, 22, 192, 20);
		panel.add(txtApellido);

		this.chkTelefono= new JLabel("*");
		this.chkTelefono.setForeground(Color.RED);
		this.chkTelefono.setBounds(326, 47, 5, 16);
		panel.add(this.chkTelefono);
		this.chkTelefono.setVisible(false);
		
		txtTelefono = new JFormattedTextField();
		txtTelefono.setToolTipText("");
		txtTelefono.setBounds(133, 47, 192, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		this.chkMail= new JLabel("!");
		this.chkMail.setForeground(Color.RED);
		this.chkMail.setBounds(326, 72, 5, 16);
		panel.add(this.chkMail);
		this.chkMail.setVisible(false);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(133, 72, 192, 20);
		panel.add(txtEmail);

		txtFechaNacimiento = new JCalendar();
		txtFechaNacimiento.setTodayButtonText("");
		txtFechaNacimiento.setName("fecha de nacimiento");
		txtFechaNacimiento.setFocusCycleRoot(true);
		txtFechaNacimiento.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtFechaNacimiento.setWeekOfYearVisible(false);
		txtFechaNacimiento.setBounds(133, 97, 192, 131);
		panel.add(txtFechaNacimiento);

		cmbEtiquetas = new JComboBox();
		cmbEtiquetas.setBounds(133, 233, 145, 20);
		panel.add(cmbEtiquetas);

		btnEtiqueta = new JButton("+");
		btnEtiqueta.setFont(new Font("Dialog", Font.BOLD, 8));
		btnEtiqueta.setBounds(290, 233, 39, 20);
		panel.add(btnEtiqueta);

		JLabel lblDomicilioPanel = new JLabel("Domicilio");
		lblDomicilioPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblDomicilioPanel.setBounds(467, 60, 113, 14);
		panel.add(lblDomicilioPanel);

		this.panelDomicilio = new JPanel();
		this.panelDomicilio.setAutoscrolls(true);
		this.panelDomicilio.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.panelDomicilio.setBounds(368, 79, 310, 144);
		panel.add(this.panelDomicilio);
		this.panelDomicilio.setLayout(null);

		lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 12, 113, 14);
		panelDomicilio.add(lblCalle);

		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 38, 113, 14);
		panelDomicilio.add(lblAltura);

		lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 64, 113, 14);
		panelDomicilio.add(lblPiso);

		lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(10, 90, 113, 14);
		panelDomicilio.add(lblDepartamento);

		lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 116, 113, 14);
		panelDomicilio.add(lblLocalidad);
		
				this.chkCalle= new JLabel("*");
				chkCalle.setBounds(280, 9, 5, 16);
				panelDomicilio.add(chkCalle);
				this.chkCalle.setForeground(Color.RED);
				this.chkCalle.setVisible(false);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(134, 7, 144, 20);
		txtCalle.setColumns(10);
		panelDomicilio.add(txtCalle);
		
				this.chkAltura= new JLabel("*");
				chkAltura.setBounds(280, 34, 5, 16);
				panelDomicilio.add(chkAltura);
				this.chkAltura.setForeground(Color.RED);
				this.chkAltura.setVisible(false);
		
		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(134, 34, 144, 20);
		panelDomicilio.add(txtAltura);

		txtPiso = new JTextField();
		txtPiso.setColumns(10);
		txtPiso.setBounds(134, 61, 144, 20);
		panelDomicilio.add(txtPiso);

		txtDepartamento = new JTextField();
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(134, 88, 144, 20);
		panelDomicilio.add(txtDepartamento);

		cmbLocalidad = new JComboBox();
		cmbLocalidad.setBounds(133, 115, 145, 20);
		panelDomicilio.add(cmbLocalidad);

		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.addActionListener(this.controlador);
		btnAgregarPersona.setBounds(589, 227, 89, 23);
		panel.add(btnAgregarPersona);

		this.setVisible(true);
	}

	public JLabel getChkNombre() {
		return this.chkNombre;
	}
	
	public JLabel getChkApellido() {
		return this.chkApellido;
	}
	
	public JLabel getChkCalle() {
		return this.chkCalle;
	}
	
	public JLabel getChkTelefono() {
		return this.chkTelefono;
	}
	
	public JLabel getChkMail() {
		return this.chkMail;
	}
	
	public JLabel getChkAltura() {
		return this.chkAltura;
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public Date getTxtFechaNacimiento() {
		return txtFechaNacimiento.getDate();
	}

	public void setTxtFechaNacimiento(Date txtFechaNacimiento) {
		this.txtFechaNacimiento.setDate(txtFechaNacimiento);
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

	public JButton getBtnEtiqueta() {
		return btnEtiqueta;
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
