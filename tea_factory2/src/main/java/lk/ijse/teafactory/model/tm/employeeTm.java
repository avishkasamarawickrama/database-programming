package lk.ijse.teafactory.model.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class employeeTm {

    private String employee_name;
    private int employee_id;
    private int em_phone_number;
    private int age;
    private String address;

}