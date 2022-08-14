package com.github.wandirpereira.msclientes.application;

import com.github.wandirpereira.msclientes.domain.Cliente;
import com.github.wandirpereira.msclientes.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

//    public ClienteService(ClienteRepository clienteRepository) {
//        this.clienteRepository= clienteRepository;
//    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> getByCPF(String cpf){
        return clienteRepository.findByCpf(cpf);
    }
}
