package com.Grupo3LaGenerica.Clientes.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Grupo3LaGenerica.Clientes.Model.*;
import com.Grupo3LaGenerica.Clientes.Repository.*;



@RestController
@RequestMapping("/clientes")
public class ClientesAPI {
	@Autowired
	private ClientesRepository clientesRepository;
	
	@PostMapping ("/clientes/crear")
	public void agregarCliente(@RequestBody Clientes cliente) {
		clientesRepository.save(cliente);	
	}
	@GetMapping("/clientes/listar")
	public List<Clientes> findAll(){
		 return clientesRepository.findAll();
	}
	@GetMapping("/clientes/buscar/{cedula}")
	public Optional<Clientes> findById(@PathVariable ("cedula") Integer cedula) {
		return clientesRepository.findById(cedula);
			
	
	}
	@DeleteMapping("/clientes/borrar/{cedula}")
	public void borrar(@PathVariable ("cedula") Integer cedula) {
		clientesRepository.deleteById(cedula);
		
	}
	@PutMapping ("/clientes/actualizar")
	public void update (@RequestBody Clientes cliente) {
		clientesRepository.save(cliente);
		
	}
}



