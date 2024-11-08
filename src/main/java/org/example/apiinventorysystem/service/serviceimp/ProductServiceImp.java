package org.example.apiinventorysystem.service.serviceimp;


import lombok.RequiredArgsConstructor;
import org.example.apiinventorysystem.repository.ProductRepository;
import org.example.apiinventorysystem.service.ProductService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
	private final ProductRepository productRepository;
}
