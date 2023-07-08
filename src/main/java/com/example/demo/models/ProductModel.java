package com.example.demo.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="tabela_produto")
public class ProductModel implements Serializable {
    private static final long serializable = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idproduto;
    private String nome;
    private double valor;

    public UUID getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(UUID idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}


