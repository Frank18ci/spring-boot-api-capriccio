package com.capriccio.CapriccioProductos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capriccio.CapriccioProductos.service.ProductoService;

@RestController
@RequestMapping("/producto")
@CrossOrigin
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	@GetMapping
	public ResponseEntity<?> getProductos(){
		return ResponseEntity.ok(productoService.listar());
	}
}
