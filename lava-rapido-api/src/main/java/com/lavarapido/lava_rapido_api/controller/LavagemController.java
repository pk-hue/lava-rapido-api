package com.lavarapido.lava_rapido_api.controller;

import com.lavarapido.lava_rapido_api.domain.Lavagem;
import com.lavarapido.lava_rapido_api.domain.TipoLavagem;
import com.lavarapido.lava_rapido_api.service.LavagemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    public ResponseEntity<Lavagem> cadastrar(@RequestParam Long carroId ,@RequestParam(name = "tipo") TipoLavagem tipoLavagem) {
        Lavagem lavagem = lavagemService.cadastrar(carroId, tipoLavagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(lavagem);
    }

    @GetMapping("/carro/{carroId}")
    public ResponseEntity<List<Lavagem>> listarPorCarroId(@PathVariable Long carroId) {
        List<Lavagem> lavagem = lavagemService.findByCarroIdOrderByDataHoraDesc(carroId);
        return ResponseEntity.status(HttpStatus.OK).body(lavagem);
    }

    @GetMapping("/faturamento")
    public BigDecimal faturamento(@RequestParam LocalDate inicio, @RequestParam LocalDate fim) {
        return lavagemService.faturamento(inicio, fim);
    }

    @GetMapping("faturamentoLiquido")
    public BigDecimal faturamentoLiquido(@RequestParam LocalDate inicio, @RequestParam LocalDate fim) {
        return lavagemService.faturamentoLiquido(inicio, fim);
    }
}
