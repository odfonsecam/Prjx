package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.ITareasDao;
import co.edu.ue.entity.Tareas;


@Service
public class TareasService implements ITareasService {
	
	@Autowired
	ITareasDao dao;
	
	@Override
	public List<Tareas> listAllTareas() {
		return dao.listTareas();
	}

	
	@Override
	public Tareas searchByIdTareas(int id) {
		return dao.searchById(id);
	}

	@Override
	public boolean postByTareas(Tareas tareas) {
		return dao.postTareas(tareas);
	}

	@Override
	public Tareas updateByTareas(Tareas tareas, int id) {
		return dao.updateTareas(tareas, id);
	}

	@Override
	public void deleteByIdTareas(int id) {
		dao.deleteTareas(id);
	}
	
}
