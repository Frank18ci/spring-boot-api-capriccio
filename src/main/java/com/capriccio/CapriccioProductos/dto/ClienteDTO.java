package com.capriccio.CapriccioProductos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
	private int id;
	private String nombres;
	private String apellidos;
	private String username;
	private String password;
	private String telefono;
	private byte estado;
}
