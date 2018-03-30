package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.EtiquetaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.EtiquetaDAO;

public class EtiquetaDAOSQL implements EtiquetaDAO {
	private static final String insert = "INSERT INTO etiqueta(idEtiqueta, etiqueta) VALUES(?, ?)";
	private static final String delete = "DELETE FROM etiqueta WHERE idEtiqueta = ?";
	private static final String readall = "SELECT * FROM etiqueta ORDER BY etiqueta";
	private static final String edit = "UPDATE etiqueta SET etiqueta.etiqueta = ? WHERE idEtiqueta = ?";
	private static final String getid = "SELECT idEtiqueta FROM etiqueta WHERE etiqueta = ?";
	private static final String getetiqueta = "SELECT etiqueta FROM etiqueta WHERE idEtiqueta = ?";
	
	public boolean insert(EtiquetaDTO etiqueta) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, etiqueta.getIdEtiqueta());
			statement.setString(2, etiqueta.getEtiqueta().toUpperCase());
			if (statement.executeUpdate() > 0) // Si se ejecutï¿½ devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int idetiqueta_a_eliminar) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setInt(1, idetiqueta_a_eliminar);
			chequeoUpdate = statement.executeUpdate();
			if (chequeoUpdate > 0) // Si se ejecutÃ³ devuelvo true
				return true;
		} catch (SQLException e) {
			System.out.println("La etiqueta está en uso, no se puede borrar");
		}
		return false;
	}

	public List<EtiquetaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<EtiquetaDTO> etiqueta = new ArrayList<EtiquetaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				etiqueta.add(new EtiquetaDTO(resultSet.getInt("idEtiqueta"), resultSet.getString("Etiqueta")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return etiqueta;
	}

	public boolean edit(String nueva_etiqueta, EtiquetaDTO etiqueta_a_editar) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(edit);
			statement.setString(1, nueva_etiqueta.toUpperCase());
			statement.setInt(2, etiqueta_a_editar.getIdEtiqueta());
			if (statement.executeUpdate() > 0) // Si se ejecutï¿½ devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int obtenerIdEtiqueta (String etiqueta) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		int idEtiqueta = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(getid);
			statement.setString(1, etiqueta);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				idEtiqueta = resultSet.getInt("idEtiqueta");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idEtiqueta;
	}
	
	public String readEtiqueta(int idEtiqueta) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		String etiqueta = "";
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(getetiqueta);
			statement.setInt (1, idEtiqueta);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				etiqueta = resultSet.getString("Etiqueta");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return etiqueta;
	}

}
