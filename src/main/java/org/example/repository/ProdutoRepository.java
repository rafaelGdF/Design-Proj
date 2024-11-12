package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.model.Produto;

public class ProdutoRepository {
    private EntityManager em;

    public ProdutoRepository(EntityManager em) {
        this.em = em;
    }

    public void salvar(Produto produto) {
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
    }

    public Produto buscar(Long id) {
        return em.find(Produto.class, id);
    }

    // Outros métodos de CRUD, se necessário
}