package org.example.apiinventorysystem.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.apiinventorysystem.enums.PaymentStatus;
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
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	private Double totalPrice;
	@CreatedDate
	private LocalDate orderDate;
	@ManyToOne
	@JoinColumn(name = "users_id")
	private User user;
	@OneToMany(mappedBy = "order")
	private List<OrderProduct> orderProducts;
}
