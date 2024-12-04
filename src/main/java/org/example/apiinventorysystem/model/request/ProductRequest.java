package org.example.apiinventorysystem.model.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.apiinventorysystem.model.entity.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
	private String name;
	private String image;
	private Double unitPrice;
	private String description;
	private Integer quantity;
	public Product toEntity(){
		return Product.builder().name(name).image(image).unitPrice(unitPrice).description(description).quantity(quantity).build();
	}
}
