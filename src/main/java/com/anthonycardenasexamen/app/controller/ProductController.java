package com.anthonycardenasexamen.app.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anthonycardenasexamen.app.entity.Product;

import com.anthonycardenasexamen.app.service.ProductService;



@RestController
@RequestMapping("/api/products")
public class ProductController {

   
	private  ProductService productService;
	

	
	//Crear un nuevo producto
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Product product) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
		
	}
	//leer producto
	@GetMapping("/{codigo}")
	public ResponseEntity<?> read(@PathVariable (value = "codigo") Long productCodigo){
		Optional<Product> oProduct = productService.findById(productCodigo);
		
		if(!oProduct.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oProduct);
		
	}
	
	//Actualizar producto
	
	@PutMapping("/{codigo}")
	
	public ResponseEntity<?> update (@RequestBody Product productDetails, @PathVariable (value ="codigo")Long productCodigo){
	
	Optional<Product> product = productService.findById(productCodigo);
	
	if(!product.isPresent()) {
		return ResponseEntity.notFound().build();
	}
	

	product.get().setDescripcion(productDetails.getDescripcion());
	product.get().setCantidad(productDetails.getCantidad());
	product.get().setPrecio(productDetails.getPrecio());
	
	
	
	
	return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product.get()));
	
	}
	
	//Borrar Producto
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<?> delete (@PathVariable(value = "codigo") Long productCodigo){
		if(!productService.findById(productCodigo).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		productService.deleteById(productCodigo);
		return ResponseEntity.ok().build();
	}
	
	//leer los productos
	
	@GetMapping
	public List<Product> readAll(){
		
		List<Product> products = StreamSupport
				.stream(productService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return products;
		
		
	}
}