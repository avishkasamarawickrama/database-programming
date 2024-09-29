package lk.ijse.teafactory.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.teafactory.model.brokerDetail;
import lk.ijse.teafactory.model.tm.brokerDetailTm;
import lk.ijse.teafactory.model.tm.brokerTm;
import lk.ijse.teafactory.repository.brokerDetailsRepo;
import lk.ijse.teafactory.repository.brokerRepo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class brokerdetailsFormController {



    @FXML
    private TableColumn<?, ?> colBrokerName;

    @FXML
    private TableColumn<?, ?> colBuyer;

    @FXML
    private TableColumn<?, ?> colFirstprice;

    @FXML
    private TableColumn<?, ?> colLotNo;

    @FXML
    private TableColumn<?, ?> colProceeds;

    @FXML
    private TableColumn<?, ?> colSecondPrice;

    @FXML
    private TableColumn<?, ?> colTransporterId;

    @FXML
    private TableView<brokerDetailTm> tblBrokerDetails;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtBags;

    @FXML
    private TextField txtBrokerName;

    @FXML
    private TextField txtLastPrice;


    @FXML
    private TextField txtTotalWeight;

    @FXML
    private TextField txtBuyer;

    @FXML
    private TextField txtFirstPrice;

    @FXML
    private TextField txtGrade;

    @FXML
    private TextField txtLotNo;

    @FXML
    private TextField txtNetWeight;

    @FXML
    private TextField txtProceeds;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TextField txtSaleDate;

    @FXML
    private TextField txtSaleNo;

    @FXML
    private TextField txtSecondPrice;

    @FXML
    private TextField txtTransporterId;

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
        String broker_name = txtBrokerName.getText();
        int transport_id = Integer.parseInt(txtTransporterId.getText());
        int lot_no= Integer.parseInt(txtLotNo.getText());
        String grade= txtGrade.getText();
        String bags= txtBags.getText();
        Double net_weight= Double.valueOf(txtNetWeight.getText());
        Double total_weight= Double.valueOf(txtTotalWeight.getText());
        String buyer= txtBuyer.getText();
        Double first_price= Double.valueOf(txtFirstPrice.getText());
        Double second_price= Double.valueOf(txtSecondPrice.getText());
        Double last_price= Double.valueOf(txtLastPrice.getText());
        Double proceeds= Double.valueOf(txtProceeds.getText());



        String sql = "INSERT INTO broker_details VALUES(?, ?, ?,?,?,?,?, ?, ?,?,?,?)";

        try {
            Connection connection = lk.ijse.teafactory.db.DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            ((PreparedStatement) pstm).setObject(1, broker_name);
            pstm.setObject(2, transport_id);
            pstm.setObject(3, lot_no);
            pstm.setObject(3, bags);
            pstm.setObject(3, net_weight);
            pstm.setObject(3, total_weight);
            pstm.setObject(3, buyer);
            pstm.setObject(3, first_price);
            pstm.setObject(3, second_price);
            pstm.setObject(3, last_price);
            pstm.setObject(3, proceeds);


            boolean isSaved = pstm.executeUpdate() > 0;
            if(isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Broker details saved!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void clearFields() {
        txtBrokerName.setText("");
        txtTransporterId.setText("");
        txtLotNo.setText("");
        txtGrade.setText("");
        txtBags.setText("");
        txtNetWeight.setText("");
        txtTotalWeight.setText("");
        txtBuyer.setText("");
        txtFirstPrice.setText("");
        txtSecondPrice.setText("");
        txtLastPrice.setText("");
        txtProceeds.setText("");

    }





    public void initialize() {
        setCellDataFactory();
        loadAllCustomers();
    }

    private void setCellDataFactory() {
        colTransporterId.setCellValueFactory(new PropertyValueFactory<>("name"));
        colBrokerName.setCellValueFactory(new PropertyValueFactory<>("address"));
        colBuyer.setCellValueFactory(new PropertyValueFactory<>("status"));
        colLotNo.setCellValueFactory(new PropertyValueFactory<>("status"));
        colFirstprice.setCellValueFactory(new PropertyValueFactory<>("status"));
        colSecondPrice.setCellValueFactory(new PropertyValueFactory<>("status"));
        colProceeds.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    public void loadAllCustomers(){
        ObservableList<brokerDetailTm> brokerDetailTms = FXCollections.observableArrayList();

        try {
            List<brokerDetail> brokerDetailList = brokerDetailsRepo.getAll();
            for (brokerDetail brokerDetail : brokerDetailList) {
                brokerDetailTms.add(new brokerDetailTm(
                        brokerDetail.getBroker_name(),
                        brokerDetail.getTransport_id(),
                        brokerDetail.getLot_no(),
                        brokerDetail.getGrade(),
                        brokerDetail.getBags(),
                        brokerDetail.getNet_weight(),
                        brokerDetail.getTotal_weight(),
                        brokerDetail.getBuyer(),
                        brokerDetail.getFirst_price(),
                        brokerDetail.getSecond_price(),
                        brokerDetail.getLast_price(),
                        brokerDetail.getProceeds()

                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tblBrokerDetails.setItems(brokerDetailTms);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clear();
    }

    private void clear() {

        txtBrokerName.clear();
        txtTransporterId.clear();
        txtLotNo.clear();
        txtGrade.clear();
        txtBags.clear();
        txtNetWeight.clear();
        txtTotalWeight.clear();
        txtBuyer.clear();
        txtFirstPrice.clear();
        txtSecondPrice.clear();
        txtLastPrice.clear();
        txtProceeds.clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException {
        String id = txtBrokerName.getText();

        boolean isDeleted = brokerDetailsRepo.delete(id);

        if (isDeleted) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
            clear();
        }
        loadAllCustomers();
    }
}




