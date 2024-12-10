package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IUsuariosDao;
import co.edu.ue.entity.Usuarios;

@Service
public class UsuariosService implements IUsuariosService {
	
	@Autowired
	IUsuariosDao dao;
	
	@Override
	public List<Usuarios> listAllUsuarios() {
		return dao.listUsuarios();
	}

	
	@Override
	public Usuarios searchByIdUsuarios(int id) {
		return dao.searchById(id);
	}

	@Override
	public boolean postByUsuarios(Usuarios usuarios) {
		return dao.postUsuarios(usuarios);
	}

	@Override
	public Usuarios updateByUsuarios(Usuarios usuarios, int id) {
		return dao.updateUsuarios(usuarios, id);
	}

	@Override
	public void deleteByIdUsuarios(int id) {
		dao.deleteUsuarios(id);
	}
	
	 @Override
	    public Usuarios login(String email, String contrasena) {
	        return dao.searchByEmailAndPassword(email, contrasena); 
	    }

}
