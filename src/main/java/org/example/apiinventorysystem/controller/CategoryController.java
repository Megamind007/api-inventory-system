package org.example.apiinventorysystem.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.apiinventorysystem.model.request.CategoryRequest;
import org.example.apiinventorysystem.model.response.ApiResponse;
import org.example.apiinventorysystem.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
	private final CategoryService categoryService;
	@PostMapping
	@Operation(summary = "create category")
	public ResponseEntity<?> createCategory(@RequestBody CategoryRequest categoryRequest) {
		ApiResponse<?> response = ApiResponse.builder()
				.message("Category created successfully")
				.payload(categoryService.createCategory(categoryRequest))
				.status(HttpStatus.CREATED)
				.statusCode(HttpStatus.CREATED.value())
				.timestamp(LocalDateTime.now())
				.build();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	@GetMapping
	@Operation(summary = "get all category")
	public ResponseEntity<?> getAllCategory() {
		ApiResponse<?> response = ApiResponse.builder()
				.message("Category get all successfully")
				.payload(categoryService.getAllCategory())
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.timestamp(LocalDateTime.now())
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	@Operation(summary = "update category by id")
	public ResponseEntity<?> updateCategoryById(@PathVariable Integer id,@RequestBody CategoryRequest categoryRequest) {
		ApiResponse<?> response = ApiResponse.builder()
				.message("Category update successfully")
				.payload(categoryService.updateCategoryById(id,categoryRequest))
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.timestamp(LocalDateTime.now())
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@Operation(summary = "get category by id")
	public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
		ApiResponse<?> response = ApiResponse.builder()
				.message("Category get successfully")
				.payload(categoryService.getCategoryById(id))
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.timestamp(LocalDateTime.now())
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	@Operation(summary = "delete category by id")
	public ResponseEntity<?> deleteCategoryById(@PathVariable Integer id) {
		categoryService.deleteCategoryById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
