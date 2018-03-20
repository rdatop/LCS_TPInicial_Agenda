package persistencia.dao.interfaz;

import java.util.List;

import dto.LocalidadDTO;

public interface LocalidadDAO {

	public boolean insert(LocalidadDTO localdiad);

	public boolean delete(int idlocalidad_a_eliminar);
	
	public List<LocalidadDTO> readAll();
	
	public boolean edit(String nueva_localidad, LocalidadDTO localidad_a_editar);
	
	public int obtenerIdLocaldiad(String localidad);

	public String obtenerLocalidad(int idLocalidad);
}
