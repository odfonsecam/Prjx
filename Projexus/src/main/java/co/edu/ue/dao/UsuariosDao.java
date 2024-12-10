package co.edu.ue.dao;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Usuarios;
import co.edu.ue.jpa.IUsuariosJpa;

@Repository
public class UsuariosDao implements IUsuariosDao{
	
	@Autowired
	IUsuariosJpa jpa;

	@Override
	public List<Usuarios> listUsuarios() {
		return jpa.findAll();
	}

	@Override
	public Usuarios searchById(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public boolean postUsuarios(Usuarios usuarios) {
		if(!jpa.save(usuarios).equals(null)) return true;
		return false;
	}

	@Override
	public Usuarios updateUsuarios(Usuarios usuarios, int id) {
		Usuarios newUsuarios = jpa.findById(id).get();
		
		if (Objects.nonNull(usuarios.getcontrasena()) && !"".equalsIgnoreCase(usuarios.getcontrasena())) {
			newUsuarios.setcontrasena(usuarios.getcontrasena());
		}
		
		if (Objects.nonNull(usuarios.getEmail()) && !"".equalsIgnoreCase(usuarios.getEmail())) {
			newUsuarios.setEmail(usuarios.getEmail());
		}
		
		if (Objects.nonNull(usuarios.getNombreusuarios()) && !"".equalsIgnoreCase(usuarios.getNombreusuarios())) {
			newUsuarios.setNombreusuarios(usuarios.getNombreusuarios());
		}
		
		
		return jpa.save(newUsuarios);
	}

	@Override
	public void deleteUsuarios(int id) {
		jpa.deleteById(id);
	}

	@Override
    public Usuarios searchByEmailAndPassword(String email, String contrasena) {
        return jpa.findByEmailAndContrasena(email, contrasena); 
    }
	
}
