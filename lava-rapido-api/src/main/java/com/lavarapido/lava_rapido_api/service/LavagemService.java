package com.lavarapido.lava_rapido_api.service;

import com.lavarapido.lava_rapido_api.domain.Carro;
import com.lavarapido.lava_rapido_api.domain.Lavagem;
import com.lavarapido.lava_rapido_api.domain.TipoLavagem;
import com.lavarapido.lava_rapido_api.repository.CarroRepository;
import com.lavarapido.lava_rapido_api.repository.LavagemRepository;
import org.springframework.stereotype.Service;

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
}
