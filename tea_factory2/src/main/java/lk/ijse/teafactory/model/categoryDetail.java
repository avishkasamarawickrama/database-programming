package lk.ijse.teafactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class categoryDetail {

    private int  sale_no   ;
    private int category_id;
    private int limits_bags_counts;
    private int weight_limit;

}