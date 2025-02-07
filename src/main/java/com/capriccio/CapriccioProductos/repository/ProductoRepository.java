package com.capriccio.CapriccioProductos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capriccio.CapriccioProductos.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
