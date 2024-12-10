package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Asignado;

public interface IAsignadoService {
	List<Asignado> listAllAsignado();
	Asignado searchByIdAsignado(int id);
	boolean postByAsignado(Asignado asignado);
	Asignado updateByAsignado(Asignado asignado, int id);
	void deleteByIdAsignado(int id);

}
