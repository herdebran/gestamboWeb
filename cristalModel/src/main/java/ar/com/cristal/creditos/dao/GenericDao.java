package ar.com.cristal.creditos.dao;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


@Repository(value="genericDao")
@SuppressWarnings("unchecked")
public class GenericDao extends HibernateDaoSupport{

	@Autowired
	public GenericDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	
	
	public void delete(Object entidad) {
		this.getHibernateTemplate().delete(entidad);
	}

	public void save(Object entidad) {
		this.getHibernateTemplate().save(entidad);
		
	}
	public void update(Object entidad) {
		this.getHibernateTemplate().update(entidad);
	}

	public <T> T get(Class<T> clazz, Long id) {
		return (T)this.getHibernateTemplate().get(clazz, id);
	}
	
	public <T> T get(Class<T> clazz, String id) {
		return (T)this.getHibernateTemplate().get(clazz, id);
	}

	public <T> List<T> getAll(Class<T> clazz) {
		return this.getHibernateTemplate().loadAll(clazz);
	}
	
	public <T> List<T> getAll(Class<T> clazz, String id) {
		return this.getHibernateTemplate().loadAll(clazz);
	}

	public void saveOrUpdate(Object entidad) {
		this.getHibernateTemplate().saveOrUpdate(entidad);
	}
	
	public <T> List<T> findAll(Class<T> clazz) {
		return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(clazz));
	}
	
	public <T> List<T> findByExample(Object entidad) {
		return getHibernateTemplate().findByExample(entidad);
	}
	
	public <T> T merge(T entidad){
		return (T) getHibernateTemplate().merge(entidad);
	}
	
	public <T> List<T> find(String hql) {
		final List<T> entities = getHibernateTemplate().find(hql);  
        return entities; 
	}


	public <T> List<T> find(Class<T> entityClass) {
		List<T> resul = getHibernateTemplate().loadAll(entityClass);
		return resul;
	}

	
	public <T> List<T> findByCriteria(DetachedCriteria entidad) {
		return getHibernateTemplate().findByCriteria(entidad);
	}

	public <T> List<T> find(String hql, Object[] params) {
		final List<T> entities = getHibernateTemplate().find(hql,params);
		return entities; 
	}
	
	public Criteria crearCriteria(Class clase){
		Criteria c = this.getSessionFactory().getCurrentSession().createCriteria(clase);
		return c;
	}
	
	public Integer executeQueryUpdate(String hql, Map<String,Object> params) {
		Query query = getSessionFactory().getCurrentSession().createSQLQuery(hql);
		for (String nameParam : params.keySet()) {
			query.setParameter(nameParam,params.get(nameParam));
		}
	    int rowCount = query.executeUpdate();
	    return rowCount;
	}
	

}
