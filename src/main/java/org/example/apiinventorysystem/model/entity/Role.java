package org.example.apiinventorysystem.model.entity;
import jakarta.persistence.*;
import lombok.*;


@Entity(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String role;
    private Integer userId;
}
