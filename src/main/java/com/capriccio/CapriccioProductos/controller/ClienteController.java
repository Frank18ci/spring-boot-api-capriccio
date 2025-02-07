package com.capriccio.CapriccioProductos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capriccio.CapriccioProductos.dto.ClienteDTO;
import com.capriccio.CapriccioProductos.model.Cliente;
import com.capriccio.CapriccioProductos.repository.ClienteRepository;

@RestController
@RequestMapping("/auth")
public class ClienteController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(@RequestBody ClienteDTO clienteDTO){
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		cliente.setNombres(clienteDTO.getNombres());
		cliente.setApellidos(clienteDTO.getApellidos());
		cliente.setUsername(clienteDTO.getUsername());
		cliente.setPassword(passwordEncoder.encode(clienteDTO.getPassword()));
		cliente.setTelefono(clienteDTO.getTelefono());
		clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
		}
	@GetMapping("/perfil")
	public String getPerfilUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Cliente cliente = (Cliente) authentication.getPrincipal();
        return "Bienvenido, " + cliente.getUsername() + ". Tu correo es " + cliente.getPassword();
	}
	
}
