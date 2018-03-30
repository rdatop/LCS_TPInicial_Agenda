package persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import persistencia.dao.mysql.ConfiguracionDAO;

public class Conexion 
{
	public static Conexion instancia;
//	private static Properties prop;
	private Connection connection;
	
	private Conexion()
	{
		try
		{
//			prop.load(new FileInputStream("properties\\configuracion.properties"));
//			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_agenda","root","root");
			
			ConfiguracionDAO e = new ConfiguracionDAO();
			ConfigConexion config = e.obtenerConfiguracion("config.txt");
			System.out.println(config.getIp() + config.getPuerto() + config.getNombreBaseDatos() + config.getUsuario()+
					 config.getPassword());
			this.connection = DriverManager.getConnection(
					"jdbc:mysql://" + config.getIp() + ":" + config.getPuerto() + "/" + config.getNombreBaseDatos(), config.getUsuario(),
					 config.getPassword());
			
			
			
			System.out.println("Conexion exitosa");
		}
		catch(Exception e)
		{
			System.out.println("Conexion fallida");
			//System.out.println(config.getPassword());
			
		}
	}
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
			System.out.println("Conexion cerrada");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		instancia = null;
	}
}
