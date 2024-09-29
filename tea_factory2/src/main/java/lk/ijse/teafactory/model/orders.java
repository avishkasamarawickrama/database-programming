package lk.ijse.teafactory.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class orders {


    private int order_id;
    private Date order_date;
    private int order_quantity;
    private int order_price;
    private int bag_id;
    private int item_id;

}