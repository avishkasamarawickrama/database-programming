package lk.ijse.teafactory.model.tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class paymentTm {


    private int payment_id;
    private String pay_type;
    private Date pay_date;
    private Double amount;
    private Double tax;
    private int discount;
    private Double payment;
    private String receiver;
    private int sale_no;
    private String broker_name;

}
