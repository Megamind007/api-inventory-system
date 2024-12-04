package org.example.apiinventorysystem.service.serviceimp;

import lombok.RequiredArgsConstructor;
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
import java.util.Optional;

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
		OrderResponse orderResponse = new OrderResponse();
		Optional<User> user = userRepository.findById(1);
		orderRequest.forEach(i -> {
			// find product
			Product product = productRepository.findById(i.getProductId()).orElse(null);
			assert product != null;
			// order
			Order order = new Order();
			order.setStatus(false);
			order.setOrderDate(LocalDate.now());
			order.setUser(user.get());
			order = orderRepository.save(order);
			// order product
			OrderProduct op = new OrderProduct();
			op.setOrderQuantity(i.getQuantity());
			op.setProduct(product);
			op.setOrder(order);
			op.setProduct(product);
			op = orderProductRepository.save(op);

			List<OrderProductResponse> lst = new ArrayList<>();

			OrderProductResponse opr = new OrderProductResponse();
			opr.setName(product.getName());
			opr.setQuantity(i.getQuantity());
			opr.setUnitPrice(product.getUnitPrice());

			opr.setTotalAmount(i.getQuantity()*product.getUnitPrice());
			lst.forEach(data->{
				lst.add(data);
			});
			orderResponse.setUser(modelMapper.map(user, User.class));
			orderResponse.setTotalPrice(opr.getTotalAmount());
			orderResponse.setProducts(lst);
		});
	
		return orderResponse;
	}
}
