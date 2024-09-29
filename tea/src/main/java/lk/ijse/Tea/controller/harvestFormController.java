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
import lk.ijse.Tea.model.Harvest;
import lk.ijse.Tea.model.tm.HarvestTm;
import lk.ijse.Tea.repo.HarvestRepo;

import java.sql.*;
import java.util.List;

public class harvestFormController {

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colFieldId;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<HarvestTm> tblHarvest;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtFieldId;

    @FXML
    private TextField txtHarvestId;

    @FXML
    private TextField txtQuantity;


    @FXML
    void btnSaveOnAction(ActionEvent event) {
        int harvest_no = Integer.parseInt(txtHarvestId.getText());
        int field_id = Integer.parseInt(txtFieldId.getText());
        int quantity = Integer.parseInt(txtQuantity.getText());
        String date = (txtDate.getText());


        String sql = "INSERT INTO harvest VALUES(?,?,?,?)";

        try {
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1,harvest_no);
            pstm.setInt(2,field_id);
            pstm.setInt(3,quantity);
            pstm.setString(4,date);


            boolean isSaved = pstm.executeUpdate() > 0;
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "harvest Saved Successfully").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }



    public void initialize() {

        setCellValueFactory();
        loadAllFields();
        System.out.println("Check");
    }
    private void loadAllFields() {
        ObservableList<HarvestTm> obList = FXCollections.observableArrayList();

        try {
            List<Harvest> harvestList = HarvestRepo.getAll();
            for (Harvest harvest : harvestList) {
                HarvestTm tm = new HarvestTm(
                        harvest.getHarvest_no(),
                        harvest.getField_id(),
                        harvest.getQuantity(),
                        harvest.getDate()

                );

                obList.add(tm);
            }

            tblHarvest.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("harvest_no"));
        colFieldId.setCellValueFactory(new PropertyValueFactory<>("field_id"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));


    }






    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        int id = Integer.parseInt(txtHarvestId.getText());

        String sql = "DELETE FROM harvest WHERE harvest_id =?";

        try {
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1,id);

            boolean isDeleted = pstm.executeUpdate() > 0;
            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "harvest Deleted Successfully").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }



    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException {
        int harvest_no = Integer.parseInt(txtHarvestId.getText());
        int field_id = Integer.parseInt(txtFieldId.getText());
        int quantity = Integer.parseInt(txtQuantity.getText());
        String date = txtDate.getText();


        String sql = "UPDATE harvest SET field_id =?, quantity =?,date=? WHERE harvest_no =?";


        boolean isUpdate = HarvestRepo.update2(harvest_no, field_id ,quantity,date);
        if (isUpdate) {
            new Alert(Alert.AlertType.INFORMATION, "data Updated Successfully").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "data Not Updated").show();
        }
    }


    @FXML
    void txtHarvestOnAction(ActionEvent event) {
        String id = txtHarvestId.getText();

        String sql = "SELECT * FROM harvest WHERE harvest_no =?";

        try{
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1, Integer.parseInt(id));

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                int field_id = resultSet.getInt(2);
                int  quantity = resultSet.getInt(3);
                String  date = resultSet.getString(4);


                txtFieldId.setText(String.valueOf(field_id));
                txtQuantity.setText(String.valueOf(quantity));
                txtDate.setText(date);


            } else {
                new Alert(Alert.AlertType.ERROR, "data Not Found").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,"data ID Not Found!");
        }
    }

}


