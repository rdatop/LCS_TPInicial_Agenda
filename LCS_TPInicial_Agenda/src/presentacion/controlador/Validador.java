package presentacion.controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import presentacion.vista.VentanaEditaPersona;
import presentacion.vista.VentanaPersona;

public class Validador {
	
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PATTERN_TELEFONO = "[0-9]*";
	private static final String PATTERN_ALTURA = "[0-9]*";
	private static final String PATTERN_APELLIDO = "^([A-ZÁÉÍÓÚ]{1}[A-Za-zñáéíóú]+[\\s]*)+$";
	
	public static boolean validaVentanaPersona(VentanaPersona ventanaPersona) {
		boolean ret = false;
		String campos ="Revise los siguientes campos obligatorios\n"	;
		ventanaPersona.getChkNombre().setVisible(false);
		ventanaPersona.getChkApellido().setVisible(false);
		ventanaPersona.getChkTelefono().setVisible(false);
		ventanaPersona.getChkCalle().setVisible(false);
		ventanaPersona.getChkAltura().setVisible(false);
		ventanaPersona.getChkMail().setVisible(false);
		if(ventanaPersona.getTxtNombre().getText().equals("")){
			ret = ret || true;
			campos += "[Nombre]\n";
			ventanaPersona.getChkNombre().setVisible(true);
		}
		if(ventanaPersona.getTxtApellido().getText().equals("")){
			ret = ret || true;
			campos += "[Apellido]\n";
			ventanaPersona.getChkApellido().setVisible(true);
		}
		if(ventanaPersona.getTxtTelefono().getText().equals("")){
			ret = ret || true;
			campos += "[Telefono]\n";
			ventanaPersona.getChkTelefono().setVisible(true);
		}
		if(ventanaPersona.getTxtCalle().getText().equals("")){
			ret = ret || true;
			campos += "[Calle]\n";
			ventanaPersona.getChkCalle().setVisible(true);
		}
		if(ventanaPersona.getTxtAltura().getText().equals("")){
			ret = ret || true;
			campos += "[Altura]\n";
			ventanaPersona.getChkAltura().setVisible(true);
		}
		/* Validamos formato */
		campos += "Revise los siguientes campos con datos incorrectos\n";
		if(!validaTexto(ventanaPersona.getTxtEmail().getText(), PATTERN_EMAIL) && !ventanaPersona.getTxtEmail().getText().equals("")){
			ret = ret || true;
			campos += "[eMail]: nombre@dominio.com\n";
			ventanaPersona.getChkMail().setVisible(true);
		}
		if(!validaTexto(ventanaPersona.getTxtTelefono().getText(), PATTERN_TELEFONO) && !ventanaPersona.getTxtTelefono().getText().equals("")){
			ret = ret || true;
			campos += "[Telefono]: 1234567890\n";
			ventanaPersona.getChkTelefono().setText("!");
			ventanaPersona.getChkTelefono().setVisible(true);
		}
		if(!validaTexto(ventanaPersona.getTxtAltura().getText(), PATTERN_ALTURA) && !ventanaPersona.getTxtAltura().getText().equals("")){
			ret = ret || true;
			campos += "[Altura]: 1234\n";
			ventanaPersona.getChkAltura().setText("!");
			ventanaPersona.getChkAltura().setVisible(true);
		}
		if(!validaTexto(ventanaPersona.getTxtApellido().getText(), PATTERN_APELLIDO) && !ventanaPersona.getTxtAltura().getText().equals("")){
			ret = ret || true;
			campos += "[Apellido]: Sin espacio al inicio\n Primera letra MAYUSCULA";
			ventanaPersona.getChkApellido().setText("!");
			ventanaPersona.getChkApellido().setVisible(true);
		}
		if(ret) {
			JOptionPane.showMessageDialog(null, campos, "Campos a revisar", JOptionPane.OK_OPTION);			
		}
		
		return ret;
	}

	public static boolean validaVentanaEditarPersona(VentanaEditaPersona ventanaPersona) {
		boolean ret = false;
		String campos ="Revise los siguientes campos obligatorios\n"	;
		ventanaPersona.getChkNombre().setVisible(false);
		ventanaPersona.getChkApellido().setVisible(false);
		ventanaPersona.getChkTelefono().setVisible(false);
		ventanaPersona.getChkCalle().setVisible(false);
		ventanaPersona.getChkAltura().setVisible(false);
		ventanaPersona.getChkMail().setVisible(false);
		if(ventanaPersona.getTxtNombre().getText().equals("")){
			ret = ret || true;
			campos += "[Nombre]\n";
			ventanaPersona.getChkNombre().setVisible(true);
		}
		if(ventanaPersona.getTxtApellido().getText().equals("")){
			ret = ret || true;
			campos += "[Apellido]\n";
			ventanaPersona.getChkApellido().setVisible(true);
		}
		if(ventanaPersona.getTxtTelefono().getText().equals("")){
			ret = ret || true;
			campos += "[Telefono]\n";
			ventanaPersona.getChkTelefono().setVisible(true);
		}
		if(ventanaPersona.getTxtCalle().getText().equals("")){
			ret = ret || true;
			campos += "[Calle]\n";
			ventanaPersona.getChkCalle().setVisible(true);
		}
		if(ventanaPersona.getTxtAltura().getText().equals("")){
			ret = ret || true;
			campos += "[Altura]\n";
			ventanaPersona.getChkAltura().setVisible(true);
		}
		/* Validamos formato */
		campos += "Revise los siguientes campos con datos incorrectos\n";
		if(!validaTexto(ventanaPersona.getTxtEmail().getText(), PATTERN_EMAIL) && !ventanaPersona.getTxtEmail().getText().equals("")){
			ret = ret || true;
			campos += "[eMail]: nombre@dominio.com\n";
			ventanaPersona.getChkMail().setVisible(true);
		}
		if(!validaTexto(ventanaPersona.getTxtTelefono().getText(), PATTERN_TELEFONO) && !ventanaPersona.getTxtTelefono().getText().equals("")){
			ret = ret || true;
			campos += "[Telefono]: 1234567890\n";
			ventanaPersona.getChkTelefono().setText("!");
			ventanaPersona.getChkTelefono().setVisible(true);
		}
		if(!validaTexto(ventanaPersona.getTxtAltura().getText(), PATTERN_ALTURA) && !ventanaPersona.getTxtAltura().getText().equals("")){
			ret = ret || true;
			campos += "[Altura]: 1234\n";
			ventanaPersona.getChkAltura().setText("!");
			ventanaPersona.getChkAltura().setVisible(true);
		}
		if(!validaTexto(ventanaPersona.getTxtApellido().getText(), PATTERN_APELLIDO) && !ventanaPersona.getTxtAltura().getText().equals("")){
			ret = ret || true;
			campos += "[Apellido]:Sin espacio al inicio\n Primera letra MAYUSCULA";
			ventanaPersona.getChkApellido().setText("!");
			ventanaPersona.getChkApellido().setVisible(true);
		}
				
		if(ret) {
			JOptionPane.showMessageDialog(null, campos, "Campos a revisar", JOptionPane.OK_OPTION);			
		}
		
		return ret;
	}

	
	private static boolean validaTexto(String texto, String validador){
		Pattern p = Pattern.compile(validador);
		Matcher m = p.matcher(texto);
		return m.matches();
	}


}
