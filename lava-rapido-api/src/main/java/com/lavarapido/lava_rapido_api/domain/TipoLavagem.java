package com.lavarapido.lava_rapido_api.domain;

import java.math.BigDecimal;

public enum TipoLavagem {
    SIMPLES(new BigDecimal("70.00")),
    COMPLETA(new BigDecimal("120.00")),
    PREMIUM(new BigDecimal("140.00"));

    private final BigDecimal valor;
    TipoLavagem(BigDecimal valor) {this.valor = valor;}
    public BigDecimal getValor() {return valor;}
}
