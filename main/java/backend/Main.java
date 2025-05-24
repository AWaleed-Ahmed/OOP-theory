package backend;

import java.net.URL;
import java.util.Objects;
import backend.models.Authenticator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
//    Application configuration constants
//    private static final int MAX_USERS          = 50;   // Maximum user capacity
//    private static final int DEFAULT_USER_COUNT = 5;    // Default test user count
    private static final String USER_FILE = "D:\\for java\\java projects\\main(1)\\users.txt";  // User data storage path

    // Shared authentication instance
    static Authenticator auth = new Authenticator();

    // JavaFX application entry point
    public void start(Stage stage) throws Exception {
        try {
            // Display the login screen
            Parent root = (Parent)FXMLLoader.load((URL)Objects.requireNonNull(
                    this.getClass().getResource("/frontend/SignIn.fxml")));

            stage.setScene(new Scene(root));
            stage.setTitle("Fitness Panda");
            stage.show();

            auth.loadUsersFromFile();  // Initialize user data
        } catch (Exception e) {
            e.printStackTrace();  // Log initialization errors
        }
    }

    // Program execution starts here
    public static void main(String[] args) {
        launch(args);  // Start JavaFX application thread
    }
}