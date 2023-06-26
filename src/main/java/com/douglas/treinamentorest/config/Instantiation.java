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
		Cartao douglas = new Cartao(null, "Refeição", "123456456", "Dougbala", "10/30", 000, "édoce");
		Cartao crain = new Cartao(null, "Alimentação", "888888888", "Crain", "10/30", 001, "naoédoce");
		Cartao tamburete = new Cartao(null, "Refeição", "846543232", "Tamburete", "10/30", 002, "azedo");

		cartaoRepository.saveAll(Arrays.asList(douglas, crain, tamburete));
	}

}
