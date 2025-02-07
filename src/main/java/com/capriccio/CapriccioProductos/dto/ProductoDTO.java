package com.capriccio.CapriccioProductos.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
	private int id;
	private double precio;
	private int cantidad;
	private String nombre;
	private String imagen;
	private String descripccion;
	private byte estado;
	private String categoria;
}
