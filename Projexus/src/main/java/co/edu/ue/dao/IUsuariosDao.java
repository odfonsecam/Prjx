package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Usuarios;

public interface IUsuariosDao {
	
	List<Usuarios> listUsuarios();
	Usuarios searchById(int id);
	boolean postUsuarios(Usuarios usuarios);
	Usuarios updateUsuarios(Usuarios usuarios, int id);
	void deleteUsuarios(int id);
	Usuarios searchByEmailAndPassword(String email, String contrasena);

}
