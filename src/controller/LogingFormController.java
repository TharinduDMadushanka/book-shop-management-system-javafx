package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Admin;

import java.io.IOException;
import java.util.Optional;

public class LogingFormController {
    public TextField txtUserName;
    public PasswordField txtPassword;
    public AnchorPane context;
    public Button btnLogin;

    public void logingOnAction(ActionEvent actionEvent) throws IOException {
        String username = txtUserName.getText().toLowerCase();
        String password = txtPassword.getText().trim();

        Optional<Admin> selectAdmin = DBConnection.userTable.stream()
                .filter(e -> e.getUsername().equals(username))
                .findFirst();

        if (selectAdmin.isPresent()) {
            if (password.equals(selectAdmin.get().getPassword())) {
                new Alert(Alert.AlertType.INFORMATION,"Successfully logged in!").showAndWait();
                setUI("MainView");
            } else {
                new Alert(Alert.AlertType.ERROR, "Email or Password Incorrect...!").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "User Not Found...!").show();
        }
    }

    private void setUI(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/" + location + ".fxml"))));
        stage.show();
        stage.centerOnScreen();
    }
}
