package br.senai.suico.RestauranteX.config;
/*
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.senai.suico.RestauranteX.model.entity.Cliente;
import br.senai.suico.RestauranteX.model.repository.ClienteRepository;

@Component
public class ClienteUserDetailService implements UserDetailsService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Cliente> userInfo = repository.findByEmail(username);

		return userInfo.map(ClienteUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user not found"));
	}

}
*/