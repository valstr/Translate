package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface interfaceDao {

	public Session getSession();
	public void setSessionFactory(SessionFactory sessionFactory);
	public void save(Serializable obj);//保存
	public void delete(int id);
	public void modify(Serializable obj);//修改
	public List<Serializable> list();
	public List<Serializable> list(int page,int size);//分页查询
	public long count();//总条数
}
