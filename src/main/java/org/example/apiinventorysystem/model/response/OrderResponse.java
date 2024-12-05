package org.example.apiinventorysystem.model.response;
import lombok.*;
import org.example.apiinventorysystem.enums.PaymentStatus;
import org.example.apiinventorysystem.model.entity.Order;
import org.example.apiinventorysystem.model.entity.User;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderResponse {
	private Integer id;
	private PaymentStatus status;
	private Double totalPrice;
	private LocalDate orderDate;
	private List<OrderProductResponse> products;
	private User user;
}
