package com.lavarapido.lava_rapido_api.service;

import com.lavarapido.lava_rapido_api.domain.Carro;
import com.lavarapido.lava_rapido_api.domain.Cliente;
import com.lavarapido.lava_rapido_api.repository.CarroRepository;
import com.lavarapido.lava_rapido_api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    private CarroRepository carroRepository;
    private ClienteRepository clienteRepository;

    public CarroService(CarroRepository carroRepository, ClienteRepository clienteRepository) {
        this.carroRepository = carroRepository;
        this.clienteRepository = clienteRepository;
    }

    public Carro cadastrar(Long clienteId, Carro carro){

        if(carroRepository.existsByPlaca(carro.getPlaca())){
            throw new RuntimeException("Placa já cadastrada");
        }

        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        carro.setCliente(cliente);
        return carroRepository.save(carro);
    }

    public List<Carro> findByPlaca() {
        return carroRepository.findAll();
    }
}
