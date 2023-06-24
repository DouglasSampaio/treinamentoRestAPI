package com.douglas.treinamentorest.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.treinamentorest.domain.Cartao;
import com.douglas.treinamentorest.dto.CartaoDTO;
import com.douglas.treinamentorest.services.CartaoService;

@RestController
@RequestMapping(value = "/cartoes")
public class CartaoController {

	@Autowired
	private CartaoService service;
	
	@GetMapping
	public ResponseEntity<List<CartaoDTO>> findAll() {
		List<Cartao> list = service.finAll();
		List<CartaoDTO> listDto = list.stream().map(x -> new CartaoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
