package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static final String APP_NAME = "Monopoly";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
        primaryStage.setTitle(APP_NAME);
        primaryStage.setScene(new Scene(root, 500, 475));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
