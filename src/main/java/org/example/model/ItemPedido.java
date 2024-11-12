package org.example.model;

import jakarta.persistence.*;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;

    @ManyToOne
    private Produto produto;

    // Construtores, getters e setters
    public ItemPedido() {}

    public ItemPedido(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Long getId() { return id; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
}