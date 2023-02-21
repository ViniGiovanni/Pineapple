package br.senai.suico.RestauranteX.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import br.senai.suico.RestauranteX.model.entity.Cliente;
import br.senai.suico.RestauranteX.model.repository.ClienteRepository;

@ExtendWith(SpringExtension.class) // Unit 5
@SpringBootTest
@ActiveProfiles("test")
public class ClienteServiceTest {
	@Autowired
	ClienteService service;
	
	@Autowired
	ClienteRepository repository;
	

		
	@Test
	public void deveValidarEmail() {
		repository.deleteAll();

		Assertions.assertDoesNotThrow(() -> service.validarEmail("email@email.com"));
		/* old code

		   service.validarEmail("email@email.com");
		   Assertions.assertThatNoException();

		 **/
	}
	
	@Test
	public void deveLancarErroQuandoExistirEmailCadastrado() {

		Cliente cliente = Cliente.builder().nome("usuario").email("email@email.com").senha("123").build();
		repository.save(cliente);
		
		Assertions.assertThrows( ResponseStatusException.class,
				() -> {service.validarEmail("email@email.com");});   
		/* old code

		   Assertions.assertThrows(() -> {service.validarEmail("email@email.com"))
		                           .isInstanceOf(ResponseStatusException.class)
	                                .hasMessageContaining("Found");
		
		 **/

	}
}
