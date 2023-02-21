package br.senai.suico.RestauranteX.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests()
				.requestMatchers(HttpMethod.POST, "/api/Clientes/autenticar","/api/Clientes").permitAll().and()
				.authorizeHttpRequests().anyRequest().permitAll().and()		
				//.authorizeHttpRequests().anyRequest().authenticated().and()		
				.logout((logout) -> logout.permitAll())
				.formLogin()
				.and()
				.httpBasic();

		return http.build();
	}

	/*
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests(
				(requests) -> requests
				   .requestMatchers(HttpMethod.POST, "/api/Clientes/autenticar").permitAll()
				//.requestMatchers(HttpMethod.POST, "/api/Clientes/cadastrar").permitAll()
				//.requestMatchers(HttpMethod.POST, "/api/Clientes/autenticar").permitAll()
				   //.requestMatchers(HttpMethod.POST, "/api/Clientes").permitAll()
				   .requestMatchers(HttpMethod.GET, "/api/Clientes").permitAll()
				 //  .requestMatchers(HttpMethod.GET, "/api/Clientes/*").authenticated()
				)
				.logout((logout) -> logout.permitAll())
				.formLogin()
				.and()
				.httpBasic();

		return http.build();
	}
	*/	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {

		UserDetails admin = User.withUsername("admin")
			.password(encoder.encode("password"))
			.roles("ADMIN").build();

		UserDetails user = User.withUsername("user")
		.password(encoder.encode("password"))
		.roles("USER").build();

		return new InMemoryUserDetailsManager(user, admin);
	
		//return new ClienteUserDetailService();
	}

}
