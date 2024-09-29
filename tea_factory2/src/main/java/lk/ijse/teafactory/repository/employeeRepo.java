package lk.ijse.teafactory.repository;

import lk.ijse.teafactory.model.employee;
import lk.ijse.teafactory.db.DbConnection;
import lk.ijse.teafactory.model.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class employeeRepo {
    public static List<employee> getAll() throws SQLException {
        String sql = "SELECT * FROM employee";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<employee> employeeList = new ArrayList<>();

        while (resultSet.next()) {
            employeeList.add(new employee(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)

            ));
        }
        return employeeList;
    }

    public static boolean save(employee employee) throws SQLException {
        String sql = "INSERT INTO employee VALUES(?, ?, ?, ?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, employee.getEmployee_id());
        pstm.setObject(2, employee.getEmployee_name());
        pstm.setObject(3, employee.getEm_phone_number());
        pstm.setObject(4, employee.getAge());
        pstm.setObject(4, employee.getAddress());


        return pstm.executeUpdate() > 0;
    }

    public static boolean update(employee employee) throws SQLException {
        String sql = "UPDATE employee SET employee_id=?, employee_name=?, em_phone_number=?, age=? ,address=? WHERE employee_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, employee.getEmployee_id());
        pstm.setObject(2, employee.getEmployee_name());
        pstm.setObject(3, employee.getEm_phone_number());
        pstm.setObject(4, employee.getAge());
        pstm.setObject(4, employee.getAddress());


        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String employee_id) throws SQLException {
        String sql = "DELETE FROM employee WHERE employee_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, employee_id);

        return pstm.executeUpdate() > 0;
    }

    public static employee search(String employee_id ) throws SQLException {
        String sql = "SELECT * FROM employee WHERE employee_id=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, employee_id);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new employee(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)


            );
        } else {
            return null;
        }
    }
}
