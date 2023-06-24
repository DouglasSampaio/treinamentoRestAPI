package com.douglas.treinamentorest.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.douglas.treinamentorest.domain.Cartao;

@Repository
public interface CartaoRepository extends MongoRepository<Cartao, BigInteger> {

}
