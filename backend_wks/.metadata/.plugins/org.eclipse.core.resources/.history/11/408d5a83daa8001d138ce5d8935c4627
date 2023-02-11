package br.senai.suico.RestauranteX.service;

import java.util.List;
import java.util.Optional;

import br.senai.suico.RestauranteX.model.entity.Cliente;

public interface ClienteService {
	Cliente salvar(Cliente cliente);
	Cliente atualizar(Cliente cliente);
	void deletar(long id);
	List<Cliente> buscar();
	public Optional<Cliente>  buscarPorId(long id);
	void validar(Cliente cliente);
	void autenticar(Cliente cliente);
}