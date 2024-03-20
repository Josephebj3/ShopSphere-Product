package com.cogent.main;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Integer>
{

	List<ProductEntity> findByCategory(String categoryName);

}
