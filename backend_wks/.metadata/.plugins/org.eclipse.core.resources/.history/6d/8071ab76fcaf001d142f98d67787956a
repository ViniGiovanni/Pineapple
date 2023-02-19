package br.senai.suico.RestauranteX.service;

import java.util.List;
import java.util.Optional;

import br.senai.suico.RestauranteX.model.dto.ClienteDto;
import br.senai.suico.RestauranteX.model.entity.Cliente;

public interface ClienteService {
	Cliente salvar(Cliente cliente);
	Cliente atualizar(Cliente cliente);
	void deletar(long id);
	List<Cliente> buscar();
	public Optional<Cliente>  buscarPorId(long id);
	public Optional<Cliente>  buscarPorEmail(String email);	
	void validar(Cliente cliente);
	public Optional<ClienteDto> autenticar(Cliente cliente);
}