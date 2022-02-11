package com.anthonycardenasexamen.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anthonycardenasexamen.app.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>  {

}
