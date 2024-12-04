package org.example.apiinventorysystem.model.response;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderProductResponse {
    private String name;
    private Integer quantity;
    private Double unitPrice;
    private Double totalAmount;
}
