package lk.ijse.teafactory.repository;

import lk.ijse.teafactory.db.DbConnection;
import lk.ijse.teafactory.model.transport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class transportRepo {
    public static List<transport> getAll() throws SQLException {
        String sql = "SELECT * FROM transport";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<transport> transportList = new ArrayList<>();

        while (resultSet.next()) {
            transportList.add(new transport(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4)

            ));
        }
        return transportList;
    }

    public static boolean save(transport transport) throws SQLException {
        String sql = "INSERT INTO transport VALUES(?, ?, ?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, transport.getTransport_id());
        pstm.setObject(2, transport.getInvoice_no());
        pstm.setObject(3, transport.getEmployee_id());
        pstm.setObject(4, transport.getSale_no());

        return pstm.executeUpdate() > 0;
    }

    public static boolean update(transport transport) throws SQLException {
        String sql = "UPDATE transport SET transport_id=?, invoice_no=?, employee_id=?,sale_no=? WHERE transport_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, transport.getTransport_id());
        pstm.setObject(2, transport.getInvoice_no());
        pstm.setObject(3, transport.getEmployee_id());
        pstm.setObject(4, transport.getSale_no());

        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String transport_id) throws SQLException {
        String sql = "DELETE FROM transport WHERE transport_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, transport_id);

        return pstm.executeUpdate() > 0;
    }

    public static transport search(String transport_id) throws SQLException {
        String sql = "SELECT * FROM transport WHERE transport_name=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, transport_id);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new transport(
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