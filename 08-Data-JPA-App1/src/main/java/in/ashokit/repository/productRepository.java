package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Product;

public interface productRepository extends JpaRepository<Product, Integer>{

}
