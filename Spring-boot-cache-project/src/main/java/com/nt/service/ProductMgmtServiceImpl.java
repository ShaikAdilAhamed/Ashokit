package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.nt.entity.Product;
import com.nt.repository.IProuductRepository;

@Component
public class ProductMgmtServiceImpl implements IProductMgmtService {

	 @Autowired
	private IProuductRepository repository;
	@Override
	
	
	@CachePut(value="prods",key="#product.pid")
	public Product saveProduct(Product product) {
		
		Product prod= repository.save(product);
		return prod;
	}

	@Override
	@Cacheable(value = "prods")
	public List<Product> getAllProducts() {
		
		return repository.findAll();
	}

	@Override
	@Cacheable(value="prods",key="#pid")
	public Product findProudctById(Integer pid) {
	
		//Optional<Product> opt=repository.findById(pid);
		return repository.findById(pid).orElseThrow(()->new IllegalArgumentException("prouduct id not found"));
	}

	@Override
	@CachePut(value="prods", key="#product.pid")
	public Product updateProduct(Product product) throws IllegalArgumentException {
		
		   Optional<Product> opt=repository.findById(product.getPid());
		    if(opt.isPresent()) {
		    	Product prod=repository.save(product);
		    	return prod;
		    }
		throw  new IllegalArgumentException("id not found");
				}

	@Override
	@CacheEvict(value="prods",key="#pid")
	public String  deleteProductById(Integer pid) {

		   Optional<Product> opt=repository.findById(pid);
		    if(opt.isPresent()) {
		    	repository.deleteById(pid);
		    	return "Product deleted";
		    }else {
		    	return "Id not found to delete product";
		    }
	
	}

}
