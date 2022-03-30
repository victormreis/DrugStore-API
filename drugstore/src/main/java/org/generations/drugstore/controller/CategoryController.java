package org.generations.drugstore.controller;

import java.util.List;

import org.generations.drugstore.model.Category;
import org.generations.drugstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*")
public class CategoryController {

	@Autowired
	private CategoryRepository repo;

	@GetMapping
	public ResponseEntity<List<Category>> getAll() {
		return ResponseEntity.ok(repo.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Category> getById(@PathVariable Long id) {
		return repo.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/tipo/{type}")
	public ResponseEntity<List<Category>> getByType(@PathVariable String type) {
		return ResponseEntity.ok(repo.findAllByTypeContainingIgnoreCase(type));
	}

	@PostMapping
	public ResponseEntity<Category> post(@RequestBody Category category) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(category));
	}

	@PutMapping
	public ResponseEntity<Category> put(@RequestBody Category category) {
		return ResponseEntity.status(HttpStatus.OK).body(repo.save(category));
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
