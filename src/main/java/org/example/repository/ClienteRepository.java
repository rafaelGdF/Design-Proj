package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.model.Cliente;

public class ClienteRepository {
    private EntityManager em;

    public ClienteRepository(EntityManager em) {
        this.em = em;
    }

    public void salvar(Cliente cliente) {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public Cliente buscar(Long id) {
        return em.find(Cliente.class, id);
    }

    // Outros métodos de CRUD
}