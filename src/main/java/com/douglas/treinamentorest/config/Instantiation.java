package com.douglas.treinamentorest.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.douglas.treinamentorest.domain.Cartao;
import com.douglas.treinamentorest.repository.CartaoRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private CartaoRepository cartaoRepository;

	@Override
	public void run(String... args) throws Exception {
		cartaoRepository.deleteAll();
		Cartao douglas = new Cartao(null,"123456456",250, "456");
		Cartao crain = new Cartao(null,"888888888",288, "654");
		Cartao mopa = new Cartao(null,"789456123",304, "777");

		cartaoRepository.saveAll(Arrays.asList(douglas, crain, mopa));
	}

}
