package lk.ijse.Tea.model.tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class inventoryTm {

    private int category_id;
    private String category_name;
    private int quantity;
    private int harvest_no;
    private String unit_price;


}
