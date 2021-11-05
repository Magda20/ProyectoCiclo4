package co.edu.lagenerica.controller;

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

import co.edu.lagenerica.model.Clientes;
import co.edu.lagenerica.model.Productos;
import co.edu.lagenerica.repository.ClientesRepository;



@RestController
@RequestMapping("/clientes")
public class ClientesAPI {
	
		@Autowired
		private ClientesRepository clientesRepository;
		
		@PostMapping ("/crear/clientes")
		public void agregarCliente(@RequestBody Clientes cliente) {
			clientesRepository.save(cliente);
		}
		@GetMapping("/listar/clientes")
		public List<Clientes> findAll(){
			 return clientesRepository.findAll();
		}
		@GetMapping("/buscar/clientes/{cedula}")
		public Clientes findById(@PathVariable String cedula) {
			return clientesRepository.findById(cedula).get();
		/*@GetMapping("/buscar/{codigo_producto}")
			public Optional<Productos> buscar(@PathVariable ("codigo_producto") long codigo_producto){
				return productosDAO.findById(codigo_producto);	*/	
			
		}
		@DeleteMapping("/borrar/clientes/{cedula}")
		public void deleteById(@PathVariable String cedula) {
			clientesRepository.deleteById(cedula);
			
		}
		@PutMapping ("/actualizar/clientes")
		public void update (@RequestBody Clientes cliente) {
			clientesRepository.save(cliente);
			
		}
}
