package dao;

import model.manager;

public interface ImanagerDao extends interfaceDao {
	public manager getObjectById(int id);
	public boolean login(manager obj);
}
