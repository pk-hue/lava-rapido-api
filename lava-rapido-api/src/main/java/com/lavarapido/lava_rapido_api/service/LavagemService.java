package com.lavarapido.lava_rapido_api.service;

import com.lavarapido.lava_rapido_api.domain.Carro;
import com.lavarapido.lava_rapido_api.domain.Lavagem;
import com.lavarapido.lava_rapido_api.domain.TipoLavagem;
import com.lavarapido.lava_rapido_api.repository.CarroRepository;
import com.lavarapido.lava_rapido_api.repository.LavagemRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LavagemService {
    private CarroRepository carroRepository;
    private LavagemRepository lavagemRepository;

    public LavagemService(CarroRepository carroRepository,  LavagemRepository lavagemRepository) {
        this.carroRepository = carroRepository;
        this.lavagemRepository = lavagemRepository;
    }

    public Lavagem cadastrar(Long carroId, TipoLavagem tipo) {

        Carro carro = carroRepository.findById(carroId).orElseThrow(() -> new RuntimeException("Carro não encontrado."));

        Lavagem lavagem = new Lavagem();

        lavagem.setCarro(carro);
        lavagem.setTipo(tipo);
        lavagem.setValor(tipo.getValor());
        return lavagemRepository.save(lavagem);
    }

    public List<Lavagem> findByCarroIdOrderByDataHoraDesc(Long carroId) {
        return lavagemRepository.findByCarroIdOrderByDataHoraDesc(carroId);
    }

    public BigDecimal faturamento(LocalDate inicio, LocalDate fim) {
        return lavagemRepository.faturamentoPorPeriodo(inicio.atStartOfDay(), fim.atTime(23, 59, 59));
    }

    public BigDecimal faturamentoLiquido(LocalDate inicio, LocalDate fim){
        BigDecimal bruto = faturamento(inicio,fim);

        if (bruto == null) return BigDecimal.ZERO;
        return bruto.multiply(new  BigDecimal("0.85")).setScale(2, RoundingMode.HALF_EVEN);
    }
}
