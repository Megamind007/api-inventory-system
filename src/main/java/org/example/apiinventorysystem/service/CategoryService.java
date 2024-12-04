package org.example.apiinventorysystem.service;

import org.example.apiinventorysystem.model.request.CategoryRequest;
import org.example.apiinventorysystem.model.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
	CategoryResponse createCategory(CategoryRequest categoryRequest);
	List<CategoryResponse> getAllCategory();
	CategoryResponse getCategoryById(Integer id);
	void deleteCategoryById(Integer id);
	CategoryResponse updateCategoryById(Integer id, CategoryRequest categoryRequest);
}
