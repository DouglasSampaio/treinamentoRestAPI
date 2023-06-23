package com.douglas.treinamentorest.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.treinamentorest.domain.Cartao;

@RestController
@RequestMapping(value = "/cartoes")
public class CartaoController {

	@GetMapping
	public ResponseEntity<List<Cartao>> findAll() {
		Cartao teste = new Cartao(1, "123123123123", "dougbala", "10/30", 000, "123");
		Cartao teste2 = new Cartao(2, "45645464566", "crain", "10/30", 000, "124");
		List<Cartao> list = new ArrayList<Cartao>();
		list.addAll(Arrays.asList(teste, teste2));
		return ResponseEntity.ok().body(list);
	}
}
