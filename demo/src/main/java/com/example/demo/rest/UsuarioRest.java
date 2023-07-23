package com.example.demo.rest;

import com.example.demo.models.Ticket;
import com.example.demo.models.Usuario;
import com.example.demo.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Usuario/")
public class UsuarioRest {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    private ResponseEntity<List<Usuario>> getAllUsuarios(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    //verificar que no se registre un usuario repetido
    @PostMapping
    private ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
        try {
            Usuario usuarioGuardado = usuarioService.save(usuario);
            return ResponseEntity.created(new URI("/Usuario/"+usuarioGuardado.getIdUsuario())).body(usuarioGuardado);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("correo") String correo, @RequestParam("contraseña") String contraseña) {

        return new ResponseEntity<>(usuarioService.login(correo, contraseña), HttpStatus.OK);

    }

    @PostMapping("/saveUser")
    private ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario){
        try {
            Usuario usuarioGuardado = usuarioService.save(usuario);
            return ResponseEntity.created(new URI("/Ticket/"+usuarioGuardado.getIdUsuario())).body(usuarioGuardado);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}