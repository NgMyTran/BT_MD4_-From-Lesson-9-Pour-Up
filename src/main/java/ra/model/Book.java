package ra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Book {
    private int id;
    private int category_id;
    private String name;
    private double price;
    private int stock;
    private int totalPages;
    private int yearCreated;
    private String author;
    private boolean status;


}
