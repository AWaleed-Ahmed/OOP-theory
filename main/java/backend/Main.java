package backend;

import java.net.URL;
import java.util.Objects;
import backend.models.Authenticator_old;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static final String USER_FILE = "D:\\for java\\java projects\\main(1)\\users.txt";  // User data storage path

    // Shared authentication instance
    static Authenticator_old auth = new Authenticator_old();

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