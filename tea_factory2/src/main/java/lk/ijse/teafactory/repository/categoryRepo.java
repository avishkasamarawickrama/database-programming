package lk.ijse.teafactory.repository;

import lk.ijse.teafactory.model.category;
import lk.ijse.teafactory.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class categoryRepo {
    public static List<category> getAll() throws SQLException {
        String sql = "SELECT * FROM category";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<category> categoryList = new ArrayList<>();

        while (resultSet.next()) {
            categoryList.add(new category(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)


            ));
        }
        return categoryList;
    }


    public static boolean save(category category) throws SQLException {
        String sql = "INSERT INTO category_detail VALUES(?, ?, ?,?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, category.getCategory_id());
        pstm.setObject(2, category.getCategory_name());
        pstm.setObject(3, category.getNet_weight());
        pstm.setObject(4, category.getColour());
        pstm.setObject(5, category.getBag_id());


        return pstm.executeUpdate() > 0;
    }

    public static boolean update(category category) throws SQLException {
        String sql = "UPDATE category SET category_id=?, category_name=?, net_weight=?,colour=?,bag_id= ? WHERE category_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, category.getCategory_id());
        pstm.setObject(2, category.getCategory_name());
        pstm.setObject(3, category.getNet_weight());
        pstm.setObject(4, category.getColour());
        pstm.setObject(5, category.getBag_id());


        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String category_id) throws SQLException {
        String sql = "DELETE FROM category WHERE category_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, category_id);

        return pstm.executeUpdate() > 0;
    }

    public static category search(String category_id) throws SQLException {
        String sql = "SELECT * FROM category WHERE category_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, category_id);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new category(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        } else {
            return null;
        }
    }
}