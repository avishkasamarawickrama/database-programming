package lk.ijse.supermarket.model;

public class Item {
    private String code;
    private String description;
    private String unit_price;
    private String qty_on_hand;
    private char[] unitPrice;
    private char[] qtyOnHand;

    public Item(){}

    public Item (String code,String description,String unit_price,String qty_on_hand){
        this.code= code;
        this.description= description;
        this.unit_price=unit_price;
        this.qty_on_hand=qty_on_hand;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public String getQty_on_hand() {
        return qty_on_hand;
    }

    public void setQty_on_hand(String qty_on_hand) {
        this.qty_on_hand = qty_on_hand;
    }

    public char[] getUnitPrice() {
        return unitPrice;
    }

    public char[] getQtyOnHand() {
        return qtyOnHand;
    }
}
