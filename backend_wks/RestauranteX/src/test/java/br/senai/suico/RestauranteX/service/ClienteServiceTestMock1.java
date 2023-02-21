package br.senai.suico.RestauranteX.service;

import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import br.senai.suico.RestauranteX.model.entity.Cliente;
import br.senai.suico.RestauranteX.model.repository.ClienteRepository;
import br.senai.suico.RestauranteX.service.impl.ClienteServiceImpl;

@ExtendWith(SpringExtension.class) // Unit 5
@SpringBootTest
@ActiveProfiles("test")
public class ClienteServiceTestMock1 {

	static ClienteService service;
	static ClienteRepository repository;

	@BeforeAll
	public static void init() {
		System.out.println("BeforeAll init() method called");
		repository = Mockito.mock(ClienteRepository.class);
		service = new ClienteServiceImpl(repository);

	//	Cliente cliente = Cliente.builder().nome("usuario").email("email@email.com").senha("123").build();
//		repository.save(cliente);

	//	List<Cliente> lista = repository.findAll();
	//	System.out.println("BeforeAll fim() method called");
	}

	@BeforeTestClass
	public static void init2() {
		System.out.println("BeforeTestClass? ");
		//repository = Mockito.mock(ClienteRepository.class);
		//service = new ClienteServiceImpl(repository);

	//	Cliente cliente = Cliente.builder().nome("usuario").email("email@email.com").senha("123").build();
	//	repository.save(cliente);

		List<Cliente> lista = repository.findAll();
		System.out.println("BeforeAll fim() method called");
	}

	@Before(value = "deveValidarEmail()")
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

		Cliente cliente = Cliente.builder().nome("usuario").email("email@email.com").senha("123").build();
		repository.save(cliente);

		List<Cliente> lista = repository.findAll();
		service.validarEmail("email@email.com");

	}

	@Test
	public void deveLancarErroQuandoExistirEmailCadastrado() {
		System.out.print(" deveLancarErroQuandoExistirEmailCadastrado ");
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);

		Cliente cliente = Cliente.builder().nome("usuario").email("email@email.com").senha("123").build();
		repository.save(cliente);

		List<Cliente> lista = repository.findAll();

		Assertions.assertThrows(ResponseStatusException.class, () -> {
			service.validarEmail("email@email.com");
		});

	}
	
	@Test
	public void deveAutenticaUmUsuarioComSucesso() {
		String email="email@email.com";
		String nome= "user";
		String senha ="senha";
		Cliente cliente = Cliente.builder().id(1l).nome(nome).email(email).senha(senha).build();
		Mockito.when(repository.findByEmail(email)).thenReturn(Optional.of(cliente));
		
		var clienteDto= service.autenticar(cliente);
		
		Assertions.assertNotNull(clienteDto);
	}
	
	@Test
	public void deveLancarErroQuandoNaoEncontrarUsuarioCadastradoComEmail() {
		Cliente cliente = Cliente.builder().id(1l).nome("qualqueruser").email("qualqueremail@gmail.com").senha("senha").build();

		Mockito.when(repository.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());
		
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			service.autenticar(cliente);
		});
		
	}
	

	@Test
	public void deveLancarErroQuandoSenhaNaoBater() {
		Cliente clienteRetorno = Cliente.builder().email("email@gmail.com").senha("senha").build();
		Cliente clienteBusca = Cliente.builder().email("email@gmail.com").senha("outrasenha").build();
        
		Mockito.when(repository.findByEmail(Mockito.anyString())).thenReturn(Optional.of(clienteRetorno));
		
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			service.autenticar(clienteBusca);
		});
		
	}

}
