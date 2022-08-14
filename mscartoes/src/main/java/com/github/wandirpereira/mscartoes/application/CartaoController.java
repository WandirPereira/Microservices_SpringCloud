package com.github.wandirpereira.mscartoes.application;

import com.github.wandirpereira.mscartoes.application.representation.CartoesPorClienteResponse;
import com.github.wandirpereira.mscartoes.domain.Cartao;
import com.github.wandirpereira.mscartoes.domain.ClienteCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.github.wandirpereira.mscartoes.application.representation.CartaoSaveRequest;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartaoController {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

//    public CartaoController(CartaoService cartaoService) {
//        this.cartaoService = cartaoService;
//    }

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastra( @RequestBody CartaoSaveRequest request){
        Cartao cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAteh(@RequestParam("renda") Long renda){
        List<Cartao> list = cartaoService.getCartaoRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf){
       List<ClienteCartao> lista = clienteCartaoService.listCartoesByCpf(cpf);
       List<CartoesPorClienteResponse> resultList = lista.stream()
               .map(CartoesPorClienteResponse::fromModel)
               .collect(Collectors.toList());
       return ResponseEntity.ok(resultList);
    }
}
