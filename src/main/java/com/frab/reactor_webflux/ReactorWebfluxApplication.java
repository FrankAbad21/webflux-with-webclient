package com.frab.reactor_webflux;

import com.frab.reactor_webflux.models.documents.Producto;
import com.frab.reactor_webflux.models.repository.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.util.Date;

@SpringBootApplication
public class ReactorWebfluxApplication implements CommandLineRunner {

	@Autowired
	private ProductoRepository productoRepository;

	private static final Logger Log = LoggerFactory.getLogger(ReactorWebfluxApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ReactorWebfluxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Flux.just(Producto.builder().name("Mi primer producto").price(230.5).build(),
				Producto.builder().name("TV full HD").price(500D).build(),
				Producto.builder().name("Computadora Intel").price(350.5D).build())
		.flatMap(prod -> {
			prod.setCreateAt(new Date());
			return productoRepository.save(prod);
		})
		.subscribe(prod -> System.out.println("Nombre: " + prod.getName() + " - Precio: "+ prod.getPrice()));
	}
}
