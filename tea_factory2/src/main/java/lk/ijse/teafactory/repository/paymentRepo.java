package lk.ijse.teafactory.repository;



import lk.ijse.teafactory.model.payment;
import lk.ijse.teafactory.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class paymentRepo {
    public static List<payment> getAll() throws SQLException {
        String sql = "SELECT * FROM payment";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<payment> paymentList = new ArrayList<>();

        while (resultSet.next()) {
            paymentList.add(new payment(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getDate(3),
                    resultSet.getDouble(4),
                    resultSet.getDouble(5),
                    resultSet.getInt(6),
                    resultSet.getDouble(7),
                    resultSet.getString(8),
                    resultSet.getInt(9),
                    resultSet.getString(10)


                    ));
        }
        return paymentList;
    }

    public static boolean save(payment payment) throws SQLException {
        String sql = "INSERT INTO payment VALUES(?, ?, ?, ?,?,?,?, ?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, payment.getPayment_id());
        pstm.setObject(2, payment.getPay_type());
        pstm.setObject(3, payment.getPay_date());
        pstm.setObject(4, payment.getAmount());
        pstm.setObject(5, payment.getTax());
        pstm.setObject(6, payment.getDiscount());
        pstm.setObject(7, payment.getPayment());
        pstm.setObject(8, payment.getReceiver());
        pstm.setObject(9, payment.getSale_no());
        pstm.setObject(10, payment.getBroker_name());


        return pstm.executeUpdate() > 0;
    }

    public static boolean update(payment payment) throws SQLException {
        String sql = "UPDATE payment SET payment_id=?, pay_type=?, pay_date=?, amount=? ,tax =?,discount=?,payment=?,receiver=?,sale_no=?,broker_name=? WHERE payment_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, payment.getPayment_id());
        pstm.setObject(2, payment.getPay_type());
        pstm.setObject(3, payment.getPay_date());
        pstm.setObject(4, payment.getAmount());
        pstm.setObject(5, payment.getTax());
        pstm.setObject(6, payment.getDiscount());
        pstm.setObject(7, payment.getPayment());
        pstm.setObject(8, payment.getReceiver());
        pstm.setObject(9, payment.getSale_no());
        pstm.setObject(10, payment.getBroker_name());


        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String payment_id) throws SQLException {
        String sql = "DELETE FROM payment WHERE payment_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, payment_id);

        return pstm.executeUpdate() > 0;
    }

    public static payment search(String order_id) throws SQLException {
        String sql = "SELECT * FROM payment WHERE payment_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, order_id);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new payment(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getDate(3),
                    resultSet.getDouble(4),
                    resultSet.getDouble(5),
                    resultSet.getInt(6),
                    resultSet.getDouble(7),
                    resultSet.getString(8),
                    resultSet.getInt(9),
                    resultSet.getString(10)



            );
        } else {
            return null;
        }
    }
}