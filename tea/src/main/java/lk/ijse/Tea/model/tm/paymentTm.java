package lk.ijse.Tea.model.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class paymentTm {

    private int payment_id;
    private String payment_method;
    private Double amount;
    private String date;

}
