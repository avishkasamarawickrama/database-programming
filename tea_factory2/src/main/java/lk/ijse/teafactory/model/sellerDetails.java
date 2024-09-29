package lk.ijse.teafactory.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class sellerDetails {


    private String seller_name;
    private String broker_name;
    private int invoice_no;
    private String grade;
    private String bags;
    private Double gross_weight;
    private int vat;
    private Double proceeds_vat;

}

