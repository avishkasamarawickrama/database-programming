package lk.ijse.teafactory.repository;

import lk.ijse.teafactory.model.Customer;
import lk.ijse.teafactory.db.DbConnection;
import lk.ijse.teafactory.model.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerRepo {
    public static List<Customer> getAll() throws SQLException {
        String sql = "SELECT * FROM customer";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Customer> customerList = new ArrayList<>();

        while (resultSet.next()) {
            customerList.add(new Customer(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)

            ));
        }
        return customerList;
    }

    public static boolean save(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer VALUES(?, ?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, customer.getCustomer_id());
        pstm.setObject(2, customer.getCustomer_name());
        pstm.setObject(3, customer.getCustomer_address());
        pstm.setObject(4, customer.getCustomer_status());


        return pstm.executeUpdate() > 0;
    }

    public static boolean update(Customer customer) throws SQLException {
        String sql = "UPDATE customer SET customer_id=?, customer_name=?, customer_address=?, customer_status=? WHERE customer_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, customer.getCustomer_id());
        pstm.setObject(2, customer.getCustomer_name());
        pstm.setObject(3, customer.getCustomer_address());
        pstm.setObject(4, customer.getCustomer_status());


        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String customer_id) throws SQLException {
        String sql = "DELETE FROM customer WHERE customer_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, customer_id);

        return pstm.executeUpdate() > 0;
    }
    public static Customer search(String customer_id ) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE customer_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, customer_id);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new Customer(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)

            );
        } else {
            return null;
        }
    }
}



