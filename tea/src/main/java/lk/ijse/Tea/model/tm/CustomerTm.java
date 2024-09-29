package lk.ijse.Tea.model.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerTm {

    private int customer_id;
    private String customer_name;
    private int contact;
    private String email;


}
