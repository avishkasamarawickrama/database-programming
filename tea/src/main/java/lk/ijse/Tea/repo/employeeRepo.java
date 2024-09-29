package lk.ijse.Tea.repo;

import lk.ijse.Tea.db.Dbconnection;
import lk.ijse.Tea.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class employeeRepo {
    public static List<Employee> getAll() throws SQLException {
        String sql = "SELECT * FROM employee";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Employee> employeeList = new ArrayList<>();

        while (resultSet.next()) {
            int employee_id = Integer.parseInt(resultSet.getString(1));
            String employee_name = resultSet.getString(2);
            int contact = Integer.parseInt(resultSet.getString(3));
            String status = resultSet.getString(4);
            int field_id = Integer.parseInt(resultSet.getString(5));

            Employee employee = new Employee(employee_id, employee_name,contact,status,field_id);
            employeeList.add(employee);
        }
        return employeeList;
    }
    public static List<String> getIds() throws SQLException {
        String sql = "SELECT employee_id FROM employee";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        List<String> ids = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            int employee_id = Integer.parseInt(resultSet.getString(1));
            ids.add(String.valueOf(employee_id));
        }
        return ids;
    }

    public static boolean update (Employee employee) throws SQLException {
        String sql = "UPDATE employee SET employee_name =?, contact =?, status =?,field_id=? WHERE employee_id =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setInt(1, employee.getEmployee_id());
        pstm.setString(2, employee.getEmployee_name());
        pstm.setInt(3, employee.getContact());
        pstm.setString(4, employee.getStatus());
        pstm.setInt(5, employee.getField_id());

        return pstm.executeUpdate() > 0;
    }

    public static boolean update2 (int employee_id, String employee_name, int contact, String status,int field_id) throws SQLException {
        String sql = "UPDATE employee SET employee_name =?, contact =?, status =? ,field_id=? WHERE employee_id =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1,employee_name);
        pstm.setObject(2,contact);
        pstm.setObject(3,status);
        pstm.setObject(4,field_id);

        return pstm.executeUpdate() > 0;
    }


    public static Employee searchById (int id) throws SQLException {
        String sql = "SELECT * FROM employee WHERE employee_id = ?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            int employee_id = Integer.parseInt(String.valueOf(resultSet.getInt(1)));
            String employee_name = resultSet.getString(2);
            int contact = Integer.parseInt(resultSet.getString(3));
            String status = resultSet.getString(4);
            int field_id = Integer.parseInt(resultSet.getString(4));


            Employee employee = new Employee(employee_id, employee_name, contact, status,field_id);

            return employee;
        }

        return null;
    }
}