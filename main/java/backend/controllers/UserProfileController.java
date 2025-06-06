package backend.controllers;

import backend.models.UserProfile;
import backend.services.UserProfileService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UserProfileController {

    @FXML private TextField nameField;
    @FXML private TextField ageField;
    @FXML private TextField weightField;
    @FXML private TextField heightField;
    @FXML private Button maleButton;
    @FXML private Button femaleButton;
    @FXML private Label error;

    private String selectedGender;
    private final UserProfileService service = new UserProfileService();

    @FXML
    private void handleMaleGender(ActionEvent event) {
        selectedGender = "male";
    }

    @FXML
    private void handleFemaleGender(ActionEvent event) {
        selectedGender = "female";
    }

    @FXML
    private void switchToScene4(ActionEvent event) {
        try {
            UserProfile profile = new UserProfile();
            profile.setName(nameField.getText());
            profile.setAge(Integer.parseInt(ageField.getText()));
            profile.setWeight(Double.parseDouble(weightField.getText()));
            profile.setHeight(Double.parseDouble(heightField.getText()));
            profile.setGender(selectedGender);

            double bmi = service.calculateBMI(profile);
            String advice = service.getHealthAdvice(bmi);

            System.out.printf("BMICalculator: %.2f\nAdvice: %s%n", bmi, advice);

        } catch (IllegalArgumentException e) {
            error.setText("INVALID INPUT: " + e.getMessage());
        }
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
