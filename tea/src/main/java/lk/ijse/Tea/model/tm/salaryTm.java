package lk.ijse.Tea.model.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class salaryTm {

    private int salary_no;
    private int employee_id;
    private String date;
    private String amount;


}
