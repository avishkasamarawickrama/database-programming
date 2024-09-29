package lk.ijse.teafactory.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class invoiceFormController {

    @FXML
    private TableColumn<?, ?> colFullOrHalf;

    @FXML
    private TableColumn<?, ?> colGrade;

    @FXML
    private TableColumn<?, ?> colInvoiceNo;

    @FXML
    private TableColumn<?, ?> colNetWeight;

    @FXML
    private TableColumn<?, ?> colNoOfPacc;

    @FXML
    private TableColumn<?, ?> coltotWeight;

    @FXML
    private AnchorPane rootNode;
    @FXML
    private TextField txtChessNo;

    @FXML
    private TextField txtDateofPacking;

    @FXML
    private TextField txtFullorHalf;

    @FXML
    private TextField txtGrade;

    @FXML
    private TextField txtInvoice;

    @FXML
    private TextField txtNetWeightSallowance;

    @FXML
    private TextField txtNetweight;

    @FXML
    private TextField txtNoOfPac;

    @FXML
    private TextField txtSampleAllow;

    @FXML
    private TextField txtTotalGrossWeight;

    @FXML
    private TextField txtTypeOfPacking;


    @FXML
    void btnLogOutOnAction(ActionEvent event){

    }

    @FXML
    void btnCategoryOnAction(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/categoryFinal.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("category Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnCoopmarketOnAction(ActionEvent event)  {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/coopmarketFinal.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("coop market Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/customerFinal.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("customerForm");
        stage.centerOnScreen();
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event)  {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/employeeFinal.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("employee Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnInventoryOnAction(ActionEvent event)  {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/inventoryFinal.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("inventory Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnInvoiceOnAction(ActionEvent event)  {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/invoiceFinal.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("invoice Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/orderFinal.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("order Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnPaymentsOnAction(ActionEvent event)  {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/paymentsFinal.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("payments Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnReturnsOnAction(ActionEvent event)  {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/returnFinal.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("retuns Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnSaleOnAction(ActionEvent event)  {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/saleFinal.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("sale Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnSellerOnAction(ActionEvent event)  {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/sellersFinal.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("seller Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnSettingsOnAction(ActionEvent event)  {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/settingsFinal.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("settings Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnTransportOnAction(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/transportFinal.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("transport Form");
        stage.centerOnScreen();
    }


    @FXML
    void btnSaveOnAction(ActionEvent event) {
        int invoice_no = Integer.parseInt(txtInvoice.getText());
        String grade = txtGrade.getText();
        String net_weight= txtNetweight.getText();
        int no_of_packages= Integer.parseInt(txtNoOfPac.getText());
        String full_or_half= txtFullorHalf.getText();
        Double total_gross_weight= Double.valueOf(txtTotalGrossWeight.getText());
        Date date_of_packing = Date.valueOf(txtDateofPacking.getText());
        int chess_number = Integer.parseInt(txtChessNo.getText());
        String type_of_packing = txtTypeOfPacking.getText();
        Double net_weight_loss_sallowance = Double.valueOf(txtNetWeightSallowance.getText());
        String sample_allow = txtSampleAllow.getText();




        String sql = "INSERT INTO invoice VALUES(?, ?, ?,?,?,?,?, ?, ?,?,?)";

        try {
            Connection connection = lk.ijse.teafactory.db.DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            ((PreparedStatement) pstm).setObject(1, invoice_no);
            pstm.setObject(2, grade);
            pstm.setObject(3, net_weight);
            pstm.setObject(4, no_of_packages);
            pstm.setObject(5, full_or_half);
            pstm.setObject(6, total_gross_weight);
            pstm.setObject(7, date_of_packing);
            pstm.setObject(8, chess_number);
            pstm.setObject(9, type_of_packing);
            pstm.setObject(10, net_weight_loss_sallowance);
            pstm.setObject(11, sample_allow);




            boolean isSaved = pstm.executeUpdate() > 0;
            if(isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, " data  saved!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void clearFields() {
        txtInvoice.setText("");
        txtGrade.setText("");
        txtNetweight.setText("");
        txtNoOfPac.setText("");
        txtFullorHalf.setText("");
        txtTotalGrossWeight.setText("");
        txtDateofPacking.setText("");
        txtChessNo.setText("");
        txtTypeOfPacking.setText("");
        txtNetWeightSallowance.setText("");
        txtSampleAllow.setText("");



    }
}
