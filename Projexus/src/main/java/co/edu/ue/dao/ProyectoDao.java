package co.edu.ue.dao;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Proyecto;
import co.edu.ue.jpa.IProyectoJpa;

@Repository
public class ProyectoDao implements IProyectoDao{
	
	@Autowired
	IProyectoJpa jpa;

	@Override
	public List<Proyecto> listProyecto() {
		return jpa.findAll();
	}

	@Override
	public Proyecto searchById(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public boolean postProyecto(Proyecto proyecto) {
		if(!jpa.save(proyecto).equals(null)) return true;
		return false;
	}

	@Override
	public Proyecto updateProyecto(Proyecto proyecto, int id) {
		Proyecto newProyecto = jpa.findById(id).get();
		
		if (Objects.nonNull(proyecto.getEstado()) && !"".equalsIgnoreCase(proyecto.getEstado())) {
			newProyecto.setEstado(proyecto.getEstado());
		}
		
		if (Objects.nonNull(proyecto.getTiempoEstimado())){
			newProyecto.setTiempoEstimado(proyecto.getTiempoEstimado());
		}
		
		if (Objects.nonNull(proyecto.getDescripcion()) && !"".equalsIgnoreCase(proyecto.getDescripcion())) {
			newProyecto.setDescripcion(proyecto.getDescripcion());
		}
		
		
		if (Objects.nonNull(proyecto.getLider())) {
			newProyecto.setLider(proyecto.getLider());
		}
		
		return jpa.save(newProyecto);
	}

	@Override
	public void deleteProyecto(int id) {
		jpa.deleteById(id);
	}



}
