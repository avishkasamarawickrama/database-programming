package lk.ijse.teafactory.repository;

import lk.ijse.teafactory.model.returns;
import lk.ijse.teafactory.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class returnsRepo {
    public static List<returns> getAll() throws SQLException {
        String sql = "SELECT * FROM returns";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<returns> returnsList = new ArrayList<>();

        while (resultSet.next()) {
            returnsList.add(new returns(
                    resultSet.getInt(1),
                    resultSet.getDate(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getDouble(7)


            ));
        }
        return returnsList;
    }

    public static boolean save(returns returns) throws SQLException {
        String sql = "INSERT INTO returns VALUES(?, ?, ?, ?,?,?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, returns.getReturn_id());
        pstm.setObject(2, returns.getReturn_date());
        pstm.setObject(3, returns.getBroker_name());
        pstm.setObject(4, returns.getTransport_id());
        pstm.setObject(5, returns.getReturn_reason());
        pstm.setObject(6, returns.getBags_net_weight());
        pstm.setObject(7, returns.getTotal_weight());


        return pstm.executeUpdate() > 0;
    }

    public static boolean update(returns returns) throws SQLException {
        String sql = "UPDATE returns SET return_id=?, return_date=?, broker_name=?, transport_id=? ,return_reason =?,bags_net_weight=?,total_weight=? WHERE return_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, returns.getReturn_id());
        pstm.setObject(2, returns.getReturn_date());
        pstm.setObject(3, returns.getBroker_name());
        pstm.setObject(4, returns.getTransport_id());
        pstm.setObject(5, returns.getReturn_reason());
        pstm.setObject(6, returns.getBags_net_weight());
        pstm.setObject(7, returns.getTotal_weight());



        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String return_id) throws SQLException {
        String sql = "DELETE FROM returns WHERE return_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, return_id);

        return pstm.executeUpdate() > 0;
    }

    public static returns search(String return_id) throws SQLException {
        String sql = "SELECT * FROM returns WHERE return_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, return_id);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new returns(
                    resultSet.getInt(1),
                    resultSet.getDate(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getDouble(7)



            );
        } else {
            return null;
        }
    }
}