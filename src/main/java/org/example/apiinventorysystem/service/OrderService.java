package org.example.apiinventorysystem.service;

import org.example.apiinventorysystem.model.request.OrderRequest;
import org.example.apiinventorysystem.model.response.OrderResponse;

import java.util.List;

public interface OrderService {
	OrderResponse createOrder(List<OrderRequest> orderRequest);
}
