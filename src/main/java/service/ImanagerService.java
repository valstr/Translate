package service;

import model.manager;

public interface ImanagerService extends interfaceService{

	public manager getObjectById(int id);
	public boolean login(manager obj);
	
}
