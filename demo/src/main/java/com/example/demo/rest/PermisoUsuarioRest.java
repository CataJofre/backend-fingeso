package com.example.demo.rest;

import com.example.demo.models.PermisoUsuario;
import com.example.demo.services.PermisoUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PermisoUsuario/")
public class PermisoUsuarioRest {
    private PermisoUsuarioService permisoUsuarioService;

    @GetMapping
    private ResponseEntity<List<PermisoUsuario>> getAllPermisoUsuario(){
        return ResponseEntity.ok(permisoUsuarioService.findAll());
    }
}