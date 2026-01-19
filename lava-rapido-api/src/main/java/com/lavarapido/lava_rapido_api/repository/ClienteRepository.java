package com.lavarapido.lava_rapido_api.repository;

import com.lavarapido.lava_rapido_api.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByTelefone(String telefone);
    boolean existsByTelefone(String telefone);
}
