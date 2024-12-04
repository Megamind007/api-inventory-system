package org.example.apiinventorysystem.model.entity;
import jakarta.persistence.*;
import lombok.*;
import org.example.apiinventorysystem.model.response.CategoryResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Entity(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String categoryName;
	private String description;
	@OneToMany
	@JoinColumn(name = "category_id")
	private List<Product> products = new ArrayList<>();
	public CategoryResponse toResponse() {
		return CategoryResponse.builder().id(id).categoryName(categoryName).description(description).products(products.stream().map(Product::toResponse).toList()).build();
	}
}
