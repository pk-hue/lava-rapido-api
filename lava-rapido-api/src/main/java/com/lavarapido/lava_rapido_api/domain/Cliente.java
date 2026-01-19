package com.lavarapido.lava_rapido_api.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, unique = true, length = 20)
    private String telefone;

    @Column(nullable = false, name = "criado_em")
    private LocalDateTime criadoEm;

    @OneToMany(mappedBy = "cliente")
    private List<Carro> carros = new ArrayList();

    public Cliente(){
    }

    public Cliente(String nome, String telefone, LocalDateTime criadoEm) {
        this.nome = nome;
        this.telefone = telefone;
        this.criadoEm = criadoEm;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public LocalDateTime getCriadoEm() {return criadoEm;}
    public void setCriadoEm(LocalDateTime criadoEm) {this.criadoEm = criadoEm;}

    @PrePersist
    public void onCreate(){
        this.criadoEm = LocalDateTime.now();
    }
}
