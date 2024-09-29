package lk.ijse.teafactory.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class transport {

    private int transport_id;
    private int invoice_no;
    private int employee_id;
    private int sale_no;


}