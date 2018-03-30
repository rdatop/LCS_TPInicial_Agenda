package persistencia.dao.interfaz;

import java.util.List;

import dto.DomicilioDTO;

public interface DomicilioDAO {

	public boolean insert(DomicilioDTO persona);

	public boolean delete(int iddomicilio_a_eliminar);

	public List<DomicilioDTO> readAll();

	public int readIdDomicilio(DomicilioDTO domicilio);

	public String readDomicilio(int idDomicilio);

	public DomicilioDTO readDomicilioDTO(int idDomicilio);

	public boolean edit(String nuevaCalle, String nuevaAltura, String nuevoPiso, String nuevoDepartamento, int nuevoIdLocalidad, int idDomicilio_a_modificar);
}
