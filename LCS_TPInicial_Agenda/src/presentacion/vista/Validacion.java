package presentacion.vista;

import javax.swing.JTextField;

//import modelo.DaoUsuarios;
//import modelo.Usuario;

//import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Validacion {
	public static void validaForm(JTextField txtNombre,JLabel jblNombre)
	{
		if(validaCamposForm(txtNombre, jblNombre)){
			/*//valida la tupla
			Usuario t_usuario=new Usuario(usuario.getText(),new String(password.getPassword()));
			
			if(validaUsuario(t_usuario))
			{
				//la validacion fue exitosa
				JOptionPane.showMessageDialog(null,"Bienvid@ de nuevo "+t_usuario.getNombreUsuario());
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Usuario o password incorrectos");
			}*/
			
		}

		//JOptionPane.showMessageDialog(null,"mensaje");//ejemplo de popup	
	}
	
	
	private static boolean validaCamposForm(JTextField txtNombre,JLabel jblNombre)
	//valida que no haya errores de validaci�n de los campos del formulario
	{
		boolean errors=true;//en principio asumo que el formulario se va a validar correctamente
		jblNombre.setVisible(false);//oculto el error del campo nombre
		
		
		if(txtNombre.getText().equals(""))//s� el campo nombre es vacio
		{
			jblNombre.setVisible(true);//muestro el error correspondiente
			errors=false;//como hubo un error,cambio a false la variable de errores							
		}
		
		/*if(new String(password.getPassword()).equals(""))//s� el campo password es vacio
		{
			jblPassword.setVisible(true);//muestro el error correspondiente
			errors=false;//como hubo un error,cambio a false la variable de errores
		}*/
		
		return errors;
	}
	
	/*private static boolean validaUsuario(Usuario usuario)
	{
		boolean exito=false;
		
		ArrayList<Usuario> data=DaoUsuarios.getUsuarios();//traigo un arreglo de datos hardcodeados
		
		for(int i=0;i<data.size();i++)//itero la data harcodeada
		{
			exito=exito || data.get(i).equals(usuario);//verifico que el usuario exista en los registros
		}
		
		return exito;
	}*/
	
}
