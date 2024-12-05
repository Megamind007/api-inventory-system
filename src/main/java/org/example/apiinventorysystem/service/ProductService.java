package org.example.apiinventorysystem.service;
import org.example.apiinventorysystem.model.request.ProductRequest;
import org.example.apiinventorysystem.model.request.StockRequest;
import org.example.apiinventorysystem.model.response.ProductResponse;

import java.util.List;

public interface ProductService {
	ProductResponse createProduct(ProductRequest productRequest);
	ProductResponse updateProduct(Integer id, ProductRequest productRequest);
	ProductResponse getProductById(Integer id);
	List<ProductResponse> getAllProduct();
	void deleteProductById(Integer id);
	void addProductToCategory(Integer productId, Integer categoryId);
	ProductResponse addProductToStock(StockRequest stockRequest);
}
