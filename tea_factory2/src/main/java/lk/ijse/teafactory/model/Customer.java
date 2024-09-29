package lk.ijse.teafactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Customer {
    private int customer_id;
    private String customer_name;
    private String customer_address;
    private String customer_status;

}
