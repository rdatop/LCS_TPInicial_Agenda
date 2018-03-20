package persistencia.dao.interfaz;

import java.util.List;

import dto.EtiquetaDTO;

public interface EtiquetaDAO {

	public boolean insert(EtiquetaDTO etiqueta);

	public boolean delete(int idetiqueta_a_eliminar);
	
	public List<EtiquetaDTO> readAll();
	
	public boolean edit(String nueva_etiqueta, EtiquetaDTO etiqueta_a_editar);

	public int obtenerIdEtiqueta(String etiqueta);
	
	public String readEtiqueta(int idEtiqueta);
}
