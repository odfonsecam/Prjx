package co.edu.ue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.edu.ue.entity.Usuarios;
import co.edu.ue.service.UsuariosService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/iniciarSesion")
    public Usuarios iniciarSesion(@RequestBody Usuarios usuario) {
        Usuarios validUser = usuariosService.login(usuario.getEmail(), usuario.getcontrasena());
        if (validUser != null) {
            return validUser;  
        } else {
            return null;  
        }
    }
}
