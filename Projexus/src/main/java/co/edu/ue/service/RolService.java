package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IRolDao;
import co.edu.ue.dao.ITareasDao;
import co.edu.ue.entity.Rol;
import co.edu.ue.entity.Tareas;


@Service
public class RolService implements IRolService {
	
	@Autowired
	IRolDao dao;
	
	@Override
	public List<Rol> listAllRol() {
		return dao.listRol();
	}

	
	@Override
	public Rol searchByIdRol(int id) {
		return dao.searchById(id);
	}

	@Override
	public boolean postByRol(Rol rol) {
		return dao.postRol(rol);
	}

	@Override
	public Rol updateByRol(Rol rol, int id) {
		return dao.updateRol(rol, id);
	}

	@Override
	public void deleteByIdRol(int id) {
		dao.deleteRol(id);
	}

}
