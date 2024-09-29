package lk.ijse.teafactory.model.tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class inventoryTm {


    private int bag_id;
    private String bag_type;
    private int quantity;
    private Double price;

}