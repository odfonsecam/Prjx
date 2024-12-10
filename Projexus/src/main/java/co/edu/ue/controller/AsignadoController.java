package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Asignado;
import co.edu.ue.entity.Lider;
import co.edu.ue.service.AsignadoService;
import co.edu.ue.service.IAsignadoService;
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
@Tag(name="Asignado", description = "Editar datos de los Asignados")
@RequestMapping("api")
@Validated
public class AsignadoController {

	@Autowired
	IAsignadoService service;
	
	@Operation(summary = "Consulta todos los Asignados")
	@GetMapping(value="Asignado-all")
	public ResponseEntity<List<Asignado>> getAllAsignado() {
		List<Asignado> list = service.listAllAsignado();
		return new ResponseEntity<List<Asignado>>(list, HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "Consulta los Asignados por id")
	@GetMapping(value="Asignado-id")
	public ResponseEntity<Asignado> getByIdAsignado(@Valid @RequestParam("id") int id) {
		return new ResponseEntity<Asignado>(service.searchByIdAsignado(id),HttpStatus.OK);
	}
	
	@Operation(summary = "Agrega nuevos Asignados")
	@PostMapping(value="Asignado")
	public ResponseEntity<Void> postAsignado(@Valid @RequestBody Asignado asignado) {
		if (service.postByAsignado(asignado)) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	
	@Operation(summary = "Edita los Asignado")
	@PutMapping(value="Asignado-id")
	public ResponseEntity<Asignado>  updateAsignado(@Valid @RequestBody Asignado asignado, @RequestParam("id") int id) {
		return new ResponseEntity<Asignado> (service.updateByAsignado(asignado, id),HttpStatus.CREATED);
	}
	
	@Operation(summary = "Elimina un Asignado por id")
	@DeleteMapping(value="Asignado-id")
	public ResponseEntity<String> deleteByIdAsignado(@Valid @RequestParam("id") int id) {
		service.deleteByIdAsignado(id);
		return new ResponseEntity<String> ("Asignado eliminado correctamente",HttpStatus.OK);
	}
	
}
