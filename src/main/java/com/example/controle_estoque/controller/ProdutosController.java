package com.example.controle_estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controle_estoque.model.ProdutosModel;
import com.example.controle_estoque.repository.ProdutosRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController extends AbstractController<ProdutosModel, Long> {
    public ProdutosController(@Autowired ProdutosRepository produtosRepository) {
        super(produtosRepository);
    }
}
