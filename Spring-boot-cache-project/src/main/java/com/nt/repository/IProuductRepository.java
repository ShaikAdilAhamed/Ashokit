package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Product;

public interface  IProuductRepository extends JpaRepository<Product, Integer>{

}
