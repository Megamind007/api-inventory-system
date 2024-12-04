package org.example.apiinventorysystem.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity(name = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String payImage;
	private String payType;
	private LocalDate payDate;
	@OneToOne
	private Order order;
}
