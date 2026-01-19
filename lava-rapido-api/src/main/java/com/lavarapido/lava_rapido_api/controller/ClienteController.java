package com.lavarapido.lava_rapido_api.controller;

import com.lavarapido.lava_rapido_api.domain.Cliente;
import com.lavarapido.lava_rapido_api.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return clienteService.cadastrar(cliente);
    }

    @GetMapping()
    public ResponseEntity<List<Cliente>> getCleinteById() {
        List<Cliente> clientes = clienteService.findByTelefone();
        return ResponseEntity.ok(clientes);
    }
}
