package com.lavarapido.lava_rapido_api.repository;

import com.lavarapido.lava_rapido_api.domain.Lavagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface FaturamentoRepository extends JpaRepository<Lavagem,Long> {
//    @Query("SELECT SUM(l.valor) " +
//            "FROM Lavagem l " +
//            "WHERE l.dataHora BETWEEN :inicio AND :fim"
//    )
//
//    BigDecimal faturamentoPorPeriodo(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);
}
