package persistencia.dao.interfaz;

import java.util.List;

import dto.PersonaDTO;

public interface PersonaDAO 
{
	
	public boolean insert(PersonaDTO persona);

	public boolean delete(int idpersona_a_eliminar);
	
	public List<PersonaDTO> readAll();
	
	public boolean edit (String nuevoNombre, String nuevoApellido, String nuevoTelefono, String nuevoEmail, String nuevaFechaNacimiento, int nuevoIdDomicilio, int nuevoIdEtiqueta, int idPersona_a_editar);
}
