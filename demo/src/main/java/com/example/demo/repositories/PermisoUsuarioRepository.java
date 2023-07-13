package com.example.demo.repositories;

import com.example.demo.models.PermisoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisoUsuarioRepository extends JpaRepository<PermisoUsuario, Long> {
}
