package ejemplo03.persistencia.dao.impl;

import ejemplo03.persistencia.dao.EstacionesDAO;
import ejemplo03.dominio.Estaciones;
import com.fpmislata.persistencia.dao.impl.GenericDAOImplHibernate;

public class EstacionesDAOImplHibernate extends GenericDAOImplHibernate<Estaciones,Integer> implements  EstacionesDAO {

}
