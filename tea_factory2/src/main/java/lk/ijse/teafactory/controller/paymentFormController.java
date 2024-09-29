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

public class paymentFormController {


    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colBrokerName;

    @FXML
    private TableColumn<?, ?> colDelete;

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colPayment;

    @FXML
    private TableColumn<?, ?> colSaleNo;

    @FXML
    private TableColumn<?, ?> colTax;

    @FXML
    private TableColumn<?, ?> colType;


    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtBrokerName;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtPayDate;

    @FXML
    private TextField txtPayType;

    @FXML
    private TextField txtPayment;

    @FXML
    private TextField txtPaymentId;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TextField txtReciever;

    @FXML
    private TextField txtSaleNo;

    @FXML
    private TextField txtTax;

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
        int payment_id = Integer.parseInt(txtPaymentId.getText());
        String pay_type = txtPayType.getText();
        Date pay_date = Date.valueOf(txtPayDate .getText());
        Double amount= Double.valueOf(Integer.parseInt((txtAmount.getText())));
        Double tax = Double.valueOf(Integer.parseInt(txtTax.getText()));
        int discount = Integer.parseInt(txtDiscount.getText());
        Double payment = Double.valueOf(Integer.parseInt(txtPaymentId.getText()));
        String receiver = String.valueOf(Integer.parseInt(txtReciever.getText()));
        int sale_no = Integer.parseInt(txtSaleNo.getText());
        String broker_name = String.valueOf(Integer.parseInt(txtBrokerName.getText()));





        String sql = "INSERT INTO orders VALUES(?, ?, ?,?,?,?)";

        try {
            Connection connection = lk.ijse.teafactory.db.DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            ((PreparedStatement) pstm).setObject(1,payment_id);
            pstm.setObject(2, pay_type);
            pstm.setObject(3, pay_date);
            pstm.setObject(4, amount);
            pstm.setObject(5, tax);
            pstm.setObject(6, discount);
            pstm.setObject(7, payment);
            pstm.setObject(8, receiver);
            pstm.setObject(9, sale_no);
            pstm.setObject(10, broker_name);



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
        txtPaymentId.setText("");
        txtPayType.setText("");
        txtPayDate.setText("");
        txtAmount.setText("");
        txtTax.setText("");
        txtDiscount.setText("");
        txtPayment.setText("");
        txtReciever.setText("");
        txtSaleNo.setText("");
        txtBrokerName.setText("");

    }
}
