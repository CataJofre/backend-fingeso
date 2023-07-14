package com.example.demo.rest;

import com.example.demo.models.Permiso;
import com.example.demo.services.PermisoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Permiso/")
public class PermisosRest {
    private PermisoService permisoService;

    @GetMapping
    private ResponseEntity<List<Permiso>>getAllPermisos(){
        return ResponseEntity.ok(permisoService.findAll());
    }
}
