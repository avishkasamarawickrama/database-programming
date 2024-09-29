package lk.ijse.Tea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class payment {

    private int payment_id;
    private String payment_method;
    private Double amount;
    private String date;


}
