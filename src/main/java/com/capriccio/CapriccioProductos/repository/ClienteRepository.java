package com.capriccio.CapriccioProductos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capriccio.CapriccioProductos.model.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	Optional<Cliente> findByUsername(String username);
}
