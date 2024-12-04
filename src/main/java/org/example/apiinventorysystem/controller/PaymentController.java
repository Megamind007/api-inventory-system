package org.example.apiinventorysystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.apiinventorysystem.service.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/payments")
@RestController
@RequiredArgsConstructor
public class PaymentController {
	private final PaymentService paymentService;
}
