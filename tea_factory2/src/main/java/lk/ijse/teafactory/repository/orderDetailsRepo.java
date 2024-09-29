package lk.ijse.teafactory.repository;



import lk.ijse.teafactory.model.orderDetails;
import lk.ijse.teafactory.db.DbConnection;
import lk.ijse.teafactory.model.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class orderDetailsRepo {
    public static List<orderDetails> getAll() throws SQLException {
        String sql = "SELECT * FROM order_details";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<orderDetails> orderDetailsList = new ArrayList<>();

        while (resultSet.next()) {
            orderDetailsList.add(new orderDetails(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5)


            ));
        }
        return orderDetailsList;
    }

    public static boolean save(orderDetails orderDetails) throws SQLException {
        String sql = "INSERT INTO order_details VALUES(?, ?, ?, ?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, orderDetails.getCustomer_id());
        pstm.setObject(2, orderDetails.getItem_id());
        pstm.setObject(3, orderDetails.getQty());
        pstm.setObject(4, orderDetails.getAmount());
        pstm.setObject(5, orderDetails.getStatus());


        return pstm.executeUpdate() > 0;
    }

    public static boolean update(orderDetails orderDetails) throws SQLException {
        String sql = "UPDATE order_details SET customer_id=?, item_id=?, qty=?, amount=? ,status =? WHERE customer_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orderDetails.getCustomer_id());
        pstm.setObject(2, orderDetails.getItem_id());
        pstm.setObject(3, orderDetails.getQty());
        pstm.setObject(4, orderDetails.getAmount());
        pstm.setObject(5, orderDetails.getStatus());


        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String customer_id) throws SQLException {
        String sql = "DELETE FROM order_details WHERE customer_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, customer_id);

        return pstm.executeUpdate() > 0;
    }
    public static orderDetails search(String customer_id) throws SQLException {
        String sql = "SELECT * FROM order_details WHERE customer_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, customer_id);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new orderDetails(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5)



            );
        } else {
            return null;
        }
    }
}
