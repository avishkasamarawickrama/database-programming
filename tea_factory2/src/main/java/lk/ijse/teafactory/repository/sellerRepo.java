package lk.ijse.teafactory.repository;


import lk.ijse.teafactory.model.seller;
import lk.ijse.teafactory.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class sellerRepo {
    public static List<seller> getAll() throws SQLException {
        String sql = "SELECT * FROM seller";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<seller> sellerList = new ArrayList<>();

        while (resultSet.next()) {
            sellerList.add(new seller(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getString(3)

            ));
        }
        return sellerList;
    }

    public static boolean save(seller seller) throws SQLException {
        String sql = "INSERT INTO seller VALUES(?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, seller.getSeller_name());
        pstm.setObject(2, seller.getSeller_contact());
        pstm.setObject(3, seller.getSeller_address());

        return pstm.executeUpdate() > 0;
    }

    public static boolean update(seller seller) throws SQLException {
        String sql = "UPDATE seller SET seller_name=?, seller_contact=?, seller_address=? WHERE seller_name=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, seller.getSeller_name());
        pstm.setObject(2, seller.getSeller_contact());
        pstm.setObject(3, seller.getSeller_address());

        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String seller_name) throws SQLException {
        String sql = "DELETE FROM seller_details WHERE seller_name=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, seller_name);

        return pstm.executeUpdate() > 0;
    }

    public static seller search(String seller_name) throws SQLException {
        String sql = "SELECT * FROM seller WHERE seller_name=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, seller_name);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new seller(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getString(3)


            );
        } else {
            return null;
        }
    }
}