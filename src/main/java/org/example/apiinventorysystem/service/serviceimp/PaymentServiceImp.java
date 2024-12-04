package org.example.apiinventorysystem.service.serviceimp;

import lombok.RequiredArgsConstructor;
import org.example.apiinventorysystem.repository.PaymentRepository;
import org.example.apiinventorysystem.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImp implements PaymentService {
	private final PaymentRepository paymentRepository;
}
