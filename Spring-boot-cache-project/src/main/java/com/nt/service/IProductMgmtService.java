package com.nt.service;

import java.util.List;


import com.nt.entity.Product;

public interface IProductMgmtService {

	public Product saveProduct(Product product);
	public List<Product> getAllProducts();
	public Product findProudctById(Integer pid);
	public Product updateProduct(Product product) throws IllegalArgumentException;
	public String deleteProductById(Integer pid);
}
