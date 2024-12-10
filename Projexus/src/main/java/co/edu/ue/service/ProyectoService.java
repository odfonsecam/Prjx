package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IProyectoDao;
import co.edu.ue.entity.Proyecto;

@Service
public class ProyectoService implements IProyectoService {
	
	@Autowired
	IProyectoDao dao;
	
	@Override
	public List<Proyecto> listAllProyecto() {
		return dao.listProyecto();
	}

	
	@Override
	public Proyecto searchByIdProyecto(int id) {
		return dao.searchById(id);
	}

	@Override
	public boolean postByProyecto(Proyecto proyecto) {
		return dao.postProyecto(proyecto);
	}

	@Override
	public Proyecto updateByProyecto(Proyecto proyecto, int id) {
		return dao.updateProyecto(proyecto, id);
	}

	@Override
	public void deleteByIdProyecto(int id) {
		dao.deleteProyecto(id);
	}

}
