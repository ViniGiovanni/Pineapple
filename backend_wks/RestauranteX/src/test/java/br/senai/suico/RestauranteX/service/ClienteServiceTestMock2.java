package br.senai.suico.RestauranteX.service;


import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import br.senai.suico.RestauranteX.model.repository.ClienteRepository;
import br.senai.suico.RestauranteX.service.impl.ClienteServiceImpl;

@ExtendWith(SpringExtension.class) // Unit 5
@SpringBootTest
@ActiveProfiles("test")
public class ClienteServiceTestMock2 {
  

	
	
	@MockBean
	static ClienteRepository  repository;
	
    ClienteService service =new ClienteServiceImpl(repository);
	
	@BeforeAll
	public static void init(){
		System.out.println("BeforeAll init() method called");
       
 	
	}

	@BeforeTestClass
	public static void init2(){
		System.out.println("BeforeTestClass? ");
	}

	@Before(value="deveValidarEmail()")
	public static void setUp() {
		System.out.print(" Before1 ?");
	}

	@BeforeEach
	public void executarAntesDeCadaTeste() {
		System.out.print(" @BeforeEach ");
	}

		
	@Test
	public void deveValidarEmail() {
		System.out.print(" deveValidarEmail ");
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);

		/*
		Cliente cliente = Cliente.builder().nome("usuario").email("email@email.com").senha("123").build();
			repository.save(cliente);		
		List<Cliente> lista= repository.findAll();
		*/
		
		service.validarEmail("email@email.com");
		
	}
	
	@Test
	public void deveLancarErroQuandoExistirEmailCadastrado() {
		System.out.print(" deveLancarErroQuandoExistirEmailCadastrado ");
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);
		
		Assertions.assertThrows( ResponseStatusException.class,
				() -> {service.validarEmail("email@email.com");});  
	
}
}
