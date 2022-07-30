package com.ricoom.techie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricoom.techie.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findProductByproductName(String productname);
}
