package lk.ijse.teafactory.repository;

import lk.ijse.teafactory.model.inventory;
import lk.ijse.teafactory.db.DbConnection;
import lk.ijse.teafactory.model.invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class inventoryRepo {
    public static List<inventory> getAll() throws SQLException {
        String sql = "SELECT * FROM inventory";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<inventory> inventoryList = new ArrayList<>();

        while (resultSet.next()) {
            inventoryList.add(new inventory(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4)


            ));
        }
        return inventoryList;
    }

    public static boolean save(inventory inventory) throws SQLException {
        String sql = "INSERT INTO inventory VALUES(?, ?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, inventory.getBag_id());
        pstm.setObject(2, inventory.getBag_type());
        pstm.setObject(3, inventory.getQuantity());
        pstm.setObject(4, inventory.getPrice());


        return pstm.executeUpdate() > 0;
    }

    public static boolean update(inventory inventory) throws SQLException {
        String sql = "UPDATE inventory SET bag_id=?, bag_type=?, quantity=?, price=?  WHERE bag_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, inventory.getBag_id());
        pstm.setObject(2, inventory.getBag_type());
        pstm.setObject(3, inventory.getQuantity());
        pstm.setObject(4, inventory.getPrice());



        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String bag_id) throws SQLException {
        String sql = "DELETE FROM bags WHERE bag_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, bag_id);

        return pstm.executeUpdate() > 0;
    }
    public static inventory search(String bag_id ) throws SQLException {
        String sql = "SELECT * FROM inventory WHERE bag_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, bag_id);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new inventory(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4)


            );
        } else {
            return null;
        }
    }
}
