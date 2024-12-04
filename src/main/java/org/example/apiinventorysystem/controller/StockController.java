package org.example.apiinventorysystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.apiinventorysystem.service.StockService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stocks")
@RequiredArgsConstructor
public class StockController {
	private final StockService stockService;
	
}
