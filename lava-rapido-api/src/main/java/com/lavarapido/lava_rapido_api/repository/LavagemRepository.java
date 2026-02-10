package com.lavarapido.lava_rapido_api.repository;

import com.lavarapido.lava_rapido_api.domain.Lavagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LavagemRepository extends JpaRepository<Lavagem, Long> {
    Optional<Lavagem> findById(Long id);
    boolean existsById(Long id);
    List<Lavagem> findByCarroIdOrderByDataHoraDesc(Long carroId);

    @Query("SELECT SUM(l.valor) " +
            "FROM Lavagem l " +
            "WHERE l.dataHora BETWEEN :inicio AND :fim"
    )

    BigDecimal faturamentoPorPeriodo(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);
}
