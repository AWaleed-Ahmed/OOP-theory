package backend.controllers;

import backend.models.RankCalculator;
import backend.services.RankCalculatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class RankCalculatorController {

    @FXML private TextField pushupsField, pullupsField, squatsField, burpeesField, lungesField, situpsField;
    @FXML private Label rankLabel, suggestionLabel;

    @FXML
    public void switchToScene9(ActionEvent event) throws IOException {
        RankCalculator rankCalculator = new RankCalculator(
                parseInput(pushupsField.getText()),
                parseInput(pullupsField.getText()),
                parseInput(squatsField.getText()),
                parseInput(burpeesField.getText()),
                parseInput(lungesField.getText()),
                parseInput(situpsField.getText())
        );

        int totalReps = rankCalculator.getTotalReps();
        String rank = RankCalculatorService.getRank(totalReps);
        String suggestion = RankCalculatorService.getSuggestion(rank);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/WorkoutSuggestions.fxml"));
        Parent root = loader.load();

        RankCalculatorController controller = loader.getController();
        controller.displayRankAndSuggestion(rank, suggestion);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
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

    public void displayRankAndSuggestion(String rank, String suggestion) {
        if (rankLabel != null) rankLabel.setText("Rank: " + rank);
        if (suggestionLabel != null) suggestionLabel.setText(suggestion);
    }
}
