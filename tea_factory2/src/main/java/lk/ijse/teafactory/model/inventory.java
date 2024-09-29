package lk.ijse.teafactory.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class inventory {

    private int bag_id;
    private String bag_type;
    private int quantity;
    private Double price;

}
