package com.lavarapido.lava_rapido_api.controller;

import com.lavarapido.lava_rapido_api.domain.Carro;
import com.lavarapido.lava_rapido_api.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes/{cliente_id}/carro")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {this.carroService = carroService;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carro cadastrar(@RequestBody Carro carro, @PathVariable ("cliente_id") Long cliente_id) {
        return carroService.cadastrar(cliente_id, carro);
    }

    @GetMapping
    public ResponseEntity<List<Carro>> getCarroById() {
        List<Carro> carros = carroService.findByPlaca();
        return ResponseEntity.ok(carros);
    }

}
