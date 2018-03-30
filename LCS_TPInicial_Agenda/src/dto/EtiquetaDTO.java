package dto;

public class EtiquetaDTO {
	private int idEtiqueta;
	private String etiqueta;

	public EtiquetaDTO(int idEtiqueta, String etiqueta) {
		this.idEtiqueta = idEtiqueta;
		this.etiqueta = etiqueta;
	}

	public int getIdEtiqueta() {
		return this.idEtiqueta;
	}

	public void setIdEtiqueta(int idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}


}
