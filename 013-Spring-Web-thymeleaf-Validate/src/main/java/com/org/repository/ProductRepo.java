package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
