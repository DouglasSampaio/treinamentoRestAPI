package com.douglas.treinamentorest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.treinamentorest.domain.Cartao;
import com.douglas.treinamentorest.repository.CartaoRepository;

@Service
public class CartaoService {
	
	@Autowired
	private CartaoRepository repo;
	public List<Cartao> finAll(){
		return repo.findAll();
	}
}
