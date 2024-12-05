package org.example.apiinventorysystem.controller;


import lombok.RequiredArgsConstructor;
import org.example.apiinventorysystem.model.request.OrderRequest;
import org.example.apiinventorysystem.model.response.ApiResponse;
import org.example.apiinventorysystem.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api/v1/orders")
@RestController
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;

	@PostMapping
	public ResponseEntity<?> createOrder(@RequestBody List<OrderRequest> orderRequest) {
		return new ResponseEntity<>(ApiResponse.builder()
				.message("Order product successful")
				.payload(orderService.createOrder(orderRequest))
				.status(HttpStatus.CREATED)
				.statusCode(HttpStatus.CREATED.value())
				.timestamp(LocalDateTime.now())
				.build(), HttpStatus.CREATED);
	}
}
