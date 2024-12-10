package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Proyecto;

public interface IProyectoJpa extends JpaRepository<Proyecto, Integer> {

}
