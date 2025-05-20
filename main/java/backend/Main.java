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
    private static final int MAX_USERS = 50;
    private static final int DEFAULT_USER_COUNT = 5;
    private static final String USER_FILE = "D:\\for java\\java projects\\main(1)\\users.txt";
    static Authenticator auth = new Authenticator();

    public void start(Stage stage) throws Exception {
        try {
            Parent root = (Parent)FXMLLoader.load((URL)Objects.requireNonNull(this.getClass().getResource("/frontend/SignIn.fxml")));
            stage.setScene(new Scene(root));
            stage.setTitle("Fitness Panda");
            stage.show();
            auth.loadUsersFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
