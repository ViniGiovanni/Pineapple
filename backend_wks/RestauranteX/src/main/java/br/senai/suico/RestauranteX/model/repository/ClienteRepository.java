package br.senai.suico.RestauranteX.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.suico.RestauranteX.model.entity.Cliente;

public interface  ClienteRepository extends JpaRepository<Cliente,Long> {

}
