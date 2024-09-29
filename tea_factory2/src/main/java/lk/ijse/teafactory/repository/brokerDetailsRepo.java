package lk.ijse.teafactory.repository;

import lk.ijse.teafactory.model.broker;
import lk.ijse.teafactory.model.brokerDetail;
import lk.ijse.teafactory.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class brokerDetailsRepo {
    public static List<brokerDetail> getAll() throws SQLException {
        String sql = "SELECT * FROM broker_details";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<brokerDetail> brokerDetaillList = new ArrayList<>();

        while (resultSet.next()) {
            brokerDetaillList.add(new brokerDetail(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getDouble(7),
                    resultSet.getString(8),
                    resultSet.getDouble(9),
                    resultSet.getDouble(10),
                    resultSet.getDouble(11),
                    resultSet.getDouble(12)



            ));
        }
        return brokerDetaillList;
    }


    public static boolean save(brokerDetail brokerDetail) throws SQLException {
        String sql = "INSERT INTO broker_details VALUES(?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, brokerDetail.getBroker_name());
        pstm.setObject(2, brokerDetail.getTransport_id());
        pstm.setObject(3, brokerDetail.getLot_no());
        pstm.setObject(4, brokerDetail.getGrade());
        pstm.setObject(5, brokerDetail.getBags());
        pstm.setObject(6, brokerDetail.getNet_weight());
        pstm.setObject(7, brokerDetail.getTotal_weight());
        pstm.setObject(8, brokerDetail.getBuyer());
        pstm.setObject(9, brokerDetail.getFirst_price());
        pstm.setObject(10, brokerDetail.getSecond_price());
        pstm.setObject(11, brokerDetail.getLast_price());
        pstm.setObject(12, brokerDetail.getProceeds());



        return pstm.executeUpdate() > 0;
    }

    public static boolean update(brokerDetail brokerDetail) throws SQLException {
        String sql = "UPDATE broker_details SET broker_name=?, transport_id=?, lot_no=?,grade=?, bags=?,net_weight=?,total_weight=?,buyer=?, first_price=?,second_price=?,last_price=?,proceeds =?WHERE broker_name=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, brokerDetail.getBroker_name());
        pstm.setObject(2, brokerDetail.getTransport_id());
        pstm.setObject(3, brokerDetail.getLot_no());
        pstm.setObject(4, brokerDetail.getGrade());
        pstm.setObject(5, brokerDetail.getBags());
        pstm.setObject(6, brokerDetail.getNet_weight());
        pstm.setObject(7, brokerDetail.getTotal_weight());
        pstm.setObject(8, brokerDetail.getBuyer());
        pstm.setObject(9, brokerDetail.getFirst_price());
        pstm.setObject(10, brokerDetail.getSecond_price());
        pstm.setObject(11, brokerDetail.getLast_price());
        pstm.setObject(12, brokerDetail.getProceeds());



        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String broker_name) throws SQLException {
        String sql = "DELETE FROM broker_details WHERE broker_name=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, broker_name);

        return pstm.executeUpdate() > 0;
    }

    public static brokerDetail search(String broker_name) throws SQLException {
        String sql = "SELECT * FROM broker_details WHERE broker_name=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, broker_name);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new brokerDetail(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getDouble(7),
                    resultSet.getString(8),
                    resultSet.getDouble(9),
                    resultSet.getDouble(10),
                    resultSet.getDouble(11),
                    resultSet.getDouble(12)
            );
        } else {
            return null;
        }
    }
}
