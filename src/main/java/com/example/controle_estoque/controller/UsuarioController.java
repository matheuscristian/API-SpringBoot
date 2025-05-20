package com.example.controle_estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controle_estoque.model.UsuarioModel;
import com.example.controle_estoque.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends AbstractController<UsuarioModel, Long> {
    public UsuarioController(@Autowired UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
    }
}
