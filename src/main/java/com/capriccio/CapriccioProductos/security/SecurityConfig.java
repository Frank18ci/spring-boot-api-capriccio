package com.capriccio.CapriccioProductos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.capriccio.CapriccioProductos.security.filters.JwtAuthenticationFilter;
import com.capriccio.CapriccioProductos.security.filters.JwtAuthorizationFilter;
import com.capriccio.CapriccioProductos.security.jwt.JwtUtils;
import com.capriccio.CapriccioProductos.service.ClienteService;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	JwtAuthorizationFilter authorizationFilter;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception{
		
		JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtils);
		jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");
		
		return httpSecurity
				.csrf(csrf -> csrf.disable())
				.cors(cors -> cors.configurationSource(corsConfigurationSource()))
				.authorizeHttpRequests(auth ->{
					auth.requestMatchers(HttpMethod.GET, "/producto").permitAll();
					auth.requestMatchers("/auth/*").permitAll();
					auth.anyRequest().authenticated();
				})
				.userDetailsService(clienteService)
				.sessionManagement(session -> {
					session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				})
				.addFilter(jwtAuthenticationFilter)
				.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	    return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder) {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(clienteService);
	    authProvider.setPasswordEncoder(passwordEncoder);
	    return authProvider;
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOrigin("http://localhost:4200");
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
