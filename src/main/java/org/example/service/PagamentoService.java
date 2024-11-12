package org.example.service;

import org.example.model.Pagamento;
import org.example.repository.PagamentoRepository;

public class PagamentoService {
    private PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public void cadastrarPagamento(Pagamento pagamento) {
        pagamentoRepository.salvar(pagamento);
    }

    public Pagamento obterPagamento(Long id) {
        return pagamentoRepository.buscar(id);
    }

    // Outros métodos de negócio
}