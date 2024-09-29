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
import lk.ijse.Tea.model.Customer;
import lk.ijse.Tea.model.tm.CustomerTm;
import lk.ijse.Tea.repo.CustomerRepo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class customerFormController {

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<CustomerTm> tblCustomer;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;



    @FXML
    void btnSaveOnAction(ActionEvent event) {
        int id = Integer.parseInt(txtCustomerId.getText());
        String name = txtName.getText();
        String contact = txtContactNo.getText();
        String email = txtEmail.getText();

        String sql = "INSERT INTO customer VALUES(?,?,?,?)";

        try {
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, String.valueOf(id));
            pstm.setString(2,name);
            pstm.setString(3,contact);
            pstm.setString(4,email);

            boolean isSaved = pstm.executeUpdate() > 0;
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Saved Successfully").show();
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
        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();

        try {
            List<Customer> customerList = CustomerRepo.getAll();
            for (Customer customer : customerList) {
                CustomerTm tm = new CustomerTm(
                        customer.getCustomer_id(),
                        customer.getCustomer_name(),
                        customer.getContact(),
                        customer.getEmail()
                );

                obList.add(tm);
            }

            tblCustomer.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

    }






    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        int id = Integer.parseInt(txtCustomerId.getText());

        String sql = "DELETE FROM customer WHERE customer_id =?";

        try {
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1,id);

            boolean isDeleted = pstm.executeUpdate() > 0;
            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Deleted Successfully").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }



    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException {
        int customer_id = Integer.parseInt(txtCustomerId.getText());
        String customer_name = txtName.getText();
        int contact = Integer.parseInt(txtContactNo.getText());
        String email = txtEmail.getText();

        String sql = "UPDATE customer SET customer_name =?, contact =?, email =? WHERE Customer_id =?";

        boolean isUpdate = CustomerRepo.update2(customer_id, customer_name,contact, email);
        if (isUpdate) {
            new Alert(Alert.AlertType.INFORMATION, "Customer Updated Successfully").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Customer Not Updated").show();
        }
    }


    @FXML
    void txtCustomerOnAction(ActionEvent event) {
        String id = txtCustomerId.getText();

        String sql = "SELECT * FROM customer WHERE customerId =?";

        try{
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1, Integer.parseInt(id));

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(2);
                int contact = Integer.parseInt(String.valueOf(resultSet.getInt(3)));
                String email = resultSet.getString(4);


                txtName.setText(name);
                txtContactNo.setText(String.valueOf(contact));
                txtEmail.setText(email);

            } else {
                new Alert(Alert.AlertType.ERROR, "Customer Not Found").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,"Customer ID Not Found!");
        }
    }

}
