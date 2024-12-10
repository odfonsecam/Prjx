package co.edu.ue.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Asignado;


public interface IAsignadoJpa extends JpaRepository<Asignado, Integer> {
}
