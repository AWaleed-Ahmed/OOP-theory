package backend.controllers;

import backend.services.Authenticator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthenticatorController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label loginMessage;

    private final Authenticator authenticator = new Authenticator();

    @FXML
    public void switchToScene3(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (authenticator.login(username, password)) {
            loginMessage.setText("Login successful!");
            switchScene("/frontend/CalorieCalculator.fxml");
        } else {
            loginMessage.setText("Invalid credentials.");
        }
    }

    @FXML
    public void switchToScene5(ActionEvent event) {
        switchScene("/frontend/SignUp.fxml");
    }

    @FXML
    public void handleSignUp(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (!username.isEmpty() && !password.isEmpty()) {
            authenticator.signup(username, password);
            loginMessage.setText("Sign up successful. Please log in.");
            switchScene("/frontend/authenticator.fxml");
        } else {
            loginMessage.setText("Username or password cannot be empty.");
        }
    }

    private void switchScene(String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
