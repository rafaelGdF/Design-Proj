package org.example.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;

    // Construtores, getters e setters
    public Pedido() {}

    public Pedido(Date data) {
        this.data = data;
    }

    public Long getId() { return id; }
    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }
}