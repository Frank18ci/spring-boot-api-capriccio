package com.capriccio.CapriccioProductos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capriccio.CapriccioProductos.dto.ProductoDTO;
import com.capriccio.CapriccioProductos.repository.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	private ProductoRepository productoRepository;
	public List<ProductoDTO> listar(){
		List<ProductoDTO> productos = productoRepository.findAll().stream().
				map(productoEntity -> {
					ProductoDTO productoDTO = new ProductoDTO();
					 productoDTO.setId(productoEntity.getId());
				        productoDTO.setPrecio(productoEntity.getPrecio());
				        productoDTO.setCantidad(productoEntity.getCantidad());
				        productoDTO.setNombre(productoEntity.getNombre());
				        productoDTO.setImagen(productoEntity.getImagen());
				        productoDTO.setDescripccion(productoEntity.getDescripccion());
				        productoDTO.setEstado(productoEntity.getEstado());
				        productoDTO.setCategoria(productoEntity.getCategoria().getDescripccion());
				        return productoDTO;
				}).collect(Collectors.toList());
		return productos;
	}
}
