package lk.ijse.teafactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class brokerDetail {

    private String broker_name;
    private int transport_id;
    private int lot_no;
    private String grade;
    private String bags;
    private Double net_weight;
    private Double total_weight;
    private String buyer;
    private Double first_price;
    private Double second_price;
    private Double last_price;
    private Double proceeds;

}
