package org.generations.drugstore.repository;

import java.util.List;

import org.generations.drugstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	public List<Category> findAllByTypeContainingIgnoreCase(String type);

}
