package org.example.model;

import jakarta.persistence.*;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valor;

    // Construtores, getters e setters
    public Pagamento() {}

    public Pagamento(double valor) {
        this.valor = valor;
    }

    public Long getId() { return id; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
}