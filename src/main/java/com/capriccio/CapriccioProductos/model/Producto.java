package com.capriccio.CapriccioProductos.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double precio;
	private int cantidad;
	private String nombre;
	private String imagen;
	private String descripccion;
	private byte estado;
	@ManyToOne
	private Categoria categoria;
	@OneToMany(mappedBy = "producto")
	private List<DetalleVenta> detalleVentas;
}
