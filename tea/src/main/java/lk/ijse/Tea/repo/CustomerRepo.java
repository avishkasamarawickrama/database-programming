package lk.ijse.Tea.repo;

import lk.ijse.Tea.db.Dbconnection;
import lk.ijse.Tea.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    public static List<Customer> getAll() throws SQLException {
        String sql = "SELECT * FROM customer";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Customer> cusList = new ArrayList<>();

        while (resultSet.next()) {
            int customer_id = Integer.parseInt(resultSet.getString(1));
            String customer_name = resultSet.getString(2);
            int contact = Integer.parseInt(resultSet.getString(3));
            String email = resultSet.getString(4);

            Customer customer = new Customer(customer_id, customer_name,contact,email);
            cusList.add(customer);
        }
        return cusList;
    }
    public static List<String> getIds() throws SQLException {
        String sql = "SELECT customer_id FROM customer";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        List<String> ids = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            int customer_id = Integer.parseInt(String.valueOf(resultSet.getInt(1)));
            ids.add(String.valueOf(customer_id));
        }
        return ids;
    }

    public static boolean update (Customer customer) throws SQLException {
        String sql = "UPDATE customer SET name =?, contact =?, email =? WHERE customer_id =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setInt(1, customer.getCustomer_id());
        pstm.setString(2, customer.getCustomer_name());
        pstm.setInt(3, customer.getContact());
        pstm.setString(4, customer.getEmail());

        return pstm.executeUpdate() > 0;
    }

    public static boolean update2 (int customer_id, String customer_name, int contact, String email) throws SQLException {
        String sql = "UPDATE customer SET customer_name =?, contact =?, email =? WHERE customer_id =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1,customer_name);
        pstm.setObject(2,contact);
        pstm.setObject(3,email);
        pstm.setObject(4,customer_id);

        return pstm.executeUpdate() > 0;
    }


    public static Customer searchById (String id) throws SQLException {
        String sql = "SELECT * FROM customer WHERE customer_id = ?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            int customer_id = Integer.parseInt(resultSet.getString(1));
            String customer_name = resultSet.getString(2);
            int contact = Integer.parseInt(resultSet.getString(3));
            String email = resultSet.getString(4);


            Customer customer = new Customer(customer_id, customer_name, contact, email);

            return customer;
        }

        return null;
    }
}