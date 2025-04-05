package com.nt.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Product;
import com.nt.service.IProductMgmtService;

@RestController
@RequestMapping("/product-api")
//@RequiredArgsConstructor
public class ProductRestController {

	 @Autowired
	private IProductMgmtService service;
	
    @PostMapping("/save")
    public ResponseEntity<Product> RegisterProduct(@RequestBody Product product){
	    Product prod=service.saveProduct(product);
     	return new ResponseEntity<Product>(prod,HttpStatus.CREATED);
}	
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> fetchAllProducts(){
    	List<Product> list=service.getAllProducts();
    	return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
    }
    
    @GetMapping("/find/{pid}")
    public ResponseEntity<Product> findProductById(@PathVariable Integer pid){
    	Product prod=service.findProudctById(pid);
    	return new ResponseEntity<Product>(prod,HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Product> updateProductById(@RequestBody Product product){
    	
     Product prod=service.updateProduct(product);
    	return new ResponseEntity<Product>(prod,HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{pid}")
    public ResponseEntity<String> deleteProductById(@PathVariable Integer pid){
    	
    	String message=service.deleteProductById(pid);
    	return new ResponseEntity<String>(message,HttpStatus.OK);
    }
}
