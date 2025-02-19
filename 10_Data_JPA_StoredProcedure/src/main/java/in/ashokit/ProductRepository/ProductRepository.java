package in.ashokit.ProductRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
//the (stored procedure) query in db we have added is this
	/*
	 * ( function )
	 * 
	 * DELIMITER $$ 
	 * Create procedure geProducts()
	 *  BEGIN
	 *   select * from product;
	 *  END$$
	 * DELIMITER ; 
	 * 
	 *( funtion call ) 
	 * call getProducts();
	 */
	
	//In DB we created a stored procedure we are calling that
	@Query(value="call getProducts()", nativeQuery = true)
	public List<Product> getAllProducts();
}
