package lk.ijse.Tea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class OrderDetail {

    private int order_id;
    private int quantity;
    private double amount;
    private int category_id;


}


