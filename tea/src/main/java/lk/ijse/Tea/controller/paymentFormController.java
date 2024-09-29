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
import lk.ijse.Tea.model.payment;
import lk.ijse.Tea.model.tm.paymentTm;
import lk.ijse.Tea.repo.paymentRepo;

import java.sql.*;
import java.util.List;

public class paymentFormController {

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colMethod;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<paymentTm> tblPayment;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtMethod;

    @FXML
    private TextField txtPaymentId;

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        int payment_id = Integer.parseInt(txtPaymentId.getText());
        String payment_method = txtMethod.getText();
        Double amount = Double.valueOf(txtAmount.getText());
        String date = txtDate.getText();

        String sql = "INSERT INTO payment VALUES(?,?,?,?)";

        try {
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1, (payment_id));
            pstm.setString(2,payment_method);
            pstm.setDouble(3, amount);
            pstm.setString(4,date);

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
        loadAllpayments();
        System.out.println("Check");
    }
    private void loadAllpayments() {
        ObservableList<paymentTm> obList = FXCollections.observableArrayList();

        try {
            List<payment> paymentList = paymentRepo.getAll();
            for (payment payment : paymentList) {
                paymentTm tm = new paymentTm(
                        payment.getPayment_id(),
                        payment.getPayment_method(),
                        payment.getAmount(),
                        payment.getDate()
                );

                obList.add(tm);
            }

            tblPayment.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("payment_id"));
        colMethod.setCellValueFactory(new PropertyValueFactory<>("payment_method"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

    }






    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        int id = Integer.parseInt(txtPaymentId.getText());

        String sql = "DELETE FROM payment WHERE payment_id =?";

        try {
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1,id);

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
        int payment_id = Integer.parseInt(txtPaymentId.getText());
        String payment_method = txtMethod.getText();
        Double amount = Double.valueOf(Integer.parseInt(txtAmount.getText()));
        String date = (txtDate.getText());

        String sql = "UPDATE payment SET payment_method =?, amount =?, date =? WHERE payment_id =?";

        boolean isUpdate = paymentRepo.update2(payment_id, payment_method,amount, date);
        if (isUpdate) {
            new Alert(Alert.AlertType.INFORMATION, "data Updated Successfully").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "data Not Updated").show();
        }
    }


    @FXML
    void txtPaymentOnAction(ActionEvent event) {
        int id = Integer.parseInt(txtPaymentId.getText());

        String sql = "SELECT * FROM payment WHERE payment_id =?";

        try{
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1, Integer.parseInt(String.valueOf(id)));

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                String payment_method = resultSet.getString(2);
                Double amount = Double.valueOf(Integer.parseInt(String.valueOf(resultSet.getInt(3))));
                String date = resultSet.getString(4);


                txtMethod.setText(payment_method);
                txtAmount.setText(String.valueOf(amount));
                txtDate.setText(date);


            } else {
                new Alert(Alert.AlertType.ERROR, "data Not Found").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,"data ID Not Found!");
        }
    }

}

