package lk.ijse.teafactory.repository;


import lk.ijse.teafactory.model.invoice;
import lk.ijse.teafactory.db.DbConnection;
import lk.ijse.teafactory.model.orderDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class invoiceRepo {
    public static List<invoice> getAll() throws SQLException {
        String sql = "SELECT * FROM invoice";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<invoice> invoiceList = new ArrayList<>();

        while (resultSet.next()) {
            invoiceList.add(new invoice(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getDate(7),
                    resultSet.getInt(8),
                    resultSet.getString(9),
                    resultSet.getDouble(10),
                    resultSet.getString(11)


                    ));
        }
        return invoiceList;
    }

    public static boolean save(invoice invoice) throws SQLException {
        String sql = "INSERT INTO invoice VALUES(?, ?, ?, ?,?, ?, ?, ?,?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, invoice.getInvoice_no());
        pstm.setObject(2, invoice.getGrade());
        pstm.setObject(3, invoice.getNet_weight());
        pstm.setObject(4, invoice.getNo_of_packages());
        pstm.setObject(5, invoice.getFull_or_half());
        pstm.setObject(6, invoice.getTotal_gross_weight());
        pstm.setObject(7, invoice.getDate_of_packing());
        pstm.setObject(8, invoice.getChess_number());
        pstm.setObject(9, invoice.getType_of_packing());
        pstm.setObject(10, invoice.getNet_weight_loss_sallowance());
        pstm.setObject(11, invoice.getSample_allow());

        return pstm.executeUpdate() > 0;
    }

    public static boolean update(invoice invoice) throws SQLException {
        String sql = "UPDATE invoice SET invoice_no=?, grade=?, net_weight=?, no_of_packages=? ,full_or_half =?,total_gross_weight=?,date_of_packing=?,chess_number=?,type_of_packing=?,net_weight_loss_sallowance=?,sample_allow=? WHERE invoice_no=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, invoice.getInvoice_no());
        pstm.setObject(2, invoice.getGrade());
        pstm.setObject(3, invoice.getNet_weight());
        pstm.setObject(4, invoice.getNo_of_packages());
        pstm.setObject(5, invoice.getFull_or_half());
        pstm.setObject(6, invoice.getTotal_gross_weight());
        pstm.setObject(7, invoice.getDate_of_packing());
        pstm.setObject(8, invoice.getChess_number());
        pstm.setObject(9, invoice.getType_of_packing());
        pstm.setObject(10, invoice.getNet_weight_loss_sallowance());
        pstm.setObject(11, invoice.getSample_allow());


        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String invoice_no) throws SQLException {
        String sql = "DELETE FROM invoice WHERE invoice_no=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, invoice_no);

        return pstm.executeUpdate() > 0;
    }
    public static invoice search(String invoice_no) throws SQLException {
        String sql = "SELECT * FROM invoice WHERE invoice_no=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, invoice_no);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new invoice(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getDate(7),
                    resultSet.getInt(8),
                    resultSet.getString(9),
                    resultSet.getDouble(10),
                    resultSet.getString(11)


            );
        } else {
            return null;
        }
    }
}