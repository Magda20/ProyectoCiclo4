package co.edu.lagenerica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import co.edu.lagenerica.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, Long>{
	
}