package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Lider;
import co.edu.ue.service.ILiderService;
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
@Tag(name="Lider", description = "Editar datos de los Lideres")
@RequestMapping("api")
@Validated
public class LiderController {

	@Autowired
	ILiderService service;
	
	@Operation(summary = "Consulta todos los lideres")
	@GetMapping(value="Lider-all")
	public ResponseEntity<List<Lider>> getAllLider() {
		List<Lider> list = service.listAllLider();
		return new ResponseEntity<List<Lider>>(list, HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "Consulta los Lideres por id")
	@GetMapping(value="Lider-id")
	public ResponseEntity<Lider> getByIdLider(@Valid @RequestParam("id") int id) {
		return new ResponseEntity<Lider>(service.searchByIdLider(id),HttpStatus.OK);
	}
	
	@Operation(summary = "Agrega nuevos Lideres")
	@PostMapping(value="Lider")
	public ResponseEntity<Void> postLider(@Valid @RequestBody Lider lider) {
		if (service.postByLider(lider)) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	
	@Operation(summary = "Edita los Lideres")
	@PutMapping(value="Lider-id")
	public ResponseEntity<Lider>  updateLider(@Valid @RequestBody Lider lider, @RequestParam("id") int id) {
		return new ResponseEntity<Lider> (service.updateByLider(lider, id),HttpStatus.CREATED);
	}
	
	@Operation(summary = "Elimina un Lider por id")
	@DeleteMapping(value="Lider-id")
	public ResponseEntity<String> deleteByIdLider(@Valid @RequestParam("id") int id) {
		service.deleteByIdLider(id);
		return new ResponseEntity<String> ("Lider eliminado correctamente",HttpStatus.OK);
	}
}
