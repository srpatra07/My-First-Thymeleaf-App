package com.org.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
