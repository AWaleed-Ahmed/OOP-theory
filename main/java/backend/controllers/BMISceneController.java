package backend.controllers;

import backend.models.BMICalculator;
import backend.models.UserProfile;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BMISceneController {

    @FXML
    private Label bmiLabel;

    @FXML
    private Label levelLabel;

    private UserProfile userProfile;

    public void setUserProfile(UserProfile profile) {
        this.userProfile = profile;
        updateBMIView();
    }

    private void updateBMIView() {
        BMICalculator calculator = new BMICalculator(userProfile);
        double bmi = calculator.calculateBMI();
        String tips = calculator.getHealthTips();

        bmiLabel.setText(String.format("%.2f", bmi));
        levelLabel.setText(tips.split("\n")[0]); // "YOU ARE ..."
    }

    @FXML
    private void switchToScene10() {
        // Implement scene transition logic here
    }
}
