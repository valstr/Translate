package service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.impl.managerDaoImpl;

import model.manager;
import service.ImanagerService;

@Service
public class managerServiceImpl implements ImanagerService{
	
	@Resource
	private managerDaoImpl dao;
	
	@Override
	public void save(Serializable obj) {
		dao.save(obj);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public void modify(Serializable obj) {
		dao.modify(obj);
	}

	@Override
	public List<Serializable> list() {
		return dao.list();
	}

	@Override
	public List<Serializable> list(int page, int size) {
		return dao.list(page,size);
	}

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public manager getObjectById(int id) {
		return dao.getObjectById(id);
	}

	@Override
	public boolean login(manager obj) {
		System.out.println(obj.getUsername());
		return dao.login(obj);
	}

}
