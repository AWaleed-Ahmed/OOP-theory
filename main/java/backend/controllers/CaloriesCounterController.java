package backend.controllers;

import backend.services.CaloriesCounterService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public abstract class CaloriesCounterController {

    protected CaloriesCounterService service;

    // Shared FXML Elements
    @FXML protected Label requiredCalorieLable;

    // --- Scene 1: StandardCalorieCounterView.fxml ---
    @FXML protected TextField riceAmount, chickenAmount, beefAmount, wheatgrainsAmount;
    @FXML protected TextField milkAmount, chickpeasAmount, kidneyBeansAmount, bananaAmount;
    @FXML protected TextField eggAmount, muttonAmount, oatsAmount, peanutButterAmount;

    @FXML
    protected void switchToScene7(ActionEvent event) {
        // Placeholder: add logic to switch to CustomizedCalorieCounterView.fxml
        System.out.println("Switching to Customized Calorie Counter Scene (Scene 7)");
    }

    // --- Scene 2: CustomizedCalorieCounterView.fxml ---
    @FXML protected TextField itemNameField;
    @FXML protected TextField calorieField;
    @FXML protected TextField quantityField;
    @FXML protected Label totalCaloriesResultLabel;

    @FXML
    protected void switchToScene8(ActionEvent event) {
        // Placeholder: add logic to switch to another scene, like summary or dashboard
        System.out.println("Switching to Final Scene (Scene 8)");
    }

    @FXML
    protected void handleAddFoodItem(ActionEvent event) {
        String item = itemNameField.getText();
        String calories = calorieField.getText();
        String quantity = quantityField.getText();

        // Basic input check
        if (item.isEmpty() || calories.isEmpty() || quantity.isEmpty()) {
            totalCaloriesResultLabel.setText("Please fill in all fields.");
            return;
        }

        try {
            int cal = Integer.parseInt(calories);
            int qty = Integer.parseInt(quantity);
            int total = cal * qty;

            totalCaloriesResultLabel.setText(item + ": " + total + " kcal");
        } catch (NumberFormatException e) {
            totalCaloriesResultLabel.setText("Invalid calorie or quantity input.");
        }
    }
}
