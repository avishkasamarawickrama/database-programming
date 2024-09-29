package lk.ijse.Tea.model.tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HarvestTm {

    private int harvest_no;
    private int field_id;
    private int quantity;
    private String date;


}
