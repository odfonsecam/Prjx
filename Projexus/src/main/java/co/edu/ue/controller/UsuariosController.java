package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Usuarios;
import co.edu.ue.service.IUsuariosService;
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
@Tag(name="Usuarios", description = "Editar datos de los usuarios")
@RequestMapping("api")
@Validated
public class UsuariosController {

	@Autowired
	IUsuariosService service;
	
	@Operation(summary = "Consulta todos los Usuarios")
	@GetMapping(value="Usuarios-all")
	public ResponseEntity<List<Usuarios>> getAllUsuarios() {
		List<Usuarios> list = service.listAllUsuarios();
		return new ResponseEntity<List<Usuarios>>(list, HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "Consulta los Usuarios por id")
	@GetMapping(value="Usuarios-id")
	public ResponseEntity<Usuarios> getByIdUsuarios(@Valid @RequestParam("id") int id) {
		return new ResponseEntity<Usuarios>(service.searchByIdUsuarios(id),HttpStatus.OK);
	}
	
	@Operation(summary = "Agrega nuevos Usuarios")
	@PostMapping(value="Usuarios")
	public ResponseEntity<Void> postUsuarios(@Valid @RequestBody Usuarios usuarios) {
		if (service.postByUsuarios(usuarios)) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	
	@Operation(summary = "Edita los Usuarios")
	@PutMapping(value="Usuarios-id")
	public ResponseEntity<Usuarios>  updateUsuarios(@Valid @RequestBody Usuarios usuarios, @RequestParam("id") int id) {
		return new ResponseEntity<Usuarios> (service.updateByUsuarios(usuarios, id),HttpStatus.CREATED);
	}
	
	@Operation(summary = "Elimina un Usuarios por id")
	@DeleteMapping(value="Usuarios-id")
	public ResponseEntity<String> deleteByIdUsuarios(@Valid @RequestParam("id") int id) {
		service.deleteByIdUsuarios(id);
		return new ResponseEntity<String> ("Usuario eliminado correctamente",HttpStatus.OK);
	}
}
