package com.github.wandirpereira.msavaliadorcredito.application.exceptions;

public class ErroSolicitacaoCartaoException extends RuntimeException{
    public ErroSolicitacaoCartaoException(String message) {
        super(message);
    }
}