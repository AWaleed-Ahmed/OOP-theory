package backend.controllers;

import backend.models.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label loginMessage;

    private final FileAuthenticator authenticator = new FileAuthenticator();

    @FXML
    public void initialize() {
        authenticator.loadUsersFromFile();
    }

    @FXML
    public void handleSignUp() {
        String username = usernameField.getText().trim();
        String passwordText = passwordField.getText().trim();

        if (username.isEmpty() || passwordText.isEmpty()) {
            showMessage("Fields cannot be empty!");
            return;
        }

        try {
            int password = Integer.parseInt(passwordText);
            User newUser = new User(username, password);
            authenticator.signup(newUser);
            showMessage("User registered successfully!");
        } catch (NumberFormatException e) {
            showMessage("Password must be a number.");
        }
    }

    @FXML
    public void switchToScene3() {
        String username = usernameField.getText().trim();
        String passwordText = passwordField.getText().trim();

        if (username.isEmpty() || passwordText.isEmpty()) {
            showMessage("Enter credentials.");
            return;
        }

        try {
            int password = Integer.parseInt(passwordText);
            User loginUser = new User(username, password);

            if (authenticator.authenticate(loginUser)) {
                navigate("/fxml/Scene3.fxml");
            } else {
                showMessage("Incorrect credentials.");
            }
        } catch (NumberFormatException e) {
            showMessage("Password must be a number.");
        }
    }

    @FXML
    public void switchToScene5() {
        navigate("/fxml/Scene5.fxml");
    }

    private void navigate(String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            System.err.println("Scene loading failed: " + e.getMessage());
        }
    }

    private void showMessage(String msg) {
        if (loginMessage != null) {
            loginMessage.setText(msg);
        } else {
            System.out.println(msg);
        }
    }
}
