package lk.ijse.teafactory.repository;

import lk.ijse.teafactory.model.categoryDetail;
import lk.ijse.teafactory.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class categoryDetailsRepo {
    public static List<categoryDetail> getAll() throws SQLException {
        String sql = "SELECT * FROM category_detail";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<categoryDetail> categoryDetailsList = new ArrayList<>();

        while (resultSet.next()) {
            categoryDetailsList.add(new categoryDetail(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4)


            ));
        }
        return categoryDetailsList;
    }


    public static boolean save(categoryDetail categoryDetail) throws SQLException {
        String sql = "INSERT INTO category_detail VALUES(?, ?, ?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, categoryDetail.getSale_no());
        pstm.setObject(2, categoryDetail.getCategory_id());
        pstm.setObject(3, categoryDetail.getLimits_bags_counts());
        pstm.setObject(3, categoryDetail.getWeight_limit());


        return pstm.executeUpdate() > 0;
    }

    public static boolean update(categoryDetail categoryDetail) throws SQLException {
        String sql = "UPDATE category_detail SET sale_no=?, category_id=?, limits_bags_counts=?,weight_limit=? WHERE sale_no=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, categoryDetail.getSale_no());
        pstm.setObject(2, categoryDetail.getCategory_id());
        pstm.setObject(3, categoryDetail.getLimits_bags_counts());
        pstm.setObject(3, categoryDetail.getWeight_limit());




        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String sale_no) throws SQLException {
        String sql = "DELETE FROM category_detail WHERE sale_no=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1,sale_no);

        return pstm.executeUpdate() > 0;
    }

    public static categoryDetail search(String sale_no) throws SQLException {
        String sql = "SELECT * FROM category_detail WHERE sale_no=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, sale_no);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new categoryDetail(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4)

            );
        } else {
            return null;
        }
    }
}