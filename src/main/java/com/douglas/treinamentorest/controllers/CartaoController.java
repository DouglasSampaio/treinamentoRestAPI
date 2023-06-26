package com.douglas.treinamentorest.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.treinamentorest.domain.Cartao;
import com.douglas.treinamentorest.dto.CartaoCreateDTO;
import com.douglas.treinamentorest.dto.CartaoDTO;
import com.douglas.treinamentorest.dto.CartaoSaldoDTO;
import com.douglas.treinamentorest.dto.TransacaoDTO;
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

	@GetMapping(value = "/user/{id}")
	public ResponseEntity<CartaoDTO> findById(@PathVariable String id) {
		Cartao obj = service.findById(id);
		return ResponseEntity.ok().body(new CartaoDTO(obj));
	}

	@GetMapping("/{numero}")
	public ResponseEntity<CartaoSaldoDTO> findBySaldo(@PathVariable String numero) {
		Cartao obj = service.findByNumero(numero);
		return ResponseEntity.ok().body(new CartaoSaldoDTO(obj));
	}

	@PostMapping
	public ResponseEntity<CartaoCreateDTO> insert(@RequestBody CartaoDTO cartaoDTO) {
		String senha = cartaoDTO.getSenha();
		String numeroCartao = cartaoDTO.getNumero();
		CartaoCreateDTO responseTeste = new CartaoCreateDTO(senha, numeroCartao);
		Optional<Cartao> existingCartao = service.findByNumeroTeste(numeroCartao);
		if (existingCartao.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseTeste);
		}

		CartaoCreateDTO response = new CartaoCreateDTO("Criação com sucesso: Status Code: 201", senha, numeroCartao);
		Cartao obj = service.newCartaoDto(cartaoDTO);
		obj = service.insert(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody CartaoDTO objDto, @PathVariable String id) {
		Cartao obj = service.saldoCartaoDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/{numero}/transacao")
	public ResponseEntity<String> autorizarTransacao(@PathVariable String numero,
			@RequestBody TransacaoDTO transacaoDTO) {
		Cartao cartao = service.findByNumero(numero);

		if (cartao == null) {
			return ResponseEntity.notFound().build();
		}
		if (cartao.getCodigoSeguranca() != transacaoDTO.getCodigoSeguranca()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Código de segurança incorreto");
		}
		if (!cartao.getSenha().equals(transacaoDTO.getSenha())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
		}
		double valor = transacaoDTO.getValor();
		if (cartao.getSaldo() < valor) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Saldo insuficiente");
		}
		cartao.setSaldo(cartao.getSaldo() - valor);
		service.update(cartao);

		return ResponseEntity.ok("Transação autorizada");
	}

}
