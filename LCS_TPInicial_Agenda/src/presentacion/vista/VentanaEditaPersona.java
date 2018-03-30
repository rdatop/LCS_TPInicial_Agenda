package presentacion.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.toedter.calendar.JCalendar;

import presentacion.controlador.Controlador;

public class VentanaEditaPersona extends JFrame {
	private static final long serialVersionUID = 1L;

	/* Paneles */
	private JPanel panel;
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
	private JLabel lblDomicilioPanel;

	/* Checks */
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
	private JComboBox cmbEtiquetas;
	private JComboBox cmbLocalidad;

	/* Botones */
	private JButton btnModificarPersona;

	/* Otras variables */
	private Controlador controlador;
	private JButton btnEtiqueta;

	public VentanaEditaPersona(Controlador controlador) {
		super();
		setTitle("Editar Persona");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\address_book.png"));
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 736, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/** Persona **/

		/* Paneles */
		this.panel = new JPanel();
		this.panel.setBounds(10, 11, 706, 300);
		this.contentPane.add(this.panel);
		this.panel.setLayout(null);

		/* Rotulos */
		this.lblNombre = new JLabel("Nombre y apellido");
		this.lblNombre.setBounds(10, 25, 113, 14);
		this.panel.add(this.lblNombre);

		this.lblApellido = new JLabel("Apellido");
		this.lblApellido.setBounds(365, 23, 113, 14);
		this.panel.add(this.lblApellido);

		this.lblTelfono = new JLabel("Tel\u00E9fono");
		this.lblTelfono.setBounds(10, 50, 113, 14);
		this.panel.add(this.lblTelfono);

		this.lblemail = new JLabel("eMail");
		this.lblemail.setBounds(10, 75, 113, 14);
		this.panel.add(this.lblemail);

		this.lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		this.lblFechaNacimiento.setBounds(10, 100, 113, 14);
		this.panel.add(this.lblFechaNacimiento);

		this.lblEtiqueta = new JLabel("Etiqueta");
		this.lblEtiqueta.setBounds(10, 236, 113, 14);
		this.panel.add(this.lblEtiqueta);

		/* Textos y ComboBoxs */
		this.txtNombre = new JTextField();
		this.txtNombre.setBounds(133, 22, 192, 20);
		this.panel.add(this.txtNombre);
		this.txtNombre.setColumns(10);

		this.txtApellido = new JTextField();
		this.txtApellido.setColumns(10);
		this.txtApellido.setBounds(488, 20, 192, 20);
		this.panel.add(this.txtApellido);

		this.txtTelefono = new JTextField();
		this.txtTelefono.setBounds(133, 47, 192, 20);
		this.panel.add(this.txtTelefono);
		this.txtTelefono.setColumns(10);

		this.txtEmail = new JTextField();
		this.txtEmail.setColumns(10);
		this.txtEmail.setBounds(133, 72, 192, 20);
		this.panel.add(this.txtEmail);

		this.txtFechaNacimiento = new JCalendar();
		this.txtFechaNacimiento.setTodayButtonText("");
		this.txtFechaNacimiento.setName("fecha de nacimiento");
		this.txtFechaNacimiento.setFocusCycleRoot(true);
		this.txtFechaNacimiento.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.txtFechaNacimiento.setWeekOfYearVisible(false);
		this.txtFechaNacimiento.setBounds(133, 97, 192, 131);
		panel.add(this.txtFechaNacimiento);

		this.cmbEtiquetas = new JComboBox();
		this.cmbEtiquetas.setBounds(133, 233, 145, 20);
		this.panel.add(this.cmbEtiquetas);

		/* Checks */
		this.chkNombre = new JLabel("*");
		this.chkNombre.setForeground(Color.RED);
		this.chkNombre.setBounds(326, 24, 5, 16);
		panel.add(this.chkNombre);
		this.chkNombre.setVisible(false);
		
		this.chkApellido = new JLabel("*");
		this.chkApellido .setForeground(Color.RED);
		this.chkApellido .setBounds(681, 24, 5, 16);
		panel.add(this.chkApellido);
		this.chkApellido.setVisible(false);
		
		this.chkTelefono= new JLabel("*");
		this.chkTelefono.setForeground(Color.RED);
		this.chkTelefono.setBounds(326, 47, 5, 16);
		panel.add(this.chkTelefono);
		this.chkTelefono.setVisible(false);
		
		this.chkMail= new JLabel("!");
		this.chkMail.setForeground(Color.RED);
		this.chkMail.setBounds(326, 72, 5, 16);
		panel.add(this.chkMail);
		this.chkMail.setVisible(false);
		
		
		/** Domicilio **/

		this.lblDomicilioPanel = new JLabel("Domicilio");
		this.lblDomicilioPanel.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblDomicilioPanel.setBounds(467, 60, 113, 14);
		this.panel.add(lblDomicilioPanel);

		/* Paneles */
		this.panelDomicilio = new JPanel();
		this.panelDomicilio.setAutoscrolls(true);
		this.panelDomicilio.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.panelDomicilio.setBounds(368, 79, 310, 144);
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

		/* Checks */
		this.chkCalle= new JLabel("*");
		chkCalle.setBounds(280, 9, 5, 16);
		panelDomicilio.add(chkCalle);
		this.chkCalle.setForeground(Color.RED);
		this.chkCalle.setVisible(false);
		
		this.chkAltura= new JLabel("*");
		chkAltura.setBounds(280, 34, 5, 16);
		panelDomicilio.add(chkAltura);
		this.chkAltura.setForeground(Color.RED);
		this.chkAltura.setVisible(false);
		
		/* Textos y ComboBoxs */

		this.lblLocalidad = new JLabel("Localidad");
		this.lblLocalidad.setBounds(10, 116, 113, 14);
		this.panelDomicilio.add(this.lblLocalidad);
		this.txtCalle = new JTextField();
		this.txtCalle.setBounds(134, 7, 144, 20);
		this.txtCalle.setColumns(10);
		this.panelDomicilio.add(this.txtCalle);

		this.txtAltura = new JTextField();
		this.txtAltura.setColumns(10);
		this.txtAltura.setBounds(134, 34, 144, 20);
		this.panelDomicilio.add(this.txtAltura);

		this.txtPiso = new JTextField();
		this.txtPiso.setColumns(10);
		this.txtPiso.setBounds(134, 61, 144, 20);
		this.panelDomicilio.add(this.txtPiso);

		this.txtDepartamento = new JTextField();
		this.txtDepartamento.setColumns(10);
		this.txtDepartamento.setBounds(134, 88, 144, 20);
		this.panelDomicilio.add(this.txtDepartamento);

		/* Botones */
		this.btnModificarPersona = new JButton("Guardar");
		this.btnModificarPersona.addActionListener(this.controlador);
		this.btnModificarPersona.setBounds(589, 227, 89, 23);
		this.panel.add(this.btnModificarPersona);

		this.btnEtiqueta = new JButton("+");
		this.btnEtiqueta.setFont(new Font("Dialog", Font.BOLD, 8));
		this.btnEtiqueta.setBounds(290, 233, 39, 20);
		this.panel.add(this.btnEtiqueta);

		this.cmbLocalidad = new JComboBox();
		this.cmbLocalidad.setBounds(133, 115, 145, 20);
		this.panelDomicilio.add(this.cmbLocalidad);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtNombre, txtApellido, txtTelefono, txtEmail, txtFechaNacimiento, cmbEtiquetas, txtCalle, txtAltura, txtPiso, txtDepartamento, cmbLocalidad, btnModificarPersona}));

		this.setVisible(true);
	}

	/* GETTERS */
	public JTextField getTxtNombre() {
		return this.txtNombre;
	}

	public JTextField getTxtApellido() {
		return this.txtApellido;
	}

	public Date getTxtFechaNacimiento() {
		return txtFechaNacimiento.getDate();
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
		return this.cmbLocalidad;
	}

	public JButton getBtnModificarPersona() {
		return this.btnModificarPersona;
	}
	
	public JButton getBtnEtiqueta() {
		return this.btnEtiqueta;
	}
	
	
	public JLabel getChkNombre() {
		return chkNombre;
	}

	public JLabel getChkApellido() {
		return chkApellido;
	}

	public JLabel getChkTelefono() {
		return chkTelefono;
	}

	public JLabel getChkMail() {
		return chkMail;
	}

	public JLabel getChkCalle() {
		return chkCalle;
	}

	public JLabel getChkAltura() {
		return chkAltura;
	}

	/* SETTERS */
	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);
	}

	public void setTxtApellido(String txtApellido) {
		this.txtApellido.setText(txtApellido);
	}

	public void setTxtFechaNacimiento(Date txtFechaNacimiento) {
		this.txtFechaNacimiento.setDate(txtFechaNacimiento);
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
