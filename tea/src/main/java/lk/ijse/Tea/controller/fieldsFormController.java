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
import lk.ijse.Tea.model.Fields;
import lk.ijse.Tea.model.tm.fieldsTm;
import lk.ijse.Tea.repo.fieldsRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class fieldsFormController {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<fieldsTm> tblFields;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtFieldsId;

    @FXML
    private TextField txtName;


    @FXML
    void btnSaveOnAction(ActionEvent event) {
        int field_id = Integer.parseInt(txtFieldsId.getText());
        String name = txtName.getText();
        String address = txtAddress.getText();


        String sql = "INSERT INTO field VALUES(?,?,?)";

        try {
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1,field_id);
            pstm.setString(2,name);
            pstm.setString(3,address);


            boolean isSaved = pstm.executeUpdate() > 0;
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "field Saved Successfully").show();
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
        ObservableList<fieldsTm> obList = FXCollections.observableArrayList();

        try {
            List<Fields> fieldList = fieldsRepo.getAll();
            for (Fields fields : fieldList) {
                fieldsTm tm = new fieldsTm(
                        fields.getField_id(),
                        fields.getName(),
                        fields.getAddress()

                );

                obList.add(tm);
            }

            tblFields.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("field_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));


    }






    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        int id = Integer.parseInt(txtFieldsId.getText());

        String sql = "DELETE FROM fields WHERE field_id =?";

        try {
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1,id);

            boolean isDeleted = pstm.executeUpdate() > 0;
            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Field Deleted Successfully").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }



    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException {
        int field_id = Integer.parseInt(txtFieldsId.getText());
        String name = txtName.getText();
        String address = txtAddress.getText();


        String sql = "UPDATE field SET name =?, address =? WHERE field_id =?";

        boolean isUpdate = fieldsRepo.update2(field_id, name ,address);
        if (isUpdate) {
            new Alert(Alert.AlertType.INFORMATION, "field Updated Successfully").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "field Not Updated").show();
        }
    }


    @FXML
    void txtFieldsOnAction(ActionEvent event) {
        String id = txtFieldsId.getText();

        String sql = "SELECT * FROM field WHERE field_id =?";

        try{
            Connection connection = Dbconnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setInt(1, Integer.parseInt(id));

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);


                txtName.setText(name);
                txtAddress.setText(String.valueOf(address));


            } else {
                new Alert(Alert.AlertType.ERROR, "field Not Found").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,"field ID Not Found!");
        }
    }

}
