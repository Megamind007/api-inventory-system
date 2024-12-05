package org.example.apiinventorysystem.model.entity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String gender;
	private String telephone;
	private String address;
	private String email;
	private String password;
	@OneToMany(mappedBy = "user")
	private List<Order> orders;
	private LocalDate createdAt;
	private LocalDate updatedAt;

}
