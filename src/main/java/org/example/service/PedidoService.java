package org.example.service;

import org.example.model.Pedido;
import org.example.repository.PedidoRepository;

public class PedidoService {
    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void cadastrarPedido(Pedido pedido) {
        pedidoRepository.salvar(pedido);
    }

    public Pedido obterPedido(Long id) {
        return pedidoRepository.buscar(id);
    }

    // Outros métodos de negócio
}