package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Tareas;

public interface ITareasDao {
	
	List<Tareas> listTareas();
	Tareas searchById(int id);
	boolean postTareas(Tareas tareas);
	Tareas updateTareas(Tareas tareas, int id);
	void deleteTareas(int id);


}
