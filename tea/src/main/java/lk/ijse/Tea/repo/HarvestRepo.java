package lk.ijse.Tea.repo;

import lk.ijse.Tea.db.Dbconnection;
import lk.ijse.Tea.model.Harvest;
import lk.ijse.Tea.model.OrderDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HarvestRepo {
    public static List<Harvest> getAll() throws SQLException {
        String sql = "SELECT * FROM harvest";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Harvest> harvestList = new ArrayList<>();

        while (resultSet.next()) {
            int harvest_no = Integer.parseInt(resultSet.getString(1));
            int field_id = resultSet.getInt(2);
            int quantity = resultSet.getInt(3);
            String date = (resultSet.getString(4));

            Harvest harvest = new Harvest(harvest_no, field_id,quantity,date);
            harvestList.add(harvest);
        }
        return harvestList;
    }
    public static List<String> getIds() throws SQLException {
        String sql = "SELECT harvest_no FROM harvest";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        List<String> ids = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            int harvest_no = Integer.parseInt(String.valueOf(resultSet.getInt(1)));
            ids.add(String.valueOf(harvest_no));
        }
        return ids;
    }

    public static boolean update (Harvest harvest) throws SQLException {
        String sql = "UPDATE harvest SET field_id =?, quantity =?, date =? WHERE harvest_no =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);



        pstm.setInt(1, harvest.getHarvest_no());
        pstm.setInt(2, harvest.getField_id());
        pstm.setInt(3, harvest.getQuantity());
        pstm.setString(4, harvest.getDate());


        return pstm.executeUpdate() > 0;
    }

    public static boolean update2 (int harvest_no, int field_id, int quantity, String date) throws SQLException {
        String sql = "UPDATE harvest SET field_id =?, quantity =?, date =? WHERE harvest_no =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1,harvest_no);
        pstm.setObject(2,field_id);
        pstm.setObject(3,quantity);
        pstm.setObject(4,date);

        return pstm.executeUpdate() > 0;
    }


    public static Harvest searchById (String id) throws SQLException {
        String sql = "SELECT * FROM harvest WHERE harvest_id = ?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            int harvest_no = Integer.parseInt(resultSet.getString(1));
            int field_id = resultSet.getInt(2);
            int quantity  = resultSet.getInt(3);
            String date  = resultSet.getString(4);


            Harvest harvest = new Harvest(harvest_no, field_id, quantity, date);

            return harvest;
        }

        return null;
    }







}
