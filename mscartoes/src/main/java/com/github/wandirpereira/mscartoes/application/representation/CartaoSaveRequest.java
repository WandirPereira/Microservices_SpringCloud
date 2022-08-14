package com.github.wandirpereira.mscartoes.application.representation;

import com.github.wandirpereira.mscartoes.domain.BandeiraCartao;
import com.github.wandirpereira.mscartoes.domain.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoSaveRequest {

    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;

    private BigDecimal limiteBasico;

    public Cartao toModel(){
        return new Cartao(nome, bandeira, renda, limiteBasico );
    }
}
