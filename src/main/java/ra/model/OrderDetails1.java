package ra.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails1 {
    private int id;
    private int orderId;
    private int productId;
    private int quantity;
    private double price;
    private Product1 product;
}