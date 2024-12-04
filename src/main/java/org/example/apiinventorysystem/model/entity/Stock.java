package org.example.apiinventorysystem.model.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;
import java.util.List;
@Entity(name = "stocks")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private Integer quantity;
    private LocalDate importedAt;
    private LocalDate exportedAt;
    @OneToMany(mappedBy = "stock")
    private List<StockProduct> stockProducts;
}
