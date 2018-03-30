package persistencia.dao.interfaz;


public interface DAOAbstractFactory 
{
	public PersonaDAO createPersonaDAO();
	public EtiquetaDAO createEtiquetaDAO();
	public LocalidadDAO createLocalidadDAO();
	public DomicilioDAO createDomicilioDAO();
}
