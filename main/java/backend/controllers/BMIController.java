package backend.controllers;

import backend.models.UserProfile;
import backend.services.BMIService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

public class BMIController {
    @FXML
    private Label bmiLabel;

    @FXML
    private Label levelLabel;

    private final BMIService bmiService = new BMIService();
    private UserProfile profile;

    public void setUserProfile(UserProfile profile) {
        this.profile = profile;
        updateBMIResults();
    }

    private void updateBMIResults() {
        if (profile == null) return;

        double bmiValue = bmiService.getBMI(profile);
        String level = bmiService.getBMICategory(bmiValue);

        bmiLabel.setText(String.format("%.2f", bmiValue));
        levelLabel.setText(level);
    }

    @FXML
    private void switchToScene10(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/StandardCalorieCounterView.fxml"));
            Scene nextScene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(nextScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}