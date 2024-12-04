package org.example.apiinventorysystem.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Boolean status;
	private Double totalPrice;
	@CreatedDate
	private LocalDate orderDate;
	@ManyToOne
	@JoinColumn(name = "users_id")
	private User user;

	@OneToMany(mappedBy = "order")
	private List<OrderProduct> orderProducts;

	@OneToOne
	private Payment payment;
}
