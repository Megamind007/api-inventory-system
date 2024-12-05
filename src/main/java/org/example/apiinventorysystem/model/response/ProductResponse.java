package org.example.apiinventorysystem.model.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
	private Integer id;
	private String name;
	private String image;
	private String description;
	private Double unitPrice;
	private Integer stock;
	private LocalDate importedAt;
	private LocalDate expiredAt;
}
