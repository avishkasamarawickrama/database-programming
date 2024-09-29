package lk.ijse.Tea.repo;

import lk.ijse.Tea.db.Dbconnection;
import lk.ijse.Tea.model.Orders;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersRepo {
    public static List<Orders> getAll() throws SQLException {
        String sql = "SELECT * FROM orders";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Orders> ordersList = new ArrayList<>();

        while (resultSet.next()) {
            int order_id = resultSet.getInt(1);
            int customer_id = resultSet.getInt(2);
            String date = resultSet.getString(3);

            Orders orders = new Orders(order_id,customer_id,date);
            ordersList.add(orders);
        }
        return ordersList;
    }
    public static List<String> getIds() throws SQLException {
        String sql = "SELECT order_id FROM orders";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        List<String> ids = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            int order_id = Integer.parseInt(resultSet.getNString(1));
            ids.add(String.valueOf(order_id));
        }
        return ids;
    }

    public static boolean update (Orders orders) throws SQLException {
        String sql = "UPDATE orders SET status =?, payment_id =?, customer_id =?,category_id=?,date=? WHERE order_id =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setInt(1, orders.getOrder_id());
        pstm.setString(4, String.valueOf(orders.getCustomer_id()));
        pstm.setString(4, String.valueOf(orders.getDate()));

        return pstm.executeUpdate() > 0;
    }

    public static boolean update2 (int order_id, String status, int payment_id, int customer_id,int category_id,String date) throws SQLException {
        String sql = "UPDATE orders SET  customer_id =? , date=? WHERE order_id =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1,order_id);
        pstm.setObject(2,customer_id);
        pstm.setObject(3,date);

        return pstm.executeUpdate() > 0;
    }


    public static Orders searchById (int id) throws SQLException {
        String sql = "SELECT * FROM orders WHERE order_id = ?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            int order_id = resultSet.getInt(1);
            int customer_id = resultSet.getInt(2);
            String date = resultSet.getString(3);


            Orders orders = new Orders(order_id,  customer_id,date);

            return orders;
        }

        return null;
    }

    public static String currentId() {
        return null;
    }

    public static boolean save(Orders order) {
        return false;
    }
}
