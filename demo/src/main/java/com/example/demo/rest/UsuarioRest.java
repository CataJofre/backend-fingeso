package com.example.demo.rest;

import com.example.demo.models.Usuario;
import com.example.demo.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
