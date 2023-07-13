package com.example.demo.services;

import com.example.demo.models.PermisoUsuario;
import com.example.demo.repositories.PermisoUsuarioRepository;
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
public class PermisoUsuarioService implements PermisoUsuarioRepository {

    @Autowired
    private PermisoUsuarioRepository permisoUsuarioRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends PermisoUsuario> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends PermisoUsuario> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<PermisoUsuario> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PermisoUsuario getOne(Long aLong) {
        return null;
    }

    @Override
    public PermisoUsuario getById(Long aLong) {
        return null;
    }

    @Override
    public PermisoUsuario getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends PermisoUsuario> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PermisoUsuario> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PermisoUsuario> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PermisoUsuario> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PermisoUsuario> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PermisoUsuario> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends PermisoUsuario, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends PermisoUsuario> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PermisoUsuario> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PermisoUsuario> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<PermisoUsuario> findAll() {
        return null;
    }

    @Override
    public List<PermisoUsuario> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(PermisoUsuario entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends PermisoUsuario> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<PermisoUsuario> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PermisoUsuario> findAll(Pageable pageable) {
        return null;
    }
}