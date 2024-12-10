package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Rol;

public interface IRolService {
	
	List<Rol> listAllRol();
	Rol searchByIdRol(int id);
	boolean postByRol(Rol rol);
	Rol updateByRol(Rol rol, int id);
	void deleteByIdRol(int id);

}
