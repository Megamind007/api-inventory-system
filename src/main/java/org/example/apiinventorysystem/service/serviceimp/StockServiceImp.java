package org.example.apiinventorysystem.service.serviceimp;

import lombok.RequiredArgsConstructor;
import org.example.apiinventorysystem.repository.StockRepository;
import org.example.apiinventorysystem.service.StockService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockServiceImp implements StockService {
	private final StockRepository stockRepository;
}
