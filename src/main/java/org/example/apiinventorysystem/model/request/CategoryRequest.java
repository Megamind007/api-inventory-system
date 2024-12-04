package org.example.apiinventorysystem.model.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.apiinventorysystem.model.entity.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequest {
	private String categoryName;
	private String description;

	public Category toEntity(){
		return Category.builder().categoryName(categoryName).description(description).build();
	}
}
