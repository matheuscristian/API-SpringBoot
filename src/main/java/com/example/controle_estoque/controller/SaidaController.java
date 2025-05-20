package com.example.controle_estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controle_estoque.model.SaidaModel;
import com.example.controle_estoque.repository.SaidaRepository;

@RestController
@RequestMapping("/api/saida")
public class SaidaController extends AbstractController<SaidaModel, Long> {
    public SaidaController(@Autowired SaidaRepository saidaRepository) {
        super(saidaRepository);
    }
}
