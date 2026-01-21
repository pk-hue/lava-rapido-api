package com.lavarapido.lava_rapido_api.repository;

import com.lavarapido.lava_rapido_api.domain.Lavagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LavagemRepository extends JpaRepository<Lavagem, Long> {
    Optional<Lavagem> findById(Long id);
    boolean existsById(Long id);
}
