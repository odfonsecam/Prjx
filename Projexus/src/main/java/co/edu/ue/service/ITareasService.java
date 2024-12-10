package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Tareas;

public interface ITareasService {
	List<Tareas> listAllTareas();
	Tareas searchByIdTareas(int id);
	boolean postByTareas(Tareas tareas);
	Tareas updateByTareas(Tareas tareas, int id);
	void deleteByIdTareas(int id);


}
