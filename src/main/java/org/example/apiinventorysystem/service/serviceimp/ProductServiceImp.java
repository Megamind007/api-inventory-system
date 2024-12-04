package org.example.apiinventorysystem.service.serviceimp;
import lombok.RequiredArgsConstructor;
import org.example.apiinventorysystem.model.entity.Category;
import org.example.apiinventorysystem.model.entity.Product;
import org.example.apiinventorysystem.model.request.ProductRequest;
import org.example.apiinventorysystem.model.response.ProductResponse;
import org.example.apiinventorysystem.repository.CategoryRepository;
import org.example.apiinventorysystem.repository.ProductRepository;
import org.example.apiinventorysystem.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;
	private final CategoryRepository categoryRepository;

	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {
		Product product = productRepository.save(productRequest.toEntity());
		return product.toResponse();
	}

	@Override
	public ProductResponse updateProduct(Integer id, ProductRequest productRequest) {
		Product product = productRepository.findById(id).orElse(null);
		assert product != null;
		modelMapper.map(productRequest, product);
		return modelMapper.map(productRepository.save(product), ProductResponse.class);
	}

	@Override
	public ProductResponse getProductById(Integer id) {
		Product product = productRepository.findById(id).orElse(null);
		assert product != null;
		return product.toResponse();
	}

	@Override
	public List<ProductResponse> getAllProduct() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(Product::toResponse).toList();
	}

	@Override
	public void deleteProductById(Integer id) {
		Product product = productRepository.findById(id).orElse(null);
		assert product != null;
		productRepository.delete(product);
	}

	@Override
	public void addProductToCategory(Integer productId, Integer categoryId) {
		Product product = productRepository.findById(productId).orElse(null);
		Category category = categoryRepository.findById(categoryId).orElse(null);
		assert product != null;
		assert category != null;
		product.setCategory(category);
		productRepository.save(product);
	}

}
