package ra.orm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int id;
    @Column(columnDefinition = "unique")
    private String productName;
    private String description;
    private double price;
    private int stock;
}
