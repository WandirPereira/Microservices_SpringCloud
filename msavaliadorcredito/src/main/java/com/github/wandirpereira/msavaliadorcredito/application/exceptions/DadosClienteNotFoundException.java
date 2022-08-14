package com.github.wandirpereira.msavaliadorcredito.application.exceptions;


public class DadosClienteNotFoundException extends Exception{
    public DadosClienteNotFoundException() {
        super("Dados do cliente não encontrados para o CPF informado!");
    }
}
