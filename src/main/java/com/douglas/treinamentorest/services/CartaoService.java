package com.douglas.treinamentorest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.treinamentorest.domain.Cartao;
import com.douglas.treinamentorest.dto.CartaoDTO;
import com.douglas.treinamentorest.repository.CartaoRepository;

@Service
public class CartaoService {

	@Autowired
	private CartaoRepository repository;

	public List<Cartao> findAll() {
		return repository.findAll();
	}
	
	public Cartao findBySaldo(String numeroCartao) {
		Optional<Cartao> obj = repository.findByNumero(numeroCartao);
		return obj.orElseThrow(() -> new RuntimeException());
	}

	public Optional<Cartao> findByNumero(String numeroCartao) {
		Optional<Cartao> obj = repository.findByNumero(numeroCartao);
		return obj;
	}

	public Cartao insert(Cartao obj) {
		return repository.insert(obj);

	}

	public Cartao update(Cartao obj) {
		Cartao newObj = findBySaldo(obj.getNumero());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Cartao newObj, Cartao obj) {
		newObj.setNumero(obj.getNumero());
		newObj.setCodigoSeguranca(obj.getCodigoSeguranca());
		newObj.setSenha(obj.getSenha());
		newObj.setSaldo(obj.getSaldo());
	}

	public Cartao saldoCartaoDTO(CartaoDTO saldoDto) {
		return new Cartao(saldoDto.getId(), saldoDto.getNumero(), saldoDto.getCodigoSeguranca(), saldoDto.getSenha(), saldoDto.getSaldo());
	}

	public Cartao newCartaoDto(CartaoDTO cartaoDto) {
		return new Cartao(cartaoDto.getId(), cartaoDto.getNumero(),cartaoDto.getCodigoSeguranca(), cartaoDto.getSenha());
	}

}
