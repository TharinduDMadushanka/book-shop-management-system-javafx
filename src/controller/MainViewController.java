package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainViewController {
    public AnchorPane mainContext;

    public void dashBoardOnAction(ActionEvent actionEvent) {
        setUI("/view/DashBoard");
    }

    public void availableBooksOnAction(ActionEvent actionEvent) {
        setUI("/view/AvailableBook");
    }

    public void purchaseOnAction(ActionEvent actionEvent) {
    }

    public void signOutOnAction(ActionEvent actionEvent) {
    }

    public void addOnAction(ActionEvent actionEvent) {
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void clearOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    private void setUI(String location){
        try {
            mainContext.getChildren().clear();
            mainContext.getChildren().add(FXMLLoader.load(getClass().getResource(location + ".fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
