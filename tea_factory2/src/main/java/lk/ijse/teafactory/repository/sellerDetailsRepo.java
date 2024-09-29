package lk.ijse.teafactory.repository;

import lk.ijse.teafactory.model.sellerDetails;
import lk.ijse.teafactory.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class sellerDetailsRepo {
    public static List<sellerDetails> getAll() throws SQLException {
        String sql = "SELECT * FROM selle_details";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<sellerDetails> sellerDetailsList = new ArrayList<>();

        while (resultSet.next()) {
            sellerDetailsList.add(new sellerDetails(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getInt(7),
                    resultSet.getDouble(8)

                    ));
        }
        return sellerDetailsList;
    }

    public static boolean save(sellerDetails sellerDetails) throws SQLException {
        String sql = "INSERT INTO seller_details VALUES(?, ?, ?, ?,?, ?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, sellerDetails.getSeller_name());
        pstm.setObject(2, sellerDetails.getBroker_name());
        pstm.setObject(3, sellerDetails.getInvoice_no());
        pstm.setObject(4, sellerDetails.getGrade());
        pstm.setObject(5, sellerDetails.getBags());
        pstm.setObject(6, sellerDetails.getGross_weight());
        pstm.setObject(7, sellerDetails.getVat());
        pstm.setObject(8, sellerDetails.getProceeds_vat());


        return pstm.executeUpdate() > 0;
    }

    public static boolean update(sellerDetails sellerDetails) throws SQLException {
        String sql = "UPDATE seller_detaisl SET seller_name=?, broker_name=?, invoice_no=?, grade=? ,bags=?,gross_weight=? , vat=? ,proceeds_vat =? WHERE seller_name=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);


        pstm.setObject(1, sellerDetails.getSeller_name());
        pstm.setObject(2, sellerDetails.getBroker_name());
        pstm.setObject(3, sellerDetails.getInvoice_no());
        pstm.setObject(4, sellerDetails.getGrade());
        pstm.setObject(5, sellerDetails.getBags());
        pstm.setObject(6, sellerDetails.getGross_weight());
        pstm.setObject(7, sellerDetails.getVat());
        pstm.setObject(8, sellerDetails.getProceeds_vat());


        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String seller_name) throws SQLException {
        String sql = "DELETE FROM seller_details WHERE seller_name=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, seller_name);

        return pstm.executeUpdate() > 0;
    }

    public static sellerDetails search(String seller_name) throws SQLException {
        String sql = "SELECT * FROM seller_details WHERE seller_name=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, seller_name);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new sellerDetails(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getInt(7),
                    resultSet.getDouble(8)


            );
        } else {
            return null;
        }
    }
}