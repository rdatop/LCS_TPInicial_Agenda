package persistencia.conexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;



public class ConfigConexion {

	private String ip;
	private String puerto;
	private String usuario;
	private String password;
	private String nombreBaseDatos;

	public ConfigConexion(String ip, String puerto, String bd, String usuario, String password) {
		this.setIp(ip);
		this.setPuerto(puerto);
		this.setNombreBaseDatos(bd);
		this.setUsuario(usuario);
		this.setPassword(password);
	}

	public ConfigConexion() {
		this.setIp("xxx");
		this.setPuerto("xxx");
		this.setNombreBaseDatos("xxx");
		this.setUsuario("xxx");
		this.setPassword("xxx");
	}

	public String getIp() {
		return this.ip;
	}

	public String getPuerto() {
		return this.puerto;
	}
	
	public String getNombreBaseDatos() {
		return this.nombreBaseDatos;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setNombreBaseDatos(String nombreBaseDatos) {
		this.nombreBaseDatos = nombreBaseDatos;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
