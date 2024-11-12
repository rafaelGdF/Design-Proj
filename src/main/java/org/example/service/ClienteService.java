package org.example.service;

import org.example.model.Cliente;
import org.example.repository.ClienteRepository;

public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void cadastrarCliente(Cliente cliente) {
        clienteRepository.salvar(cliente);
    }

    public Cliente obterCliente(Long id) {
        return clienteRepository.buscar(id);
    }

    // Outros métodos de negócio
}