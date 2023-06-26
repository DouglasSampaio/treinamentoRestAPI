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
	private CartaoRepository repository;

	public List<Cartao> finAll() {
		return repository.findAll();
	}

	public Cartao findById(String id) {
		Optional<Cartao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("id nao encontrado"));
	}

	public Cartao findByNumero(String numero) {
		Optional<Cartao> obj = repository.findByNumero(numero);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cartão não encontrado"));
	}
	public Cartao findBySaldo(String numero) {
		Optional<Cartao> obj = repository.findByNumero(numero);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cartão não encontrado"));
	}

	public Optional<Cartao> findByNumeroTeste(String numero) {
		Optional<Cartao> obj = repository.findByNumero(numero);
		return obj;
	}

	public Cartao insert(Cartao obj) {
		return repository.insert(obj);

	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public Cartao update(Cartao obj) {
		Cartao newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Cartao newObj, Cartao obj) {
		newObj.setNumero(obj.getNumero());
		newObj.setTipo(obj.getTipo());
		newObj.setTitular(obj.getTitular());
		newObj.setDataValidade(obj.getDataValidade());
		newObj.setCodigoSeguranca(obj.getCodigoSeguranca());
		newObj.setSenha(obj.getSenha());
		newObj.setSaldo(obj.getSaldo());
	}

	public Cartao saldoCartaoDTO(CartaoDTO saldoDto) {
		return new Cartao(saldoDto.getId(), saldoDto.getTipo(), saldoDto.getNumero(), saldoDto.getTitular(),
				saldoDto.getDataValidade(), saldoDto.getCodigoSeguranca(), saldoDto.getSenha(), saldoDto.getSaldo());
	}

	public Cartao newCartaoDto(CartaoDTO cartaoDto) {
		return new Cartao(cartaoDto.getId(), cartaoDto.getTipo(), cartaoDto.getNumero(), cartaoDto.getTitular(),
				cartaoDto.getDataValidade(), cartaoDto.getCodigoSeguranca(), cartaoDto.getSenha());
	}

}
