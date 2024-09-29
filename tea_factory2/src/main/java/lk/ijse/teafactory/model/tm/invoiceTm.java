package lk.ijse.teafactory.model.tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class invoiceTm {


    private int invoice_no;
    private String grade;
    private String net_weight;
    private int no_of_packages;
    private String full_or_half;
    private Double total_gross_weight;
    private Date date_of_packing;
    private int chess_number;
    private String type_of_packing;
    private Double net_weight_loss_sallowance;
    private String sample_allow;

}
