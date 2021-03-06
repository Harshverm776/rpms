package com.ct.microservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.microservice.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>
{
//	@Query("from Product where LOWER('name')=:LOWER(name)")
	public Optional<Product> findByName(String name);

}
