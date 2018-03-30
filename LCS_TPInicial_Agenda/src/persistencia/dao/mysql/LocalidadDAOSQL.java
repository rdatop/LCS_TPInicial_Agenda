package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.LocalidadDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.LocalidadDAO;

public class LocalidadDAOSQL implements LocalidadDAO {
	private static final String insert = "INSERT INTO localidad (idLocalidad, localidad) VALUES(?, ?)";
	private static final String delete = "DELETE FROM localidad WHERE idLocalidad = ?";
	private static final String readall = "SELECT * FROM localidad ORDER BY localidad";
	private static final String edit = "UPDATE localidad SET localidad.localidad = ? WHERE idLocalidad = ?";
	private static final String getid = "SELECT idLocalidad FROM localidad WHERE localidad = ?";
	private static final String getlocalidad = "SELECT localidad from localidad WHERE idLocalidad = ?";
	
	public boolean insert(LocalidadDTO localidad) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, localidad.getIdLocalidad());
			statement.setString(2, localidad.getLocalidad().toUpperCase());
			if (statement.executeUpdate() > 0) // Si se ejecutï¿½ devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int idlocalidad_a_eliminar) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setInt(1, idlocalidad_a_eliminar);
			chequeoUpdate = statement.executeUpdate();
			if (chequeoUpdate > 0) // Si se ejecutÃ³ devuelvo true
				return true;
		} catch (SQLException e) {
			System.out.println("La localidad está en uso, no se puede borrar");
		}
		return false;
	}

	public List<LocalidadDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<LocalidadDTO> localidad = new ArrayList<LocalidadDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				localidad.add(new LocalidadDTO(resultSet.getInt("idLocalidad"), resultSet.getString("Localidad")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return localidad;
	}

	public boolean edit(String nueva_localidad, LocalidadDTO localidad_a_editar) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(edit);
			statement.setString(1, nueva_localidad.toUpperCase());
			statement.setInt(2, localidad_a_editar.getIdLocalidad());
			if (statement.executeUpdate() > 0) // Si se ejecutï¿½ devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int obtenerIdLocaldiad(String localidad) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		int idLocalidad = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(getid);
			statement.setString(1, localidad);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				idLocalidad = resultSet.getInt("idLocalidad");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idLocalidad;
	}
	
	public String obtenerLocalidad(int idLocalidad) {
		PreparedStatement statement;
		ResultSet resultSet;
		String localidad = "";
		Conexion conexion = Conexion.getConexion();
		try {
			statement =conexion.getSQLConexion().prepareStatement(getlocalidad);
			statement.setInt(1, idLocalidad);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				localidad = resultSet.getString("localidad");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return localidad;
	}
}
