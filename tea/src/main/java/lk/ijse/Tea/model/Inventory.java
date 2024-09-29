package lk.ijse.Tea.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inventory {

    private int category_id;
    private String category_name;
    private int quantity;
    private int harvest_no;
    private String unit_price;


}
