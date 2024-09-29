package lk.ijse.Tea.repo;

import lk.ijse.Tea.db.Dbconnection;
import lk.ijse.Tea.model.Fields;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class fieldsRepo {
    public static List<Fields> getAll() throws SQLException {
        String sql = "SELECT * FROM field";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Fields> fieldsList = new ArrayList<>();

        while (resultSet.next()) {
            int field_id = Integer.parseInt(resultSet.getString(1));
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);

            Fields fields = new Fields(field_id, name,address);
            fieldsList.add(fields);
        }
        return fieldsList;
    }
    public static List<Integer> getIds() throws SQLException {
        String sql = "SELECT field_id FROM field";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        List<Integer> ids = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            int field_id = Integer.parseInt(resultSet.getNString(1));
            ids.add(Integer.valueOf(String.valueOf(field_id)));
        }
        return ids;
    }

    public static boolean update (Fields field) throws SQLException {
        String sql = "UPDATE field SET name =?, address =? WHERE field_id =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setInt(1, field.getField_id());
        pstm.setString(2, field.getName());
        pstm.setString(3, field.getAddress());


        return pstm.executeUpdate() > 0;
    }

    public static boolean update2 (int field_id, String name, String address) throws SQLException {
        String sql = "UPDATE field SET name =?, address =?, WHERE field_id =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1,name);
        pstm.setObject(2,address);

        return pstm.executeUpdate() > 0;
    }


    public static Fields searchById (String id) throws SQLException {
        String sql = "SELECT * FROM field WHERE field_id = ?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            int field_id = Integer.parseInt(resultSet.getString(1));
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);


            Fields fields = new Fields(field_id,name, address);

            return fields;
        }

        return null;
    }
}