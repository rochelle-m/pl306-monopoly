package game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {
    public Button btnPlay;
    public Spinner spinner;

        public void play(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent  root;
        stage = (Stage) btnPlay.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("board.fxml"));
        Monopoly monopoly = new Monopoly((Integer) spinner.getValue());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
