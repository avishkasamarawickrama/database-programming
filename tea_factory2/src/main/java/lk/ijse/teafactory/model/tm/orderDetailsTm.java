package lk.ijse.teafactory.model.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class orderDetailsTm {


    private int customer_id;
    private int item_id;
    private int qty;
    private Double amount;
    private String status;

}