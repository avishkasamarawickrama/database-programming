package lk.ijse.Tea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    private int customer_id;
    private String customer_name;
    private int contact;
    private String email;


}
