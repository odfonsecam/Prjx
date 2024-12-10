package co.edu.ue.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Asignado;
import co.edu.ue.entity.Tareas;
import co.edu.ue.service.ITareasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Tag(name="Tareas", description = "Editar datos de las tareas")
@RequestMapping("api")
@Validated
public class TareasController {

	@Autowired
	ITareasService service;
	
	@Operation(summary = "Consulta todos los Tareas")
	@GetMapping(value="Tareas-all")
	public ResponseEntity<List<Tareas>> getAllTareas() {
		List<Tareas> list = service.listAllTareas();
		return new ResponseEntity<List<Tareas>>(list, HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "Consulta los Tareas por id")
	@GetMapping(value="Tareas-id")
	public ResponseEntity<Tareas> getByIdTareas(@Valid @RequestParam("id") int id) {
		return new ResponseEntity<Tareas>(service.searchByIdTareas(id),HttpStatus.OK);
	}
	
	@Operation(summary = "Agrega nuevos Tareas")
	@PostMapping(value="Tareas")
	public ResponseEntity<Void> postTareas(@Valid @RequestBody Tareas tareas) {
		if (service.postByTareas(tareas)) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	
	@Operation(summary = "Edita los Tareas")
	@PutMapping(value="Tareas-id")
	public ResponseEntity<Tareas>  updateTareas(@Valid @RequestBody Tareas tareas, @RequestParam("id") int id) {
		return new ResponseEntity<Tareas> (service.updateByTareas(tareas, id),HttpStatus.CREATED);
	}
	
	@Operation(summary = "Elimina un Tareas por id")
	@DeleteMapping(value="Tareas-id")
	public ResponseEntity<Map<String, String>> deleteByIdTareas(@Valid @RequestParam("id") int id) {
	    try {
	        // Llamada al servicio para eliminar la tarea
	        service.deleteByIdTareas(id);
	        
	        // Respuesta en formato JSON
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Tarea eliminada correctamente");
	        
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	        // Respuesta de error en caso de que ocurra una excepción
	        Map<String, String> response = new HashMap<>();
	        response.put("error", "No se pudo eliminar la tarea");
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
