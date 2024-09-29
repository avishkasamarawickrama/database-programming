package lk.ijse.teafactory.repository;


import lk.ijse.teafactory.model.brokerDetail;
import lk.ijse.teafactory.model.orders;
import lk.ijse.teafactory.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrderRepo {
    public static List<orders> getAll() throws SQLException {
        String sql = "SELECT * FROM orders";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<orders> ordersList = new ArrayList<>();

        while (resultSet.next()) {
            ordersList.add(new orders(
                    resultSet.getInt(1),
                    resultSet.getDate(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6)


            ));
        }
        return ordersList;
    }

    public static boolean save(orders orders) throws SQLException {
        String sql = "INSERT INTO orders VALUES(?, ?, ?, ?,?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, orders.getOrder_id());
        pstm.setObject(2, orders.getOrder_date());
        pstm.setObject(3, orders.getOrder_quantity());
        pstm.setObject(4, orders.getOrder_price());
        pstm.setObject(5, orders.getBag_id());
        pstm.setObject(5, orders.getItem_id());


        return pstm.executeUpdate() > 0;
    }

    public static boolean update(orders orders) throws SQLException {
        String sql = "UPDATE orders SET order_id=?, order_date=?, order_quantity=?, order_price=? ,bag_id =?,item_id=? WHERE order_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orders.getOrder_id());
        pstm.setObject(2, orders.getOrder_date());
        pstm.setObject(3, orders.getOrder_quantity());
        pstm.setObject(4, orders.getOrder_price());
        pstm.setObject(5, orders.getBag_id());
        pstm.setObject(5, orders.getItem_id());



        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String order_id) throws SQLException {
        String sql = "DELETE FROM orders WHERE order_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, order_id);

        return pstm.executeUpdate() > 0;
    }

    public static orders search(String order_id) throws SQLException {
        String sql = "SELECT * FROM orders WHERE order_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, order_id);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new orders(
                    resultSet.getInt(1),
                    resultSet.getDate(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6)


            );
        } else {
            return null;
        }
    }
}