package com.lavarapido.lava_rapido_api.service;

import com.lavarapido.lava_rapido_api.domain.Cliente;
import com.lavarapido.lava_rapido_api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrar(Cliente cliente) {

        if (clienteRepository.existsByTelefone(cliente.getTelefone())) {
            throw new IllegalArgumentException("Telefone já cadastrado");
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findByTelefone() {
        return clienteRepository.findAll();
    }
}
