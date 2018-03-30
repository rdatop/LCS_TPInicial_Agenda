/**
 * 
 */
package persistencia.dao.mysql;

import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.DomicilioDAO;
import persistencia.dao.interfaz.EtiquetaDAO;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;

public class DAOSQLFactory implements DAOAbstractFactory 
{
	/* (non-Javadoc)
	 * @see persistencia.dao.interfaz.DAOAbstractFactory#createPersonaDAO()
	 */
	@Override
	public PersonaDAO createPersonaDAO() 
	{
				return new PersonaDAOSQL();
	}

	@Override
	public EtiquetaDAO createEtiquetaDAO() {
		// TODO Auto-generated method stub
		return new EtiquetaDAOSQL();
	}

	@Override
	public LocalidadDAO createLocalidadDAO() {
		// TODO Auto-generated method stub
		return new LocalidadDAOSQL();
	}
	
	@Override
	public DomicilioDAO createDomicilioDAO() {
		// TODO Auto-generated method stub
		return new DomicilioDAOSQL();
	}

}
