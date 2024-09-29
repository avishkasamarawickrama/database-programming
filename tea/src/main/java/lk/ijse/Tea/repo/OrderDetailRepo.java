package lk.ijse.Tea.repo;

import lk.ijse.Tea.db.Dbconnection;
import lk.ijse.Tea.model.OrderDetail;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailRepo {

    public static boolean save(List<OrderDetail> odList) throws SQLException {
        for (OrderDetail od : odList) {
            boolean isSaved = save(od);
            if(!isSaved) {
                return false;
            }
        }
        return true;
    }

    private static boolean save(OrderDetail od) throws SQLException {
        String sql = "INSERT INTO orderdetail VALUES(?, ?, ?, ?)";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection()
                .prepareStatement(sql);

        pstm.setInt(1, od.getOrder_id());
        pstm.setInt(2, od.getQuantity());
        pstm.setInt(3, od.getCategory_id());
        pstm.setDouble(4, od.getAmount());

        return pstm.executeUpdate() > 0;    //false ->  |
    }
}
