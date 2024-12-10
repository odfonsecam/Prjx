package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Proyecto;
import co.edu.ue.service.IProyectoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Tag(name="Proyectos", description = "Editar datos de los Proyectos")
@RequestMapping("api")
@Validated
public class ProyectoController {
	
	@Autowired
	IProyectoService service;
	
	@Operation(summary = "Consulta todos los proyectos")
	@GetMapping(value="Proyecto-all")
	public ResponseEntity<List<Proyecto>> getAllProyecto() {
		List<Proyecto> list = service.listAllProyecto();
		return new ResponseEntity<List<Proyecto>>(list, HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "Consult los proyectos por id")
	@GetMapping(value="Proyecto-id")
	public ResponseEntity<Proyecto> getByIdProyecto(@Valid @RequestParam("id") int id) {
		return new ResponseEntity<Proyecto>(service.searchByIdProyecto(id),HttpStatus.OK);
	}
	
	@Operation(summary = "Agrega nuevos proyectos")
	@PostMapping(value="Proyecto")
	public ResponseEntity<Void> postProyecto(@Valid @RequestBody Proyecto proyecto) {
		if (service.postByProyecto(proyecto)) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	
	@Operation(summary = "Edita los proyectos")
	@PutMapping(value="Proyecto-id")
	public ResponseEntity<Proyecto>  updateProyecto(@Valid @RequestBody Proyecto proyecto, @RequestParam("id") int id) {
		return new ResponseEntity<Proyecto> (service.updateByProyecto(proyecto, id),HttpStatus.CREATED);
	}
	
	@Operation(summary = "Elimina un proyecto por id")
	@DeleteMapping(value="Proyecto-id")
	public ResponseEntity<String> deleteByIdProyecto(@Valid @RequestParam("id") int id) {
		service.deleteByIdProyecto(id);
		return new ResponseEntity<String> ("Proyecto eliminado correctamente",HttpStatus.OK);
	}
	
}
