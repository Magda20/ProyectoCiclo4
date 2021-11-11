package com.Grupo3LaGenerica.Clientes.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Grupo3LaGenerica.Clientes.Model.Clientes;


@Repository
public interface ClientesRepository  extends MongoRepository <Clientes, Integer>{

}
