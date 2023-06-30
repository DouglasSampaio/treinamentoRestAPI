package com.douglas.treinamentorest.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.douglas.treinamentorest.controllers.CartaoController;
import com.douglas.treinamentorest.domain.Cartao;
import com.douglas.treinamentorest.services.CartaoService;

import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest
public class CartaoControllerTest {
	
	@Autowired
	private CartaoController cartaoController;
	
	@MockBean
	private CartaoService service;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(cartaoController);
	}
	
	@Test
	public void deveRetornarSucesso_QuandoBuscarCartao() {
		
		when(service.findBySaldo("123456456")).thenReturn(new Cartao(null,"123456456",250, "456"));
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/cartoes/{numero}", "123456456")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarNaoEncontrado_QuandoBuscarCartao() {
		
		when(service.findBySaldo("1234"))
			.thenReturn(null);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/cartoes/{numero}", "1234")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
}
