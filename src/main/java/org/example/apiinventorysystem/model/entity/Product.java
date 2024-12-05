package org.example.apiinventorysystem.model.entity;
import jakarta.persistence.*;
import lombok.*;
import org.example.apiinventorysystem.model.response.ProductResponse;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String image;
	private String description;
	private Double unitPrice;
	private Integer stock;
	private LocalDate importedAt;
	private LocalDate expiredAt;
	@OneToMany(mappedBy = "product")
	private List<OrderProduct> orderProducts;
	@ManyToOne
	private Category category;
	public ProductResponse toResponse() {
		return ProductResponse.builder().id(id).name(name).image(image).description(description).unitPrice(unitPrice).stock(stock).expiredAt(expiredAt).importedAt(LocalDate.now()).build();
	}
}
