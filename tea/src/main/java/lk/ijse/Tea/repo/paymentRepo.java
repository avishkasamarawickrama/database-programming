package lk.ijse.Tea.repo;

import lk.ijse.Tea.db.Dbconnection;
import lk.ijse.Tea.model.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class paymentRepo {
    public static List<payment> getAll() throws SQLException {
        String sql = "SELECT * FROM payment";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<payment> paymentList = new ArrayList<>();

        while (resultSet.next()) {
            int payment_id = Integer.parseInt(resultSet.getString(1));
            String payment_method = resultSet.getString(2);
            Double amount = (double) Integer.parseInt(resultSet.getString(3));
            String date = resultSet.getString(4);

            payment payment = new payment(payment_id, payment_method,amount,date);
            paymentList.add(payment);
        }
        return paymentList;
    }
    public static List<String> getIds() throws SQLException {
        String sql = "SELECT payment_id FROM payment";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        List<String> ids = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            int payment_id = Integer.parseInt(resultSet.getString(1));
            ids.add(String.valueOf(payment_id));
        }
        return ids;
    }

    public static boolean update (payment payment) throws SQLException {
        String sql = "UPDATE payment SET payment_method =?, amount =?, date =? WHERE payment_id =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setInt(1, payment.getPayment_id());
        pstm.setString(2, payment.getPayment_method());
        pstm.setDouble(3, payment.getAmount());
        pstm.setString(4, payment.getDate());

        return pstm.executeUpdate() > 0;
    }

    public static boolean update2 (int payment_id, String payment_method, Double amount, String date) throws SQLException {
        String sql = "UPDATE payment SET payment_method =?, amount =?, date =? WHERE payment_id =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1,payment_id);
        pstm.setObject(2,payment_method);
        pstm.setObject(3,amount);
        pstm.setObject(4,date);

        return pstm.executeUpdate() > 0;
    }


    public static payment searchById (int id) throws SQLException {
        String sql = "SELECT * FROM payment WHERE payment_id = ?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            int payment_id = Integer.parseInt(resultSet.getString(1));
            String payment_method = resultSet.getString(2);
            Double amount = (resultSet.getDouble(3));
            String date = resultSet.getString(4);


            payment payment = new payment(payment_id, payment_method, amount, date);

            return payment;
        }

        return null;
    }
}
