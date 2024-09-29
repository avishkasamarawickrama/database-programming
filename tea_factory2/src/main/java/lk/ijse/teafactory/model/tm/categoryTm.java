package lk.ijse.teafactory.model.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class categoryTm {

    private int category_id;
    private String category_name;
    private String net_weight;
    private String colour;
    private String bag_id;
}
