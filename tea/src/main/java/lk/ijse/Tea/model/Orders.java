package lk.ijse.Tea.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {

    private int order_id;

    private int customer_id;

    private String date ;

}
