package org.example.apiinventorysystem.service.serviceimp;

import lombok.RequiredArgsConstructor;
import org.example.apiinventorysystem.model.entity.Category;
import org.example.apiinventorysystem.model.request.CategoryRequest;
import org.example.apiinventorysystem.model.response.CategoryResponse;
import org.example.apiinventorysystem.repository.CategoryRepository;
import org.example.apiinventorysystem.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {
	private final CategoryRepository categoryRepository;

	@Override
	public CategoryResponse createCategory(CategoryRequest categoryRequest) {
		Category category = categoryRepository.save(categoryRequest.toEntity());
		category.setProducts(Collections.emptyList());
		return category.toResponse();
	}

	@Override
	public List<CategoryResponse> getAllCategory() {
		List<Category> lstCategory = categoryRepository.findAll();
		return lstCategory.stream().sorted(Comparator.comparing(Category::getId)).map(Category::toResponse).toList();
	}

	@Override
	public CategoryResponse getCategoryById(Integer id) {
		Category category = categoryRepository.findById(id).orElse(null);
		assert category != null;
		return category.toResponse();
	}

	@Override
	public void deleteCategoryById(Integer id) {
		Category category = categoryRepository.findById(id).orElse(null);
		assert category != null;
		categoryRepository.delete(category);
	}

	@Override
	public CategoryResponse updateCategoryById(Integer id, CategoryRequest categoryRequest) {
		Category category = categoryRepository.findById(id).orElse(null);
		assert category != null;
		category.setId(category.getId());
		category.setCategoryName(categoryRequest.getCategoryName());
		categoryRepository.save(category);
		if(category.getProducts() != null) {
			category.setProducts(category.getProducts());
		}else {
			category.setProducts(Collections.emptyList());
		}
		return category.toResponse();
	}
}
