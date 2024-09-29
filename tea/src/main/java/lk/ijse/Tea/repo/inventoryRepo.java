package lk.ijse.Tea.repo;
import lk.ijse.Tea.db.Dbconnection;
import lk.ijse.Tea.model.Inventory;
import lk.ijse.Tea.model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class inventoryRepo {
    public static List<Inventory> getAll() throws SQLException {
        String sql = "SELECT * FROM inventory";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Inventory> inventoryList = new ArrayList<>();

        while (resultSet.next()) {
            int category_id = Integer.parseInt(resultSet.getString(1));
            String category_name = String.valueOf(resultSet.getInt(2));
            int quantity = resultSet.getInt(3);
            int harvest_no = Integer.parseInt((resultSet.getString(4)));
            String unit_price = (resultSet.getString(5));

            Inventory inventory = new Inventory(category_id, category_name,quantity,harvest_no,unit_price);
            inventoryList.add(inventory);
        }
        return inventoryList;
    }
    public static List<String> getIds() throws SQLException {
        String sql = "SELECT category_id FROM inventory";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        List<String> ids = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            int category_id = Integer.parseInt(String.valueOf(resultSet.getInt(1)));
            ids.add(String.valueOf(category_id));
        }
        return ids;
    }

    public static boolean update (Inventory inventory) throws SQLException {
        String sql = "UPDATE inventory SET category_name =?, quantity =?, harvest_no =?,unit_price=? WHERE category_id =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);



        pstm.setInt(1, inventory.getCategory_id());
        pstm.setString(2, inventory.getCategory_name());
        pstm.setInt(3, inventory.getQuantity());
        pstm.setInt(4, inventory.getHarvest_no());
        pstm.setString(5, inventory.getUnit_price());


        return pstm.executeUpdate() > 0;
    }

    public static boolean update2 (int category_id, String category_name, int quantity, int harvest_no,String unit_price) throws SQLException {
        String sql = "UPDATE inventory SET category_name =?, quantity =?, harvest_no =? ,unit_price= ? WHERE category_id =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1,category_id);
        pstm.setObject(2,category_name);
        pstm.setObject(3,quantity);
        pstm.setObject(4,harvest_no);
        pstm.setObject(5,unit_price);

        return pstm.executeUpdate() > 0;
    }


    public static Inventory searchById (int id) throws SQLException {
        String sql = "SELECT * FROM inventory WHERE category_id = ?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            int category_id = Integer.parseInt(resultSet.getString(1));
            String category_name = resultSet.getString(2);
            int quantity  = resultSet.getInt(3);
            int harvest_no  = Integer.parseInt(resultSet.getString(4));
            String unit_price  = (resultSet.getString(5));


            Inventory inventory = new Inventory(category_id, category_name, quantity, harvest_no,unit_price);

            return inventory;
        }

        return null;
    }




    public static boolean update(List<OrderDetail> odList) throws SQLException {
        for (OrderDetail od : odList) {
            boolean isUpdateQty = updateQty(String.valueOf(od.getCategory_id()), od.getQuantity());
            if(!isUpdateQty) {
                return false;
            }
        }
        return true;
    }

    private static boolean updateQty(String category_id, int quantity) throws SQLException {
        String sql = "UPDATE inventory SET unitPrice_200g = unitPrice_200g - ? WHERE category_id = ?";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection()
                .prepareStatement(sql);

        pstm.setInt(1, quantity);
        pstm.setString(2, category_id);

        return pstm.executeUpdate() > 0;
    }

    public static List<String> getCodes() throws SQLException {
        String sql = "SELECT category_id FROM inventory";
        ResultSet resultSet = Dbconnection.getInstance()
                .getConnection()
                .prepareStatement(sql)
                .executeQuery();

        List<String> codeList = new ArrayList<>();
        while (resultSet.next()) {
            codeList.add(resultSet.getString(1));
        }
        return codeList;
    }

    public static boolean updateQty(List<OrderDetail> odList) {

        return false;
    }
}
