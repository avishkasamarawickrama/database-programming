package lk.ijse.Tea.model.tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class employeeTm {

    private int employee_id;
    private String employee_name;
    private int contact;
    private String status;
    private int field_id;


}
