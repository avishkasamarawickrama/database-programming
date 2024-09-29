package lk.ijse.teafactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class category {

    private int category_id;
    private String category_name;
    private String net_weight;
    private String colour;
    private String bag_id;
}