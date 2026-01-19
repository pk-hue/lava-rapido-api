package com.lavarapido.lava_rapido_api.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carro_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(nullable = false, name = "criado_em")
    private LocalDateTime criadoEm = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    public Carro(){
    }

    public Carro(String placa, String modelo, LocalDateTime criadoEm, Cliente cliente) {
        this.placa = placa;
        this.modelo = modelo;
        this.criadoEm = criadoEm;
        this.cliente = cliente;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getPlaca() {return placa;}
    public void setPlaca(String placa) {this.placa = placa;}

    public String getModelo() {return modelo;}
    public void setModelo(String modelo) {this.modelo = modelo;}

    public LocalDateTime getCriadoEm() {return criadoEm;}
    public void setCriadoEm(LocalDateTime criadoEm) {this.criadoEm = criadoEm;}

    public Cliente getCliente() {return cliente;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}

    @PrePersist
    public void onCreate(){
        this.criadoEm = LocalDateTime.now();
    }
}
