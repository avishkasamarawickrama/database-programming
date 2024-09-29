package lk.ijse.Tea.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Tea.db.Dbconnection;

import lk.ijse.Tea.model.Employee;

import lk.ijse.Tea.model.tm.employeeTm;
import lk.ijse.Tea.repo.employeeRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class employeeFormController {

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colFieldId;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<employeeTm> tblEmployee;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtEmployeeId;

    @FXML
    private TextField txtFieldId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtStatus;


    @FXML
    void btnSaveOnAction(ActionEvent event) {
        int employee_id = Integer.parseInt(txtEmployeeId.getText());
        String employee_name = txtName.getText();
        int contact = Integer.parseInt(txtContactNo.getText());
        String status = txtStatus.getText();
        int field_id = Integer.parseInt(txtFieldId.getText());

        String sql = "INSERT INTO employee VALUES(?,?,?,?,?)";

        try {
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1, (employee_id));
            pstm.setString(2,employee_name);
            pstm.setInt(3,contact);
            pstm.setString(4,status);
            pstm.setInt(4,field_id);

            boolean isSaved = pstm.executeUpdate() > 0;
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Employee Saved Successfully").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }



    public void initialize() {

        setCellValueFactory();
        loadAllCustomers();
        System.out.println("Check");
    }
    private void loadAllCustomers() {
        ObservableList<employeeTm> obList = FXCollections.observableArrayList();

        try {
            List<Employee> employeeList = employeeRepo.getAll();
            for (Employee employee : employeeList) {
                employeeTm tm = new employeeTm(
                        employee.getEmployee_id(),
                        employee.getEmployee_name(),
                        employee.getContact(),
                        employee.getStatus(),
                        employee.getField_id()
                );

                obList.add(tm);
            }

            tblEmployee.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("employee_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("employee_name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colFieldId.setCellValueFactory(new PropertyValueFactory<>("field_no"));

    }



    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        int id = Integer.parseInt(txtEmployeeId.getText());

        String sql = "DELETE FROM employee WHERE employee_id =?";

        try {
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1,id);

            boolean isDeleted = pstm.executeUpdate() > 0;
            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Employee Deleted Successfully").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }



    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException {
        int employee_id = Integer.parseInt(txtEmployeeId.getText());
        String employee_name = txtName.getText();
        int contact = Integer.parseInt(txtContactNo.getText());
        String status = txtStatus.getText();
        int field_id = Integer.parseInt(txtFieldId.getText());

        String sql = "UPDATE employee SET employee_name =?, contact =?, status =?,field_id=? WHERE employee_id =?";

        boolean isUpdate = employeeRepo.update2(employee_id, employee_name,contact, status,field_id);
        if (isUpdate) {
            new Alert(Alert.AlertType.INFORMATION, "Employee Updated Successfully").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Employee Not Updated").show();
        }
    }


    @FXML
    void txtEmployeeOnAction(ActionEvent event) {
        int employee_id = Integer.parseInt(txtEmployeeId.getText());

        String sql = "SELECT * FROM employeee WHERE employee_id =?";

        try{
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1, Integer.parseInt(String.valueOf(employee_id)));

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                String employee_name = resultSet.getString(2);
                int contact = Integer.parseInt(String.valueOf(resultSet.getInt(3)));
                String status = resultSet.getString(4);
                int field_id = resultSet.getInt(5);


                txtName.setText(employee_name);
                txtContactNo.setText(String.valueOf(contact));
                txtStatus.setText(status);
                txtFieldId.setText(String.valueOf(field_id));

            } else {
                new Alert(Alert.AlertType.ERROR, "employee Not Found").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,"employee ID Not Found!");
        }
    }
    }