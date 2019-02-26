package ejemplo03.persistencia.dao.impl;

import ejemplo03.persistencia.dao.EstacionesDAO;
import ejemplo03.dominio.Estaciones;
import com.fpmislata.persistencia.dao.impl.GenericDAOImplHibernate;
import ejemplo03.dominio.Estaminantes;
import ejemplo03.persistencia.dao.EstaminantesDAO;

public class EstaminantesDAOImplHibernate extends GenericDAOImplHibernate<Estaminantes,Integer> implements  EstaminantesDAO {

}
