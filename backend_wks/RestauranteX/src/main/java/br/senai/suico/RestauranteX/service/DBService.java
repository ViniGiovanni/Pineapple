package br.senai.suico.RestauranteX.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.suico.RestauranteX.model.entity.Cliente;
import br.senai.suico.RestauranteX.model.repository.ClienteRepository;

@Service
public class DBService {

	@Autowired
	private ClienteRepository clienteRepository;

	public void instanciaDB() {
		Cliente c1 = new Cliente(null, "Regina Costa", "regina@gmail.com", "123", "USER");
		Cliente c2 = new Cliente(null, "Luan Silva", "luan@gmail.com", "123", "USER");
		Cliente c3 = new Cliente(null, "Administrador", "admin@gmail.com", "123", "ADMIN");

		var c4 = Cliente.builder().nome("Tarrou").email("tarrou@gmail.com").senha("123").roles("ADMIN,USER").build();

		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
	}
}
