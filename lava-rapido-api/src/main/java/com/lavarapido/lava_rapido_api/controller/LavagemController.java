package com.lavarapido.lava_rapido_api.controller;

import com.lavarapido.lava_rapido_api.domain.Lavagem;
import com.lavarapido.lava_rapido_api.domain.TipoLavagem;
import com.lavarapido.lava_rapido_api.service.LavagemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lavagem")
public class LavagemController {

    private LavagemService lavagemService;

    public LavagemController(LavagemService lavagemService) {
        this.lavagemService = lavagemService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Lavagem> cadastrar(@RequestParam Long carroId ,@RequestParam TipoLavagem tipoLavagem) {
        Lavagem lavagem = lavagemService.cadastrar(carroId, tipoLavagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(lavagem);
    }
}
