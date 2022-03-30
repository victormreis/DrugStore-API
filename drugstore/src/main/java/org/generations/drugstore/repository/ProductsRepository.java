package org.generations.drugstore.repository;

import java.util.List;

import org.generations.drugstore.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
	public List<Products> findAllByNameContainingIgnoreCase(String name);

}
