package org.example.apiinventorysystem.model.response;
import lombok.*;
import org.example.apiinventorysystem.model.entity.Category;
import org.example.apiinventorysystem.model.entity.Product;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CategoryResponse {
	private Integer id;
	private String categoryName;
	private String description;
	private List<ProductResponse> products;

}
