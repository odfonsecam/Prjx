package co.edu.ue.dao;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Tareas;
import co.edu.ue.jpa.ITareasJpa;

@Repository
public class TareasDao implements ITareasDao{
	
	@Autowired
	ITareasJpa jpa;

	@Override
	public List<Tareas> listTareas() {
		return jpa.findAll();
	}

	@Override
	public Tareas searchById(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public boolean postTareas(Tareas tareas) {
		if(!jpa.save(tareas).equals(null)) return true;
		return false;
	}

	@Override
	public Tareas updateTareas(Tareas tareas, int id) {
		Tareas newTareas = jpa.findById(id).get();
		
		if (Objects.nonNull(tareas.getTiempo()) && Objects.nonNull(tareas.getTiempo())) {
		    newTareas.setTiempo(tareas.getTiempo());
		}
		
		if (Objects.nonNull(tareas.getProgreso()) && tareas.getProgreso() != 0.0f) {
		    newTareas.setProgreso(tareas.getProgreso());
		}
		
		if (Objects.nonNull(tareas.getDescripcion())) {
			newTareas.setDescripcion(tareas.getDescripcion());
		}
		
		if (Objects.nonNull(tareas.getId_usuario())) {
			newTareas.setId_usuario(tareas.getId_usuario());
		}
		
		if (Objects.nonNull(tareas.getId_proyecto())) {
			newTareas.setId_proyecto(tareas.getId_proyecto());
		}
		
		
		return jpa.save(newTareas);
	}

	@Override
	public void deleteTareas(int id) {
		jpa.deleteById(id);
	}
	
}
