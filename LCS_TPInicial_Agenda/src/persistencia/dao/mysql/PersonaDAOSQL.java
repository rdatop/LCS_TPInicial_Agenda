package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.PersonaDTO;
import modelo.Fechas;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;

public class PersonaDAOSQL implements PersonaDAO {
	private static final String insert = "INSERT INTO persona(idPersona, nombre, apellido, telefono, email, fechaNacimiento, idDomicilio, idEtiqueta) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM persona WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM persona ORDER BY persona.apellido";
	private static final String edit = "UPDATE persona SET persona.nombre = ?, persona.apellido = ?, persona.telefono = ?, persona.email = ?, persona.fechaNacimiento = ?, persona.idDomicilio = ?, persona.idEtiqueta = ? WHERE idPersona = ?";
	
	public boolean insert(PersonaDTO persona) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			statement.setString(4, persona.getTelefono());
			statement.setString(5, persona.getEmail());
			statement.setDate(6, Fechas.getFechasSQL(persona.getFeNacimiento()));
			statement.setInt(7, persona.getIdDomicilio());
			statement.setInt(8, persona.getIdEtiqueta());
			if (statement.executeUpdate() > 0) // Si se ejecutó devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int idpersona_a_eliminar) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setInt(1, idpersona_a_eliminar);
			chequeoUpdate = statement.executeUpdate();
			if (chequeoUpdate > 0) // Si se ejecutÃ³ devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<PersonaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				personas.add(new PersonaDTO(resultSet.getInt("idPersona"), 
						resultSet.getString("Nombre"),
						resultSet.getString("Apellido"),
						resultSet.getString("Telefono"),
						resultSet.getString("email"),
						resultSet.getDate("fechaNacimiento"),
						resultSet.getInt("idDomicilio"),
						resultSet.getInt("idEtiqueta")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personas;
	}
	
	public boolean edit (String nuevoNombre, String nuevoApellido, String nuevoTelefono, String nuevoEmail, String nuevaFechaNacimiento, int nuevoIdDomicilio, int nuevoIdEtiqueta, int idPersona_a_editar) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(edit);
			statement.setString(1, nuevoNombre);
			statement.setString(2, nuevoApellido);
			statement.setString(3, nuevoTelefono);
			statement.setString(4, nuevoEmail);
			statement.setString(5, nuevaFechaNacimiento);
			statement.setInt(6,nuevoIdDomicilio);
			statement.setInt(7,nuevoIdEtiqueta);
			statement.setInt(8, idPersona_a_editar);
			if (statement.executeUpdate() > 0) // Si se ejecutó devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
