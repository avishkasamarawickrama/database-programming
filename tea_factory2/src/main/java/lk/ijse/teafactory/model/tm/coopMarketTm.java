package lk.ijse.teafactory.model.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class coopMarketTm {

    private int  item_id  ;
    private String item_name;
    private int item_qty;
    private Double sell_price;
    private String status;

}
