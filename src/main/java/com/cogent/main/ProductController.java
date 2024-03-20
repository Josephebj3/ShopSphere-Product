package com.cogent.main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;



@RestController
@RequestMapping("/products")
public class ProductController 
{
	@Autowired
	private ProductDaoService productDaoService;
	
	
	@GetMapping("/")
	public List<ProductEntity> getProducts() 
	{
		return productDaoService.getProducts();
	}
	
	@GetMapping("/admin")
	public List<ProductEntity> getAdminProducts(@RequestHeader("Authorization") String token) 
	{
		return productDaoService.getAdminProducts(token);
	}
	
	@PostMapping("/admin")
	public boolean addProduct(@RequestBody ProductEntity productEntity, @RequestHeader("Authorization") String token) 
	{	
		return productDaoService.addProduct(productEntity, token);
	}
	
	@GetMapping("/{productId}")
	public ProductEntity getProduct(@PathVariable int productId) 
	{
		return productDaoService.getProduct(productId);
	}
	
	@PutMapping("/admin/{productId}")
	public ProductEntity updateProduct(@PathVariable int productId, @RequestBody ProductEntity productEntity, @RequestHeader("Authorization") String token) 
	{	
		return productDaoService.updateProduct(productId, productEntity, token);
	}
	
	@DeleteMapping("/admin/{productId}")
	public String deleteProduct(@PathVariable int productId, @RequestHeader("Authorization") String token) 
	{	
		return productDaoService.deleteProduct(productId, token)? "Product deletion success." : "Product deletion Falied";
	}
	
	@GetMapping("/categories/{categoryName}")
	public List<ProductEntity> getProductsByCategory(@PathVariable String categoryName)
	{
		return productDaoService.getProductsByCategory(categoryName);
	}
	
	@PostMapping("/admin/bulk-upload")
	public String addBulkUpload(@RequestBody String file, @RequestHeader("Authorization") String token) {
		
		return productDaoService.addBulkUpload(file, token);
	}
	
	
	
	
	
	
	
}
