package ejemplo03.persistencia.dao.impl;

import ejemplo03.persistencia.dao.EstacionesDAO;
import ejemplo03.dominio.Estaciones;
import com.fpmislata.persistencia.dao.impl.GenericDAOImplHibernate;
import ejemplo03.dominio.Contaminantes;
import ejemplo03.persistencia.dao.ContaminantesDAO;

public class ContaminantesDAOImplHibernate extends GenericDAOImplHibernate<Contaminantes,String> implements  ContaminantesDAO {

}
