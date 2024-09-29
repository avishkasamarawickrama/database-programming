package lk.ijse.Tea.repo;

import lk.ijse.Tea.db.Dbconnection;
import lk.ijse.Tea.model.salary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class salaryRepo {
    public static List<salary> getAll() throws SQLException {
        String sql = "SELECT * FROM salary";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<salary> salaryList = new ArrayList<>();

        while (resultSet.next()) {
            int salary_no = Integer.parseInt(resultSet.getString(1));
            int employee_id = resultSet.getInt(2);
            String date = resultSet.getString(3);
            String amount = resultSet.getString(4);

            salary salary = new salary(salary_no, employee_id,date,amount);
            salaryList.add(salary);
        }
        return salaryList;
    }
    public static List<String> getIds() throws SQLException {
        String sql = "SELECT salary_no FROM salary";

        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        List<String> ids = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            int salary_no = Integer.parseInt(resultSet.getNString(1));
            ids.add(String.valueOf(salary_no));
        }
        return ids;
    }

    public static boolean update (salary salary) throws SQLException {
        String sql = "UPDATE salary SET employee_id =?, date =?, amount =? WHERE salary_no =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setInt(1, salary.getSalary_no());
        pstm.setInt(2, salary.getEmployee_id());
        pstm.setString(3, salary.getDate());
        pstm.setString(4, salary.getAmount());

        return pstm.executeUpdate() > 0;
    }

    public static boolean update2 (int salary_no, int employee_id, String date, String amount) throws SQLException {
        String sql = "UPDATE employee SET employee_id =?, date =?, amount =? WHERE salary_no =?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1,salary_no);
        pstm.setObject(2,employee_id);
        pstm.setObject(3,date);
        pstm.setObject(4,amount);

        return pstm.executeUpdate() > 0;
    }


    public static salary searchById (int id) throws SQLException {
        String sql = "SELECT * FROM salary WHERE salary_no = ?";

        Connection connection = Dbconnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            int salary_no = resultSet.getInt(1);
            int employee_id = resultSet.getInt(2);
            String date = resultSet.getString(3);
            String amount = resultSet.getString(4);


            salary salary = new salary(salary_no, employee_id, date, amount);

            return salary;
        }

        return null;
    }
}

