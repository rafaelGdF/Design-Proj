package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.model.Pedido;

public class PedidoRepository {
    private EntityManager em;

    public PedidoRepository(EntityManager em) {
        this.em = em;
    }

    public void salvar(Pedido pedido) {
        em.getTransaction().begin();
        em.persist(pedido);
        em.getTransaction().commit();
    }

    public Pedido buscar(Long id) {
        return em.find(Pedido.class, id);
    }

    // Outros métodos de CRUD, se necessário
}