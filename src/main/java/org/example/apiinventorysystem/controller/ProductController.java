package org.example.apiinventorysystem.controller;


import lombok.RequiredArgsConstructor;
import org.example.apiinventorysystem.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
}
