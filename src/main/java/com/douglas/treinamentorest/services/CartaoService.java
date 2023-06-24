package com.douglas.treinamentorest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.treinamentorest.domain.Cartao;
import com.douglas.treinamentorest.dto.CartaoDTO;
import com.douglas.treinamentorest.repository.CartaoRepository;
import com.douglas.treinamentorest.services.exception.ObjectNotFoundException;

@Service
public class CartaoService {
 
	@Autowired
	private CartaoRepository repo;

	public List<Cartao> finAll() {
		return repo.findAll();
	}
 
	public Cartao findById(String id) {
		Optional<Cartao> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Cartao nao encontrado"));
	}
	
	public Cartao insert(Cartao obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Cartao fromDTO(CartaoDTO objDto) {
		return new Cartao(objDto.getId(),objDto.getTipo(), objDto.getNumero(),objDto.getTitular(),objDto.getDataValidade(),objDto.getCodigoSeguranca(),objDto.getSenha(),objDto.getSaldo());
	}
}
