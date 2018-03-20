/**
 * 
 */
package persistencia.dao.mysql;

import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.DomicilioDAO;
import persistencia.dao.interfaz.EtiquetaDAO;
import persistencia.dao.interfaz.LocalidadDAO;

public class DAOSQLFactory implements DAOAbstractFactory{

	/* (non-Javadoc)
	 * @see persistencia.dao.interfaz.DAOAbstractFactory#createPersonaDAO()
	 */
	@Override
	public PersonaDAO createPersonaDAO(){
		return new PersonaDAOSQL();
	}
	
	@Override
	public EtiquetaDAO createEtiquetaDAO(){
		return new EtiquetaDAOSQL(); 
	}
	
	@Override
	public LocalidadDAO createLocalidadDAO() {
		return new LocalidadDAOSQL();
	}
	
	@Override
	public DomicilioDAO createDomicilioDAO() {
		return new DomicilioDAOSQL();
	}
}
