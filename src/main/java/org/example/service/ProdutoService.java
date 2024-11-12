package org.example.service;

import org.example.model.Produto;
import org.example.repository.ProdutoRepository;

public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void cadastrarProduto(Produto produto) {
        produtoRepository.salvar(produto);
    }

    public Produto obterProduto(Long id) {
        return produtoRepository.buscar(id);
    }

    // Outros métodos de negócio
}