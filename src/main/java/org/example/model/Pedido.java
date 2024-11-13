package org.example.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data_pedido;

    // Construtores, getters e setters
    public Pedido() {}

    public Pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Long getId() { return id; }
    public Date getData() { return data_pedido; }
    public void setData(Date data_pedido) { this.data_pedido = data_pedido; }
}