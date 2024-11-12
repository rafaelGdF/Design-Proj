package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.model.ItemPedido;

public class ItemPedidoRepository {
    private EntityManager em;

    public ItemPedidoRepository(EntityManager em) {
        this.em = em;
    }

    public void salvar(ItemPedido itemPedido) {
        em.getTransaction().begin();
        em.persist(itemPedido);
        em.getTransaction().commit();
    }

    public ItemPedido buscar(Long id) {
        return em.find(ItemPedido.class, id);
    }

    // Outros métodos de CRUD, se necessário
}