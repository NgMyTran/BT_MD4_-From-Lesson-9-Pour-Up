package ra.bt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
private int id;
private String name;
private double price;
private int stock;
private boolean status;
private Category category;//chọn categoryId thuộc về xếp loại đó

    public Integer getCategoryId() {
        return category != null ? category.getId() : null;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", status=" + status +
                ", category=" + category +
                '}';
    }
}
