package org.example.apiinventorysystem.model.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity(name = "stock_product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StockProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "stock_id")
	private Stock stock;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
}
