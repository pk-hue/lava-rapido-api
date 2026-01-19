package com.lavarapido.lava_rapido_api.repository;

import com.lavarapido.lava_rapido_api.domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    Optional<Carro> findByPlaca(String placa);
    boolean existsByPlaca(String placa);
}
