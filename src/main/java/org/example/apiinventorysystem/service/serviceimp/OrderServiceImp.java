package org.example.apiinventorysystem.service.serviceimp;

import lombok.RequiredArgsConstructor;
import org.example.apiinventorysystem.enums.PaymentStatus;
import org.example.apiinventorysystem.model.entity.Order;
import org.example.apiinventorysystem.model.entity.OrderProduct;
import org.example.apiinventorysystem.model.entity.Product;
import org.example.apiinventorysystem.model.entity.User;
import org.example.apiinventorysystem.model.request.OrderRequest;
import org.example.apiinventorysystem.model.response.OrderProductResponse;
import org.example.apiinventorysystem.model.response.OrderResponse;
import org.example.apiinventorysystem.repository.OrderProductRepository;
import org.example.apiinventorysystem.repository.OrderRepository;
import org.example.apiinventorysystem.repository.ProductRepository;
import org.example.apiinventorysystem.repository.UserRepository;
import org.example.apiinventorysystem.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService {
	private final OrderProductRepository orderProductRepository;
	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	private final OrderRepository orderRepository;
	private final ModelMapper modelMapper;

	@Override
	public OrderResponse createOrder(List<OrderRequest> orderRequest) {
		User user = userRepository.findById(1).orElse(null);
		List<OrderProductResponse> orderProductResponse = new ArrayList<>();
		//order
		Order order = orderRepository.save(Order.builder()
				.status(PaymentStatus.PENDING)
				.orderDate(LocalDate.now())
				.build());
		AtomicReference<Double> totalAmount = new AtomicReference<>(0.0);
		orderRequest.forEach(req -> {
			Product pro = productRepository.findById(req.getProductId()).orElse(null);
			assert pro != null;
			if (pro.getStock() < req.getQuantity()) {
				throw new RuntimeException("Stock is too small");
			}
			// order product
			OrderProduct orderProduct = OrderProduct.builder()
					.product(pro)
					.order(order)
					.quantity(req.getQuantity())
					.build();
			orderProductRepository.save(orderProduct);

			double total = pro.getUnitPrice() * req.getQuantity();
			totalAmount.updateAndGet(v -> v + total);

			// product
			pro.setStock(pro.getStock() - req.getQuantity());
			productRepository.save(pro);

			// set product response
			orderProductResponse.add(OrderProductResponse.builder()
					.name(pro.getName())
					.quantity(req.getQuantity())
					.unitPrice(pro.getUnitPrice())
					.totalAmount(total)
					.build());
		});
		order.setTotalPrice(totalAmount.get());
		orderRepository.save(order);
		//set response
		return OrderResponse.builder()
				.id(order.getId())
				.status(order.getStatus())
				.orderDate(order.getOrderDate())
				.totalPrice(order.getTotalPrice())
				.products(orderProductResponse)
				.user(user)
				.build();
	}
}
