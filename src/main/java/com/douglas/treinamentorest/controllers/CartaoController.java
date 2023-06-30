package com.douglas.treinamentorest.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		List<Cartao> list = service.findAll();
		List<CartaoDTO> listDto = list.stream().map(x -> new CartaoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping("/{numero}")
	public ResponseEntity<CartaoSaldoDTO> findBySaldo(@PathVariable String numero) {
		try {
			Cartao obj = service.findBySaldo(numero);
			CartaoSaldoDTO saldoDTO = new CartaoSaldoDTO(obj.getSaldo());
			return ResponseEntity.status(HttpStatus.OK).body(saldoDTO);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping
	public ResponseEntity<CartaoCreateDTO> insert(@RequestBody CartaoDTO cartaoDTO) {
		String senha = cartaoDTO.getSenha();
		String numeroCartao = cartaoDTO.getNumero();
		CartaoCreateDTO response = new CartaoCreateDTO(numeroCartao, senha);

		try {
			Optional<Cartao> existingCartao = service.findByNumero(numeroCartao);
			if (existingCartao.isPresent()) {
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
			}
			Cartao obj = service.newCartaoDto(cartaoDTO);
			obj = service.insert(obj);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
		}
	}

	@PostMapping("/transacao")
	public ResponseEntity<String> autorizarTransacao(@RequestBody TransacaoDTO transacaoDTO) {

		try {
			System.out.println(transacaoDTO.getNumero());
			Cartao cartao = service.findBySaldo(transacaoDTO.getNumero());

			if (!cartao.getSenha().equals(transacaoDTO.getSenha())) {
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("SENHA_INVALIDA");
			}

			double valor = transacaoDTO.getValor();
			if (cartao.getSaldo() < valor) {
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("SALDO_INSUFICIENTE");
			}

			cartao.setSaldo(cartao.getSaldo() - valor);
			service.update(cartao);

			return ResponseEntity.status(HttpStatus.CREATED).body("OK");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("CARTAO_INEXISTENTE");
		}
	}

}
