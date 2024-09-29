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
import lk.ijse.Tea.model.salary;
import lk.ijse.Tea.model.tm.salaryTm;
import lk.ijse.Tea.repo.salaryRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class salaryFormController {

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colEmployeeId;

    @FXML
    private TableColumn<?, ?> colNo;

    @FXML
    private TableColumn<?, ?> colPaymentDate;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<salaryTm> tblSalary;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtEmployeeId;

    @FXML
    private TextField txtSalaryno;


    @FXML
    void btnSaveOnAction(ActionEvent event) {
        int salary_no = Integer.parseInt(txtSalaryno.getText());
        int employee_id = Integer.parseInt(txtEmployeeId.getText());
        String date = txtDate.getText();
        String amount = txtAmount.getText();

        String sql = "INSERT INTO salary VALUES(?,?,?,?)";

        try {
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1,(salary_no));
            pstm.setInt(2,employee_id);
            pstm.setString(3,date);
            pstm.setString(4,amount);

            boolean isSaved = pstm.executeUpdate() > 0;
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "data Saved Successfully").show();
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
        ObservableList<salaryTm> obList = FXCollections.observableArrayList();

        try {
            List<salary> salaryList = salaryRepo.getAll();
            for (salary salary : salaryList) {
                salaryTm tm = new salaryTm(
                        salary.getSalary_no(),
                        salary.getEmployee_id(),
                        salary.getDate(),
                        salary.getAmount()
                );

                obList.add(tm);
            }

            tblSalary.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colNo.setCellValueFactory(new PropertyValueFactory<>("salary_no"));
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employee_id"));
        colPaymentDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

    }






    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        int salary_no = Integer.parseInt(txtSalaryno.getText());

        String sql = "DELETE FROM salary WHERE salary_no =?";

        try {
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1,salary_no);

            boolean isDeleted = pstm.executeUpdate() > 0;
            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "data Deleted Successfully").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }



    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException {
        int salary_no = Integer.parseInt(txtSalaryno.getText());
        int employee_id = Integer.parseInt(txtEmployeeId.getText());
        String date = (txtDate.getText());
        String amount = txtAmount.getText();

        String sql = "UPDATE salary SET employee_id =?, date =?, amount =? WHERE salary_no =?";

        boolean isUpdate = salaryRepo.update2(salary_no, employee_id,date, amount);
        if (isUpdate) {
            new Alert(Alert.AlertType.INFORMATION, "data Updated Successfully").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "data Not Updated").show();
        }
    }


    @FXML
    void txtSalaryOnAction(ActionEvent event) {
        int salary_no = Integer.parseInt(txtSalaryno.getText());

        String sql = "SELECT * FROM salary WHERE salary_no =?";

        try{
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1, Integer.parseInt(String.valueOf(salary_no)));

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                int employee_id = resultSet.getInt(2);
                String date = (resultSet.getString(3));
                String amount = resultSet.getString(4);


                txtEmployeeId.setText(String.valueOf(employee_id));
                txtDate.setText(String.valueOf(date));
                txtAmount.setText(amount);

            } else {
                new Alert(Alert.AlertType.ERROR, "data Not Found").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,"data ID Not Found!");
        }
    }


}
