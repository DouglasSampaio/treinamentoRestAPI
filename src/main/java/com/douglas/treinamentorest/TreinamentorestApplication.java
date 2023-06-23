package com.douglas.treinamentorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TreinamentorestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreinamentorestApplication.class, args);
	}

}
