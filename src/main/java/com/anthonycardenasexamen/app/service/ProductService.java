package com.anthonycardenasexamen.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.anthonycardenasexamen.app.entity.Product;

public interface ProductService {
	
	public Iterable<Product> findAll();
	
	public Page<Product> findAll(Pageable pageable);
	
	public Optional<Product> findById(Long codigo);
	
	public Product save(Product product);
	
	public void deleteById(Long codigo);

}
