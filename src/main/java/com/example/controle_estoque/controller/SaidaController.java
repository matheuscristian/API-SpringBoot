package com.example.controle_estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controle_estoque.model.ProdutosModel;
import com.example.controle_estoque.model.SaidaModel;
import com.example.controle_estoque.repository.ProdutosRepository;
import com.example.controle_estoque.repository.SaidaRepository;

@RestController
@RequestMapping("/api/saida")
public class SaidaController extends AbstractController<SaidaModel, Long> {
    @Autowired
    private ProdutosRepository produtosRepository;

    public SaidaController(@Autowired SaidaRepository saidaRepository) {
        super(saidaRepository);
    }

    @Override
    public SaidaModel create(SaidaModel entity) {
        SaidaModel res = super.create(entity);

        ProdutosModel produto = produtosRepository.findById(res.getProduto().getId()).get();
        Integer novaQuantidade = produto.getQuantidade() - entity.getQuantidade_saida();

        if (novaQuantidade < 0) {
            throw new RuntimeException("Can't subtract quantity from product: there isn't that many available");
        }

        produto.setQuantidade(novaQuantidade);

        produtosRepository.save(produto);

        return res;
    }

}
