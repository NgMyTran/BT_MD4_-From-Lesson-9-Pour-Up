package ra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;
    private Date created;
    private String image;
    private boolean status;

}
