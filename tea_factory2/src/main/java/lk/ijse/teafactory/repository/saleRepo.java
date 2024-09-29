package lk.ijse.teafactory.repository;


import lk.ijse.teafactory.model.sale;
import lk.ijse.teafactory.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class saleRepo {
    public static List<sale> getAll() throws SQLException {
        String sql = "SELECT * FROM sale";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<sale> saleList = new ArrayList<>();

        while (resultSet.next()) {
            saleList.add(new sale(
                    resultSet.getInt(1),
                    resultSet.getDate(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)


            ));
        }
        return saleList;
    }

    public static boolean save(sale sale) throws SQLException {
        String sql = "INSERT INTO sale VALUES(?, ?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, sale.getSale_no());
        pstm.setObject(2, sale.getSale_date());
        pstm.setObject(3, sale.getSale_status());
        pstm.setObject(4, sale.getBag_id());


        return pstm.executeUpdate() > 0;
    }

    public static boolean update(sale sale) throws SQLException {
        String sql = "UPDATE sale SET sale_no=?, sale_date=?, sale_status=?, bag_id=? WHERE sale_no=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, sale.getSale_no());
        pstm.setObject(2, sale.getSale_date());
        pstm.setObject(3, sale.getSale_status());
        pstm.setObject(4, sale.getBag_id());


        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String sale_no) throws SQLException {
        String sql = "DELETE FROM sale WHERE sale_no=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, sale_no);

        return pstm.executeUpdate() > 0;
    }

    public static sale search(String sale_no) throws SQLException {
        String sql = "SELECT * FROM sale WHERE sale_no=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, sale_no);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new sale(
                    resultSet.getInt(1),
                    resultSet.getDate(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)


            );
        } else {
            return null;
        }
    }
}