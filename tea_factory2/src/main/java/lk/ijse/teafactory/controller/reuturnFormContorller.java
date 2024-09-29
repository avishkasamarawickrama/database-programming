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

public class reuturnFormContorller {

    @FXML
    private TableColumn<?, ?> colBagsNetWeight;

    @FXML
    private TableColumn<?, ?> colDelete;

    @FXML
    private TableColumn<?, ?> colRetrunOd;

    @FXML
    private TableColumn<?, ?> colReturnDate;

    @FXML
    private TableColumn<?, ?> colReturnReason;

    @FXML
    private TableColumn<?, ?> colTotalWeight;

    @FXML
    private TableColumn<?, ?> colTransportId;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtBagsNetWeight;

    @FXML
    private TextField txtReturnDate;

    @FXML
    private TextField txtReturnId;

    @FXML
    private TextField txtReturnReason;

    @FXML
    private TextField txtTotalWeight;

    @FXML
    private TextField txtBrokerName;

    @FXML
    private TextField txtTransportId;


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
        int return_id = Integer.parseInt(txtReturnId.getText());
        Date return_date = Date.valueOf(txtReturnDate.getText());
        String broker_name = txtBrokerName.getText();
        int transport_id = Integer.parseInt(txtTransportId.getText());
        String return_reason = txtReturnReason.getText();
        Double bags_net_weight = Double.valueOf(txtBagsNetWeight.getText());
        Double total_weight = Double.valueOf(txtTotalWeight.getText());





        String sql = "INSERT INTO returns VALUES(?, ?, ?)";

        try {
            Connection connection = lk.ijse.teafactory.db.DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            ((PreparedStatement) pstm).setObject(1,return_id);
            pstm.setObject(2, return_date);
            pstm.setObject(3, broker_name);
            pstm.setObject(4, transport_id);
            pstm.setObject(5, return_reason);
            pstm.setObject(6, bags_net_weight);
            pstm.setObject(7, total_weight);



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
        txtReturnId.setText("");
        txtReturnDate.setText("");
        txtBrokerName.setText("");
        txtTransportId.setText("");
        txtReturnReason.setText("");
        txtBagsNetWeight.setText("");
        txtTotalWeight.setText("");


    }
}
