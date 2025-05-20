package com.example.controle_estoque.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractController<T, ID> {

    protected final JpaRepository<T, ID> repository;

    public AbstractController(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<T> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable ID id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ID id) {
        repository.deleteById(id);
    }
}
