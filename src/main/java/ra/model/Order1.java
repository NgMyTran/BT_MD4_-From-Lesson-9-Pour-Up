package ra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Order1 {
    private int id;
    private int userId;
    private double totals;
    private Status status = Status.WAITING;
    public enum Status {
        WAITING,
        CONFIRM,
        DELIVERY,
        SUCCESS,
        CANCEL
    }
}
