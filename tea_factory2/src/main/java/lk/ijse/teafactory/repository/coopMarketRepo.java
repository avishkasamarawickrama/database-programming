package lk.ijse.teafactory.repository;

import lk.ijse.teafactory.model.coopMarket;
import lk.ijse.teafactory.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class coopMarketRepo {
    public static List<coopMarket> getAll() throws SQLException {
        String sql = "SELECT * FROM co_op_market";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<coopMarket> coopMarketList = new ArrayList<>();

        while (resultSet.next()) {
            coopMarketList.add(new coopMarket(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5)


            ));
        }
        return coopMarketList;
    }


    public static boolean save(coopMarket coopMarket) throws SQLException {
        String sql = "INSERT INTO co_op_market VALUES(?, ?, ?,?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, coopMarket.getItem_id());
        pstm.setObject(2, coopMarket.getItem_name());
        pstm.setObject(3, coopMarket.getItem_qty());
        pstm.setObject(4, coopMarket.getSell_price());
        pstm.setObject(5, coopMarket.getStatus());


        return pstm.executeUpdate() > 0;
    }

    public static boolean update(coopMarket coopMarket) throws SQLException {
        String sql = "UPDATE co_op_market SET item_id=?, item_name=?, item_qty=?,sell_price=?,status= ? WHERE item_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, coopMarket.getItem_id());
        pstm.setObject(2, coopMarket.getItem_name());
        pstm.setObject(3, coopMarket.getItem_qty());
        pstm.setObject(4, coopMarket.getSell_price());
        pstm.setObject(5, coopMarket.getStatus());

        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String item_id) throws SQLException {
        String sql = "DELETE FROM co_op_market WHERE item_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, item_id);

        return pstm.executeUpdate() > 0;
    }

    public static coopMarket search(String item_id) throws SQLException {
        String sql = "SELECT * FROM co_op_market WHERE item_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, item_id);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new coopMarket(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5)
            );
        } else {
            return null;
        }
    }
}