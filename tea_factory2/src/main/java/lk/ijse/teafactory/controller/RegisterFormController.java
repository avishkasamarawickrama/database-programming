package lk.ijse.teafactory.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterFormController {

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserId;

    @FXML
    private TextField txtUserName;

    public RegisterFormController(AnchorPane rootNode, TextField txtPassword, TextField txtUserId, TextField txtUserName) {
        this.rootNode = rootNode;
        this.txtPassword = txtPassword;
        this.txtUserId = txtUserId;
        this.txtUserName = txtUserName;
    }


    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String userid = txtUserId.getText();
        String username = txtUserName.getText();
        String password = txtPassword.getText();





        String sql = "INSERT INTO admin VALUES(?, ?, ?)";

        try {
            Connection connection = lk.ijse.teafactory.db.DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            ((PreparedStatement) pstm).setObject(1,userid);
            pstm.setObject(2, username);
            pstm.setObject(3, password);



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
        txtUserName.setText("");
        txtUserId.setText("");
        txtPassword.setText("");


    }
}
