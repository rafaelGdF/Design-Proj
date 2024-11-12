package org.example.service;

import org.example.model.ItemPedido;
import org.example.repository.ItemPedidoRepository;

public class ItemPedidoService {
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public void cadastrarItemPedido(ItemPedido itemPedido) {
        itemPedidoRepository.salvar(itemPedido);
    }

    public ItemPedido obterItemPedido(Long id) {
        return itemPedidoRepository.buscar(id);
    }

    // Outros métodos de negócio
}