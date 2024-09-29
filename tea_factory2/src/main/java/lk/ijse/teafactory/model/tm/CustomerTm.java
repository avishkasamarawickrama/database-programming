package lk.ijse.teafactory.model.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerTm {
    private int customer_id;
    private String customer_name;
    private String customer_address;
    private String customer_status;

}
