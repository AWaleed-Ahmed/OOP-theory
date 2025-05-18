package backend;

import backend.models.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class SceneController {

    private final Authenticator auth;

    public SceneController() {
        this.auth = Main.auth;
    }

    // User Data Fields
    @FXML private TextField nameField, ageField, weightField, heightField;
    public String gender = "";
    private double weight;
    private double height;

    // Gender Handlers
    @FXML private void handleMaleGender() { gender = "Male"; }
    @FXML private void handleFemaleGender() { gender = "Female"; }

    // Login & SignUp Scene Switches
    public void switchToScene1(ActionEvent event) throws IOException { switchScene(event, "/frontend/SignIn.fxml"); }
    public void switchToScene2(ActionEvent event) throws IOException { switchScene(event, "/frontend/SignUp.fxml"); }

    public void switchToScene3(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Parent parent = source.getParent();
        TextField usernameField = (TextField) parent.lookup("#usernameField");
        PasswordField passwordField = (PasswordField) parent.lookup("#passwordField");
        Label loginMessage = (Label) parent.lookup("#loginMessage");

        String username = usernameField.getText();
        String passwordText = passwordField.getText();

        try {
            int password = Integer.parseInt(passwordText);
            auth.verifyusername(username);
            auth.verifypassword(password);
            if (auth.verify()) {
                switchScene(event, "/frontend/UserData(UI).fxml");
            } else {
                loginMessage.setText("Invalid username or password!");
            }
        } catch (NumberFormatException e) {
            loginMessage.setText("Password must be numeric!");
        }
    }

    public void handleSignUp(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Parent parent = source.getParent();
        TextField usernameField = (TextField) parent.lookup("#usernameField");
        PasswordField passwordField = (PasswordField) parent.lookup("#passwordField");

        String username = usernameField.getText();
        String passwordText = passwordField.getText();

        try {
            int password = Integer.parseInt(passwordText);
            auth.signup(username, password);
            switchToScene1(event);
        } catch (NumberFormatException e) {
            System.out.println("Password must be numeric.");
        }
    }
    public double bmi2;
    public void switchToScene4(ActionEvent event) throws IOException {
        try {
            int age = Integer.parseInt(ageField.getText());
            this.weight = Double.parseDouble(weightField.getText());
            this.height = Double.parseDouble(heightField.getText());

            UserData userData = new UserData();
            userData.setAge(age);
            userData.setGender(gender);
            userData.setWeigth(weight);
            userData.setHeigth(height);

            BMI_Calculation_Tips calc = new BMI_Calculation_Tips();
            calc.bmical(weight, height);
            double bmi = calc.index();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/BMI.fxml"));
            Parent bmiRoot = loader.load();

            Label bmiLabel = (Label) bmiRoot.lookup("#bmiLabel");
            Label levelLabel = (Label) bmiRoot.lookup("#levelLabel");

            String level = (bmi < 18.5) ? "Underweight"
                    : (bmi < 24.9) ? "Normal"
                    : (bmi < 30) ? "Overweight"
                    : "Obese";

            if (bmiLabel != null) bmiLabel.setText(String.format("%.2f", bmi));
            if (levelLabel != null) levelLabel.setText(level);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(bmiRoot));
            stage.show();

            this.bmi = bmi;
            bmi2 = bmi;

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values.");
        }
    }

    public void switchToScene5(ActionEvent event) throws IOException { switchScene(event, "/frontend/SignUp.fxml"); }
    public void switchToScene6(ActionEvent event) throws IOException { switchScene(event, "/frontend/CalorieCounter.fxml"); }

    public void switchToScene7(ActionEvent event) throws IOException {
        calculateTotalCalories();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/CalorieCalculator2.fxml"));
        Parent root = loader.load();

        SceneController scene2Controller = loader.getController();
        scene2Controller.receiveCaloriesFromScene1(this.totalCaloriesScene1);
        scene2Controller.setBmi(this.bmi);
        scene2Controller.setWeightAndHeight(this.weight, this.height);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        switchToScene8(event);
    }

    public void switchToScene8(ActionEvent event) throws IOException { switchScene(event, "/frontend/RankCalculator.fxml"); }
    public void switchToScene10(ActionEvent event) throws IOException { switchScene(event, "/frontend/FitnessGoals.fxml"); }

    public void switchScene(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            if (event == null) {
                System.out.println("Event is null! Scene cannot be switched.");
                return;
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final CalorieCalculator calorieCalculator = new CalorieCalculator();
    private double bmi = 22.0;

    @FXML private TextField riceAmount, chickenAmount, beefAmount, wheatgrainsAmount, milkAmount;
    @FXML private TextField chickpeasAmount, kidneyBeansAmount, bananaAmount, eggAmount;
    @FXML private TextField muttonAmount, oatsAmount, peanutButterAmount;

    @FXML private Label totalCaloriesResultLabel;
    @FXML private Label tips;

    @FXML private TextField itemNameField, calorieField, quantityField;

    private double totalCaloriesScene1 = 0;

    @FXML
    public void calculateTotalCalories() {
        double totalCalories = 0;
        try {
            totalCalories += getCaloriesFromInput(riceAmount, "rice");
            totalCalories += getCaloriesFromInput(chickenAmount, "chicken");
            totalCalories += getCaloriesFromInput(beefAmount, "beef");
            totalCalories += getCaloriesFromInput(wheatgrainsAmount, "wheatgrains");
            totalCalories += getCaloriesFromInput(milkAmount, "milk");
            totalCalories += getCaloriesFromInput(chickpeasAmount, "chickpeas");
            totalCalories += getCaloriesFromInput(kidneyBeansAmount, "kidneyBeans");
            totalCalories += getCaloriesFromInput(bananaAmount, "banana");
            totalCalories += getCaloriesFromInput(eggAmount, "egg");
            totalCalories += getCaloriesFromInput(muttonAmount, "mutton");
            totalCalories += getCaloriesFromInput(oatsAmount, "oats");
            totalCalories += getCaloriesFromInput(peanutButterAmount, "peanutButter");
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numbers");
            return;
        }

        this.totalCaloriesScene1 = totalCalories;
        System.out.println("Total Calories in Scene 1: " + totalCalories);
    }

    private int getCaloriesFromInput(TextField amountField, String foodKey) {
        String text = amountField.getText();
        if (text == null || text.isEmpty()) return 0;
        int grams = Integer.parseInt(text);
        return (int) CalorieCalculator.getCaloriesFromMap(foodKey, grams);
    }
    public void setBmi(double bmi) {
        this.bmi = bmi;
    }


    @FXML
    public void handleAddFoodItem(ActionEvent event) {
        System.out.println("Add button clicked!");

        if (itemNameField == null || calorieField == null || quantityField == null) {
            System.out.println("FXML fields not injected properly.");
            return;
        }

        try {
            String itemName = itemNameField.getText().trim();
            String calorieText = calorieField.getText().trim();
            String quantityText = quantityField.getText().trim();

            if (itemName.isEmpty() || calorieText.isEmpty() || quantityText.isEmpty()) {
                tips.setText("Please fill all fields.");
                return;
            }

            int caloriesPerUnit = Integer.parseInt(calorieText);
            int quantity = Integer.parseInt(quantityText);

            if (caloriesPerUnit < 0 || quantity < 0) {
                tips.setText("Calories and quantity must be positive.");
                return;
            }

            double addedCalories = caloriesPerUnit * quantity;
            totalCaloriesScene1 += addedCalories;

            calorieCalculator.addFoodItem(itemName, quantity, (double) caloriesPerUnit);

            updateTotalCaloriesDisplay();

            itemNameField.clear();
            calorieField.clear();
            quantityField.clear();

            String existingTips = tips.getText();
            tips.setText(existingTips + "\n\n✅ Item added successfully!");


        } catch (NumberFormatException e) {
            tips.setText("Please enter valid numeric values for calories and quantity.");
        } catch (Exception e) {
            tips.setText("⚠️ An unexpected error occurred.");
            e.printStackTrace();
        }
    }

    private void updateTotalCaloriesDisplay() {
        double userAddedCalories = calorieCalculator.getTotalCalories();
        double total = totalCaloriesScene1 + userAddedCalories;

        totalCaloriesResultLabel.setText("Total Calories: " + String.format("%.0f", total));

        BMI_Calculation_Tips bmiTips = new BMI_Calculation_Tips();
        String goalAdvice = "";
        if (bmi2 == 0.0) {
            goalAdvice = "BMI not calculated yet.";
        } else {
            goalAdvice = calorieCalculator.suggestPlanBasedOnBMIAndGoal(bmi2);
            tips.setText(goalAdvice);
        }

        tips.setText(goalAdvice);
    }

    public void receiveCaloriesFromScene1(double calories) {
        this.totalCaloriesScene1 = calories;

        // Show total in the label directly even if no food items added yet in Scene 2
        if (totalCaloriesResultLabel != null) {
            totalCaloriesResultLabel.setText("Total Calories: " + String.format("%.0f", totalCaloriesScene1));
        }

        // Show BMI suggestions if available
        if (this.weight > 0 && this.height > 0) {
            BMI_Calculation_Tips bmiTips = new BMI_Calculation_Tips();
            bmiTips.bmical(this.weight, this.height);
            this.bmi = bmiTips.index();


            String plan = calorieCalculator.suggestPlanBasedOnBMIAndGoal(this.bmi);

            if (tips != null) {
                tips.setText(plan);
            }
        }
    }


    public void setWeightAndHeight(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }
    private Stage stage;
    private Scene scene;
    @FXML private TextField pushupsField, pullupsField, squatsField, burpeesField, lungesField, situpsField;
    @FXML private Label rankLabel, suggestionLabel;

    @FXML
    public void switchToScene9(ActionEvent event) throws IOException {
        int pushups = parseInput(pushupsField.getText());
        int pullups = parseInput(pullupsField.getText());
        int squats = parseInput(squatsField.getText());
        int burpees = parseInput(burpeesField.getText());
        int lunges = parseInput(lungesField.getText());
        int situps = parseInput(situpsField.getText());

        int totalReps = pushups + pullups + squats + burpees + lunges + situps;

        String rank = WorkoutPlan.getRank(totalReps);
        String suggestion = WorkoutPlan.getSuggestion(rank);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/Rank+Suggestions.fxml"));
        Parent root = loader.load();

        SceneController controller = loader.getController();
        controller.setRankAndSuggestion(rank, suggestion);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    private int parseInput(String text) {
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void setRankAndSuggestion(String rank, String suggestion) {
        if (rankLabel != null) rankLabel.setText("Rank: " + rank);
        if (suggestionLabel != null) suggestionLabel.setText(suggestion);
    }
}

