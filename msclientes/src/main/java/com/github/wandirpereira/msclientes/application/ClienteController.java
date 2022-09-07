package com.github.wandirpereira.msclientes.application;

import com.github.wandirpereira.msclientes.application.representation.ClienteSaveRequest;
import com.github.wandirpereira.msclientes.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
@Slf4j
public class ClienteController {

    private static  final Logger log2 = LoggerFactory.getLogger(ClienteController.class);
    private final ClienteService clienteService;

    @GetMapping
    public String status(){
        log.info("Obtendo o status do microserviço de clientes");
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClienteSaveRequest request){
        Cliente cliente = request.toModel();
        clienteService.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();   //http://localhost:PORT/clientes?cpf=01234567890
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<Optional<Cliente>> dadosCliente(@RequestParam("cpf") String cpf){
        var cliente= clienteService.getByCPF(cpf);
        if(cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

}
