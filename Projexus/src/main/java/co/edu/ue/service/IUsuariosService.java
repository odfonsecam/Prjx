package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Usuarios;

public interface IUsuariosService {
	List<Usuarios> listAllUsuarios();
	Usuarios searchByIdUsuarios(int id);
	boolean postByUsuarios(Usuarios usuarios);
	Usuarios updateByUsuarios(Usuarios usuarios, int id);
	void deleteByIdUsuarios(int id);
	Usuarios login(String email, String contrasena);

}
