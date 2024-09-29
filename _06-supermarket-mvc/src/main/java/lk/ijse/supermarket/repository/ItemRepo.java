package lk.ijse.supermarket.repository;

import lk.ijse.supermarket.db.DbConnection;
import lk.ijse.supermarket.model.Item;
import lk.ijse.supermarket.model.Order;
import lk.ijse.supermarket.model.OrderDetail;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ItemRepo {

    public static Item searchByCode(String code) {
        return null;
    }

    public static List<String> getCodes() {


        return null;

    }

    public static boolean updateQty(List<OrderDetail> odList) throws SQLException {
        for (OrderDetail od : odList) {
            if(!updateQty(od)) {
                return false;
            }
        }
        return true;
    }

    private static boolean updateQty(OrderDetail od) throws SQLException {
        String sql = "UPDATE items SET qty_on_hand = qty_on_hand - ? WHERE code = ?";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        pstm.setInt(1, od.getQty());
        pstm.setString(2, od.getItemCode());

        return pstm.executeUpdate() > 0;
    }
}
