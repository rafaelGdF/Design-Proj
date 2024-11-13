package org.example.presentation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.model.Cliente;
import org.example.model.ItemPedido;
import org.example.model.Pagamento;
import org.example.model.Pedido;
import org.example.model.Produto;
import org.example.repository.ClienteRepository;
import org.example.repository.ItemPedidoRepository;
import org.example.repository.PagamentoRepository;
import org.example.repository.PedidoRepository;
import org.example.repository.ProdutoRepository;
import org.example.service.ClienteService;
import org.example.service.ItemPedidoService;
import org.example.service.PagamentoService;
import org.example.service.PedidoService;
import org.example.service.ProdutoService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criação do EntityManager e EntityManagerFactory (com configurações do persistence.xml)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja_unit");
        EntityManager em = emf.createEntityManager();

        // Repositórios
        ClienteRepository clienteRepository = new ClienteRepository(em);
        ProdutoRepository produtoRepository = new ProdutoRepository(em);
        PedidoRepository pedidoRepository = new PedidoRepository(em);
        ItemPedidoRepository itemPedidoRepository = new ItemPedidoRepository(em);
        PagamentoRepository pagamentoRepository = new PagamentoRepository(em);

        // Serviços
        ClienteService clienteService = new ClienteService(clienteRepository);
        ProdutoService produtoService = new ProdutoService(produtoRepository);
        PedidoService pedidoService = new PedidoService(pedidoRepository);
        ItemPedidoService itemPedidoService = new ItemPedidoService(itemPedidoRepository);
        PagamentoService pagamentoService = new PagamentoService(pagamentoRepository);

        // Exemplo de uso: Criando e salvando um Cliente
        Cliente cliente = new Cliente("Maria", "maria@example.com");
        clienteService.cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado: " + cliente.getNome());

        // Exemplo de uso: Criando e salvando um Produto
        Produto produto = new Produto("Camiseta", 50.0);
        produtoService.cadastrarProduto(produto);
        System.out.println("Produto cadastrado: " + produto.getNome());

        // Exemplo de uso: Criando e salvando um Pedido
        Pedido pedido = new Pedido(new Date());
        pedidoService.cadastrarPedido(pedido);
        System.out.println("Pedido cadastrado com ID: " + pedido.getId());

        // Exemplo de uso: Criando e salvando um ItemPedido
        ItemPedido itemPedido = new ItemPedido(2, produto); // 2 unidades de "Camiseta"
        itemPedidoService.cadastrarItemPedido(itemPedido);
        System.out.println("ItemPedido cadastrado com quantidade: " + itemPedido.getQuantidade());

        // Exemplo de uso: Criando e salvando um Pagamento
        Pagamento pagamento = new Pagamento(100.0);
        pagamentoService.cadastrarPagamento(pagamento);
        System.out.println("Pagamento realizado de valor: " + pagamento.getValor());

        // Consultando os objetos cadastrados
        Cliente clienteBuscado = clienteService.obterCliente(cliente.getId());
        Produto produtoBuscado = produtoService.obterProduto(produto.getId());
        Pedido pedidoBuscado = pedidoService.obterPedido(pedido.getId());
        ItemPedido itemPedidoBuscado = itemPedidoService.obterItemPedido(itemPedido.getId());
        Pagamento pagamentoBuscado = pagamentoService.obterPagamento(pagamento.getId());

        System.out.println("Cliente encontrado: " + clienteBuscado.getNome());
        System.out.println("Produto encontrado: " + produtoBuscado.getNome());
        System.out.println("Pedido encontrado, ID: " + pedidoBuscado.getId());
        System.out.println("ItemPedido encontrado, Quantidade: " + itemPedidoBuscado.getQuantidade());
        System.out.println("Pagamento encontrado, Valor: " + pagamentoBuscado.getValor());

        // Fechando o EntityManager e EntityManagerFactory
        em.close();
        emf.close();
    }
}