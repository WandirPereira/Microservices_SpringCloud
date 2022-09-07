package com.github.wandirpereira.mscartoes.application;

import com.github.wandirpereira.mscartoes.domain.Cartao;
import com.github.wandirpereira.mscartoes.infra.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoService {

        private final CartaoRepository cartaoRepository;

        @Transactional
        public  Cartao save(Cartao cartao){
            return cartaoRepository.save(cartao);
        }


        public List<Cartao> getCartaoRendaMenorIgual(Long renda){
            var rendaBigDecimal = BigDecimal.valueOf(renda);
            return cartaoRepository.findByRendaLessThanEqual(rendaBigDecimal);
        }
}
