package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.model.Pagamento;

public class PagamentoRepository {
    private EntityManager em;

    public PagamentoRepository(EntityManager em) {
        this.em = em;
    }

    public void salvar(Pagamento pagamento) {
        em.getTransaction().begin();
        em.persist(pagamento);
        em.getTransaction().commit();
    }

    public Pagamento buscar(Long id) {
        return em.find(Pagamento.class, id);
    }

    // Outros métodos de CRUD, se necessário
}