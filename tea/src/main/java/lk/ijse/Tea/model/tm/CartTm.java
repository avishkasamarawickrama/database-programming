package lk.ijse.Tea.model.tm;

import com.jfoenix.controls.JFXButton;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartTm {
    private int category_id;
    private String category_name;
    private int quantity;
    private double unit_price;
    private double total;
    private JFXButton btnRemove;
}