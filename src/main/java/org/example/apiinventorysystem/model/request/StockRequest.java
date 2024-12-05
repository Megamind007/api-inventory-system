package org.example.apiinventorysystem.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockRequest {
	private Integer productId;
	private Integer stock;
	private LocalDate expiredAt;
}
