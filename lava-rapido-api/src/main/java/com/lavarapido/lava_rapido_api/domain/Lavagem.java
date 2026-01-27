package com.lavarapido.lava_rapido_api.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "lavagem")
public class Lavagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lavagem_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private TipoLavagem tipo;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "carro_id", nullable = false)
    private Carro carro;

    public Lavagem() {
    }

    public Lavagem(Long id, TipoLavagem tipo, BigDecimal valor, LocalDateTime dataHora, Carro carro) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = dataHora;
        this.carro = carro;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public TipoLavagem getTipo() {return tipo;}
    public void setTipo(TipoLavagem tipo) {this.tipo = tipo;}

    public BigDecimal getValor() {return valor;}
    public void setValor(BigDecimal valor) {this.valor = valor;}

    public LocalDateTime getDataHora() {return dataHora;}
    public void setDataHora(LocalDateTime dataHora) {this.dataHora = dataHora;}

    public Carro getCarro() {return carro;}
    public void setCarro(Carro carro) {this.carro = carro;}

    @PrePersist
    public void onCreate() {this.dataHora = LocalDateTime.now();}
}
