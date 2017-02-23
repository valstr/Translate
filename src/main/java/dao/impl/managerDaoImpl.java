package dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import model.manager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import dao.ImanagerDao;

@Repository("managerDao")
public class managerDaoImpl implements ImanagerDao {

	private static final String entity = "manager";
	
	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Serializable obj) {
		getSession().save(obj);
	}

	@Override
	public void delete(int id) {
		getSession().delete(id);
	}

	@Override
	public void modify(Serializable obj) {
		getSession().merge(obj);
	}

	@Override
	public List<Serializable> list() {
		return getSession().createQuery("from "+entity).list();
	}

	@Override
	public List<Serializable> list(int page, int size) {
		Session session = this.getSession();
		Query query = session.createQuery("from "+entity);
		query.setFirstResult((page-1)*size);
		query.setMaxResults(size);
		return query.list();
	}

	@Override
	public long count() {
		Object value = getSession().createQuery("select count(id) from "+entity).uniqueResult();
		return (Long)value;
	}

	@Override
	public manager getObjectById(int id) {
		return (manager) getSession().load(manager.class, id);
	}

	@Override
	public boolean login(manager obj) {
		Session session = getSession();
		Query query = session.createQuery("from manager where username=? and password=?");
		query.setString(0, obj.getUsername()).setString(1, obj.getPassword());
		List list = query.list();
		if(list.size() == 0){
			return false;
		}else{
			return true;
		}
	}

}
