package com.example.demo.rest;

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

    @PostMapping
    private ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
        try {
            Usuario usuarioGuardado = usuarioService.save(usuario);
            return ResponseEntity.created(new URI("/Usuario/"+usuarioGuardado.getIdUsuario())).body(usuarioGuardado);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
