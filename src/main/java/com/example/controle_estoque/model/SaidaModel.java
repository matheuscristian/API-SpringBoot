package com.example.controle_estoque.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "saida")
@Getter
@NoArgsConstructor
public class SaidaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDateTime data;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_usuario"))
    private UsuarioModel usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_produto", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_produto"))
    private ProdutosModel produto;

    @Column(nullable = false)
    private Integer quantidade_saida;
}
