package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Rol;
import co.edu.ue.service.IRolService;
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

@RestController
@Tag(name="Rol", description = "Editar datos de las Roles")
@RequestMapping("api")
@Validated
public class RolController {

	@Autowired
	IRolService service;
	
	@Operation(summary = "Consulta todos los Roles")
	@GetMapping(value="Rol-all")
	public ResponseEntity<List<Rol>> getAllRol() {
		List<Rol> list = service.listAllRol();
		return new ResponseEntity<List<Rol>>(list, HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "Consulta los Rol por id")
	@GetMapping(value="Rol-id")
	public ResponseEntity<Rol> getByIdRol(@Valid @RequestParam("id") int id) {
		return new ResponseEntity<Rol>(service.searchByIdRol(id),HttpStatus.OK);
	}
	
	@Operation(summary = "Agrega nuevos Rol")
	@PostMapping(value="Rol")
	public ResponseEntity<Void> postRol(@Valid @RequestBody Rol rol) {
		if (service.postByRol(rol)) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	
	@Operation(summary = "Edita los Rol")
	@PutMapping(value="Rol-id")
	public ResponseEntity<Rol>  updateRol(@Valid @RequestBody Rol rol, @RequestParam("id") int id) {
		return new ResponseEntity<Rol> (service.updateByRol(rol, id),HttpStatus.CREATED);
	}
	
	@Operation(summary = "Elimina un Rol por id")
	@DeleteMapping(value="Rol-id")
	public ResponseEntity<String> deleteByIdRol(@Valid @RequestParam("id") int id) {
		service.deleteByIdRol(id);
		return new ResponseEntity<String> ("Rol eliminado correctamente",HttpStatus.OK);
	}
}
