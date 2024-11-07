package com.frab.reactor_webflux.models.repository;

import com.frab.reactor_webflux.models.documents.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductoRepository extends ReactiveMongoRepository<Producto, String> {

}
