package br.senai.suico.RestauranteX.model.repository;

import br.senai.suico.RestauranteX.model.entity.Cliente;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//Deprecated - Unit 4
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;
//@RunWith(SpringRunner.class)

// Spring Boot versao igual ou superior do 2.2.0

@ExtendWith(SpringExtension.class) // Unit 5
@SpringBootTest
@ActiveProfiles("test")
public class ClienteRepositoryTest {

	@Autowired
	ClienteRepository repository;

	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		// cenário
		Cliente cliente = Cliente.builder().nome("usuario").email("usuario@gmail.com").senha("123").build();
		repository.save(cliente);

		// ação/execução
		boolean result = repository.existsByEmail("usuario@gmail.com");

		// verificação
		Assertions.assertTrue(result);

	}

	@Test
	public void deveRetornaFalsoQuandoNaoHouverUsuarioCadastradoComEmail() {
		repository.deleteAll();

		// ação/execução
		boolean result = repository.existsByEmail("usuario@gmail.com");

		// verificação
		Assertions.assertFalse(result);

	}

	@Test
	public void devePersistirUmUsuarioNaBaseDeDados() {		
		// cenário
		Cliente cliente = Cliente.builder().nome("usuario").email("usuario@gmail.com").senha("123").build();
		Cliente clienteSalvo= repository.save(cliente);
		
		
		// verificação
		Assertions.assertNotNull(clienteSalvo.getId());
	}

	@Test
	public void deveBuscarUmUsuarioPorEmail() {
		// cenário
		Cliente cliente = Cliente.builder().nome("usuario1").email("usuario1@gmail.com").senha("123").build();
		repository.save(cliente);
		
		// verificação
		Optional<Cliente> result = repository.findByEmail("usuario1@gmail.com");
		
		Assertions.assertTrue(result.isPresent() == true);
	}

	@Test
	public void deveRetornarVazioAoBuscarUsuarioQuandoNaoExiste1() {
		
		// verificação
		Optional<Cliente> result = repository.findByEmail("usuarioRsRsRsrsrs@gmail.com");
		
		Assertions.assertFalse(result.isPresent() == true);
	}
	
	
}
