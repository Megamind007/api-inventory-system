package org.example.apiinventorysystem.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.apiinventorysystem.model.request.ProductRequest;
import org.example.apiinventorysystem.model.response.ApiResponse;
import org.example.apiinventorysystem.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/api/v1/products")
@RestController
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	@PostMapping
	@Operation(summary = "create product")
	public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest) {
		ApiResponse<?> response = ApiResponse.builder()
				.message("Create product successful")
				.payload(productService.createProduct(productRequest))
				.status(HttpStatus.CREATED)
				.statusCode(HttpStatus.CREATED.value())
				.timestamp(LocalDateTime.now())
				.build();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	@Operation(summary = "update product")
	public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody ProductRequest productRequest) {
		ApiResponse<?> response = ApiResponse.builder()
				.message("Update product successful")
				.payload(productService.updateProduct(id,productRequest))
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.timestamp(LocalDateTime.now())
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	@Operation(summary = "get product by id")
	public ResponseEntity<?> getProductById(@PathVariable Integer id) {
		ApiResponse<?> response = ApiResponse.builder()
				.message("Get product successful")
				.payload(productService.getProductById(id))
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.timestamp(LocalDateTime.now())
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping
	@Operation(summary = "get all product")
	public ResponseEntity<?> getAllProduct() {
		ApiResponse<?> response = ApiResponse.builder()
				.message("Get all product successful")
				.payload(productService.getAllProduct())
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.timestamp(LocalDateTime.now())
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "delete product")
	public ResponseEntity<?> deleteProductById(@PathVariable Integer id) {
		productService.deleteProductById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/{productId}/category/{categoryId}")
	@Operation(summary = "Add product to category")
	public ResponseEntity<?> addProductToCategory(@PathVariable Integer productId, @PathVariable Integer categoryId) {
		productService.addProductToCategory(productId,categoryId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
