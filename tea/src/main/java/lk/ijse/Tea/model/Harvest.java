package lk.ijse.Tea.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Harvest {

    private int harvest_no;
    private int field_id;
    private int quantity;
    private String date;


}
