package lk.ijse.teafactory.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class sale {


    private int sale_no;
    private Date sale_date;
    private String sale_status;
    private int bag_id;


}