package lk.ijse.teafactory.model.tm;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class returnsTm {


    private int return_id;
    private Date return_date;
    private String broker_name;
    private int transport_id;
    private String return_reason;
    private Double bags_net_weight;
    private Double total_weight;

}