package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DomicilioDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.DomicilioDAO;

public class DomicilioDAOSQL implements DomicilioDAO {
	
	// TODO revisar
	private static final String insert = "INSERT INTO domicilio (idDomicilio, calle, altura, piso, departamento, idLocalidad) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM domicilio WHERE idDomicilio = ?";
	private static final String readall = "SELECT * FROM domicilio";
	private static final String getid = "SELECT idDomicilio FROM domicilio WHERE calle = ? AND altura = ? AND piso = ? AND departamento = ?";
	private static final String getdomicilio = "SELECT calle, altura, piso, departamento, idLocalidad from domicilio WHERE idDomicilio = ?";
	private static final String edit = "UPDATE domicilio SET domicilio.calle = ?, domicilio.altura = ?, domicilio.piso = ?, domicilio.departamento = ?, domicilio.idLocalidad = ? WHERE idDomicilio = ?";

	//inserta en la tabla dentro de la BD
	public boolean insert(DomicilioDTO domicilio) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, domicilio.getIdDomicilio());
			statement.setString(2, domicilio.getCalle());
			statement.setString(3, domicilio.getAltura());
			statement.setString(4, domicilio.getPiso());
			statement.setString(5, domicilio.getDepto());
			statement.setInt(6, domicilio.getIdLocalidad());
			if (statement.executeUpdate() > 0) // Si se ejecut� devuelvo true
				return true;
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return false;
	}

	//borra de la tabla
	public boolean delete(int iddomicilio_a_eliminar) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setInt(1, iddomicilio_a_eliminar);
			chequeoUpdate = statement.executeUpdate();
			if (chequeoUpdate > 0) // Si se ejecutó devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//lee todo lo de la tabla *
	public List<DomicilioDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<DomicilioDTO> domicilios = new ArrayList<DomicilioDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				domicilios.add(new DomicilioDTO(resultSet.getInt("idDomicilio"), resultSet.getString("Calle"),
						resultSet.getString("Altura"), resultSet.getString("Piso"), resultSet.getString("Departamento"),
						resultSet.getInt("idLocalidad")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return domicilios;
	}

	//lee el id de un domicilio determinado en la BD
	public int readIdDomicilio(DomicilioDTO domicilio) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		int idDomicilio = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(getid);
			statement.setString(1, domicilio.getCalle());
			statement.setString(2, domicilio.getAltura());
			statement.setString(3, domicilio.getPiso());
			statement.setString(4, domicilio.getDepto());

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				idDomicilio = resultSet.getInt("idDomicilio");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idDomicilio;
	}

	//lee un determinado domicilio
	public String readDomicilio(int idDomicilio) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		String domicilio = "";
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(getdomicilio);
			statement.setInt(1, idDomicilio);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				domicilio = resultSet.getString("calle") + " " + resultSet.getString("altura") + ""
				+ resultSet.getString("piso") + " " + resultSet.getString("departamento");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
			return domicilio;
	}
		
	public DomicilioDTO readDomicilioDTO(int idDomicilio) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		DomicilioDTO domicilio = null;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(getdomicilio);
			statement.setInt(1, idDomicilio);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				domicilio = new DomicilioDTO(0, resultSet.getString("calle"), 
					resultSet.getString("altura"), resultSet.getString("piso"), resultSet.getString("departamento"), resultSet.getInt("idLocalidad"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
			return domicilio;
	}
	
	//edita un domicilio
	public boolean edit(String nuevaCalle, String nuevaAltura, String nuevoPiso, String nuevoDepartamento, int nuevoIdLocalidad, int idDomicilio_a_modificar) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(edit);
			statement.setString(1, nuevaCalle);
			statement.setString(2, nuevaAltura);
			statement.setString(3, nuevoPiso);
			statement.setString(4, nuevoDepartamento);
			statement.setInt(5,nuevoIdLocalidad);
			statement.setInt(6, idDomicilio_a_modificar);
			if (statement.executeUpdate() > 0) // Si se ejecut� devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return false;
	}	
}
