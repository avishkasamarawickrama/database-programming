package lk.ijse.teafactory.repository;



import lk.ijse.teafactory.model.broker;
import lk.ijse.teafactory.db.DbConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class brokerRepo {
    public static List<broker> getAll() throws SQLException {
        String sql = "SELECT * FROM broker";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<broker> brokerList = new ArrayList<>();

        while (resultSet.next()) {
            brokerList.add(new broker(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)


            ));
        }
        return brokerList;
    }


        public static boolean save(broker broker) throws SQLException {
            String sql = "INSERT INTO broker VALUES(?, ?, ?)";

            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setObject(1, broker.getBroker_name());
        pstm.setObject(2, broker.getBroker_address());
        pstm.setObject(3, broker.getStatus());



        return pstm.executeUpdate() > 0;
    }

    public static boolean update(broker broker) throws SQLException {
        String sql = "UPDATE broker SET broker_name=?, broker_address=?, status=? WHERE broker_name=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, broker.getBroker_name());
        pstm.setObject(2, broker.getBroker_address());
        pstm.setObject(3, broker.getStatus());



        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String broker_name) throws SQLException {
        String sql = "DELETE FROM broker WHERE broker_name=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, broker_name);

        return pstm.executeUpdate() > 0;
    }
    public static broker search(String broker_name) throws SQLException {
        String sql = "SELECT * FROM broker WHERE broker_name=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, broker_name);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new broker(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)

            );
        } else {
            return null;
        }
    }
}