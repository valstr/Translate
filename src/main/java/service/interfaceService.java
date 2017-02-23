package service;

import java.io.Serializable;
import java.util.List;

public interface interfaceService {
	
	public void save(Serializable obj);
	public void delete(int id);
	public void modify(Serializable obj);
	public List<Serializable> list();
	public List<Serializable> list(int page,int size);
	public long count();
}
