package com.github.wandirpereira.mscartoes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
@Table(name="clientecartao")
public class ClienteCartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String cpf;

    @ManyToOne
    @JoinColumn(name="id_cartao")
    private Cartao cartao;

    private BigDecimal limite;

}
