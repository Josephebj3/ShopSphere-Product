package com.cogent.main;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDaoService 
{
	@Autowired
	private ProductEntityRepository productEntityRepository;
	
	@Autowired
	private UserClient userClient;
	
	
	public List<ProductEntity> getProducts() 
	{
		List<ProductEntity> peList = productEntityRepository.findAll();
//		List<ProductDao> pdList = new LinkedList<ProductDao>();
//		
//		for(ProductEntity data: peList) 
//		{
//			pdList.add(ProductDao.builder()
//				.name(data.getName())
//				.description(data.getDescription())
//				.price(data.getPrice())
//				.category(data.getCategory())
//				.build());
//		}
		
		return peList;
	}


	public boolean addProduct(ProductEntity productEntity, String token) 
	{
		if(!userClient.validAdminToken(token)) return false;
		productEntityRepository.save(productEntity);
		return true;
	}


	public ProductEntity getProduct(int productId)
	{
		return productEntityRepository.findById(productId).get();
	}
	
	public ProductEntity updateProduct(int productId, ProductEntity productEntity, String token) 
	{
		if(!userClient.validAdminToken(token)) return null;
		productEntity.setId(productId);
		return productEntityRepository.save(productEntity);
	}

	public boolean deleteProduct(int productId, String token)
	{
		if(productEntityRepository.findById(productId).isEmpty()) return false;
		if(!userClient.validAdminToken(token)) return false;
		productEntityRepository.deleteById(productId);
		return productEntityRepository.findById(productId).isEmpty();
	}

	public List<ProductEntity> getProductsByCategory(String categoryName) 
	{
		return productEntityRepository.findByCategory(categoryName);
	}


	public String addBulkUpload(String file, String token) 
	{
		if(!userClient.validAdminToken(token)) return null;
		return null;
	}

	public List<ProductEntity> getAdminProducts(String token) 
	{
		if(!userClient.validAdminToken(token)) return null;
		return productEntityRepository.findAll();
	}


	


	


	
	
}
