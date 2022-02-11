package com.anthonycardenasexamen.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anthonycardenasexamen.app.entity.Product;
import com.anthonycardenasexamen.app.repository.ProductRepository;

public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAll(Pageable pageable) {
		
		return productRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Product> findById(Long codigo) {
		
		return productRepository.findById(codigo);
	}

	@Override
	@Transactional
	public Product save(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	@Transactional
	public void deleteById(Long codigo) {
		productRepository.deleteById(codigo);

}
}
