package lk.ijse.Tea.model.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class OrderDetailTm {

        private int category_id;
        private int quantity;
        private double amount;
        private double total;

    }

