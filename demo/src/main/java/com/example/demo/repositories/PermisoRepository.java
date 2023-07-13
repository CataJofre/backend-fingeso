package com.example.demo.repositories;

import com.example.demo.models.Permiso;
import com.example.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisoRepository extends JpaRepository<Permiso, Long> {
}
