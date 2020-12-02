package game;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {
    public Button btnPlay;
    public Spinner spinner;

    public void play() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("board.fxml"));
        Parent parent = loader.load();
        Board board = loader.getController();
        board.setNumOfPlayers((Integer) spinner.getValue());
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }
}
