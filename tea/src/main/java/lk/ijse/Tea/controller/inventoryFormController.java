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
import lk.ijse.Tea.model.Inventory;
import lk.ijse.Tea.model.tm.inventoryTm;
import lk.ijse.Tea.repo.inventoryRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class inventoryFormController {

    @FXML
    private TableColumn<?, ?> colHarvestId;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<inventoryTm> tblInventory;

    @FXML
    private TextField txtCategoryName;

    @FXML
    private TextField txtCategoryid;

    @FXML
    private TextField txtHarvestid;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        int category_id = Integer.parseInt(txtCategoryid.getText());
        String category_name = txtCategoryName.getText();
        int quantity = Integer.parseInt(txtQuantity.getText());
        int harvest_no = Integer.parseInt((txtHarvestid.getText()));


        String sql = "INSERT INTO inventory VALUES(?,?,?,?)";

        try {
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1,category_id);
            pstm.setString(2,category_name);
            pstm.setInt(3,quantity);
            pstm.setInt(4,harvest_no);


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
        loadAllInventory();
        System.out.println("Check");
    }
    private void loadAllInventory() {
        ObservableList<inventoryTm> obList = FXCollections.observableArrayList();

        try {
            List<Inventory> inventoryList = inventoryRepo.getAll();
            for (Inventory inventory : inventoryList) {
                inventoryTm tm = new inventoryTm(
                        inventory.getCategory_id(),
                        inventory.getCategory_name(),
                        inventory.getQuantity(),
                        inventory.getHarvest_no(),
                        inventory.getUnit_price()

                );

                obList.add(tm);
            }

            tblInventory.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("category_id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("category_name"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colHarvestId.setCellValueFactory(new PropertyValueFactory<>("harvest_no"));


    }






    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        int id = Integer.parseInt(txtCategoryid.getText());

        String sql = "DELETE FROM inventory WHERE category_id =?";

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
        int category_id = Integer.parseInt(txtCategoryid.getText());
        String category_name = txtCategoryName.getText();
        int quantity = Integer.parseInt(txtQuantity.getText());
        int harvest_no = Integer.parseInt(txtHarvestid.getText());
        String unit_price =(txtUnitPrice.getText());


        String sql = "UPDATE inventory SET category_name =?, quantity =?,harvest_no=?,unit_price=? WHERE category_id =?";


        boolean isUpdate = inventoryRepo.update2(category_id, category_name ,quantity,harvest_no,unit_price);
        if (isUpdate) {
            new Alert(Alert.AlertType.INFORMATION, "data Updated Successfully").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "data Not Updated").show();
        }
    }


    @FXML
    void txtCategoryOnAction(ActionEvent event) {
        int id = Integer.parseInt(txtCategoryid.getText());

        String sql = "SELECT * FROM inventory WHERE category_id =?";

        try{
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1, Integer.parseInt(String.valueOf(id)));

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                String  category_name = String.valueOf(resultSet.getInt(2));
                int  quantity = Integer.parseInt(resultSet.getString(3));
                int  harvest_no = Integer.parseInt(resultSet.getString(4));


                txtCategoryName.setText((category_name));
                txtQuantity.setText(String.valueOf(quantity));
                txtHarvestid.setText(String.valueOf(harvest_no));


            } else {
                new Alert(Alert.AlertType.ERROR, "data Not Found").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,"data ID Not Found!");
        }
    }

}