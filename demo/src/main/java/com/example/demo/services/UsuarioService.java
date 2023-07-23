package com.example.demo.services;

import com.example.demo.models.Permiso;
import com.example.demo.models.PermisoUsuario;
import com.example.demo.models.Usuario;
import com.example.demo.repositories.PermisoRepository;
import com.example.demo.repositories.PermisoUsuarioRepository;
import com.example.demo.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class UsuarioService implements UsuarioRepository{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PermisoUsuarioRepository permisoUsuarioRepository;
    @Autowired
    private PermisoRepository permisoRepository;

    public Usuario login(String correo, String contraseña) {
        try {
            Optional<Usuario> optionalUsuario = usuarioRepository.findByCorreo(correo);
            if (optionalUsuario.isPresent()) {
                Usuario usuario = optionalUsuario.get();
                if (usuario.getContraseña().equals(contraseña)) {
                    return usuario; // Las credenciales son válidas
                }else {
                    throw new RuntimeException("Credenciales invalidas");
                }
            }else {
                throw new RuntimeException("Credenciales invalidas");
            }
        }catch (Exception e){
            throw new RuntimeException("Credenciales invalidas");
        }
    }

    @Transactional
    public Usuario asignarRolUsuario(Long idUsuario, Long idPermiso) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            Permiso permiso = permisoRepository.findById(idPermiso).orElse(null);
            if (permiso != null) {
                PermisoUsuario permisoUsuario = new PermisoUsuario();
                permisoUsuario.setUsuario(usuario);
                permisoUsuario.setPermiso(permiso);
                // Guarda el objeto PermisoUsuario en la base de datos
                permisoUsuarioRepository.save(permisoUsuario);
                return usuario;
            }
        }
        return null;
    }
    @Override
    public void flush() {

    }

    @Override
    public <S extends Usuario> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Usuario> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Usuario> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Usuario getOne(Long aLong) {
        return null;
    }

    @Override
    public Usuario getById(Long aLong) {
        return null;
    }

    @Override
    public Usuario getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Usuario> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Usuario> List<S> findAll(Example<S> example) {
        return (List<S>) usuarioRepository.findAll();
    }

    @Override
    public <S extends Usuario> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Usuario> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Usuario> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Usuario> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Usuario, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Usuario> S save(S entity) {
        return usuarioRepository.save(entity);
    }

    @Override
    public <S extends Usuario> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Usuario> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return usuarioRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        usuarioRepository.deleteById(aLong);
    }

    @Override
    public void delete(Usuario entity) {
        usuarioRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Usuario> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Usuario> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Usuario> findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }
}