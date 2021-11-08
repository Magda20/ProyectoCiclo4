package co.edu.lagenerica.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.lagenerica.repository.*;
import co.edu.lagenerica.model.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductoAPI {
	
	@Autowired
	private ProductoRepository productosDAO;
	
	@PostMapping("/productos")
	public void crearProducto(@RequestBody Producto producto) {
		productosDAO.save(producto);
	}

	@GetMapping("/productos")
	public ArrayList<Producto> obtenerTodosProductos(){
		return (ArrayList<Producto>) productosDAO.findAll();		
	}

	@GetMapping("/productos/{codigo_producto}")
	public Optional<Producto> obtenerProductoPorId(@PathVariable ("codigo_producto") long codigo_producto){
		return productosDAO.findById(codigo_producto);	
	}
	
	@DeleteMapping("/productos/{codigo_producto}")
	public void eliminarProducto(@PathVariable("codigo_producto") long codigo_producto) {
		productosDAO.deleteById(codigo_producto);
	}
		
	@PutMapping("/productos")
	public void actualizarProducto(@RequestBody Producto producto) {
		Optional<Producto> productoViejoOpcional = productosDAO.findById(producto.getCodigo_producto());
		if(productoViejoOpcional.isPresent()) {
			Producto productoViejo = productoViejoOpcional.get();
			productoViejo.setNombre_producto(producto.getNombre_producto());
			productoViejo.setNit_proveedor(producto.getNit_proveedor());
			productoViejo.setPrecio_compra(producto.getPrecio_compra());
			productoViejo.setIva_compra(producto.getIva_compra());
			productoViejo.setPrecio_venta(producto.getPrecio_venta());
			productosDAO.save(productoViejo);
		}
	}
	
	
}



