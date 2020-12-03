package game;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Arrays;

public class Controller {
    final String[] names = {"Chetana", "Shruti", "Rochelle", "Jay"};
    public Button btnPlay;
    public Spinner spinner;

    public void play() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("monopoly.fxml"));
        Parent parent = loader.load();
        Monopoly monopoly = loader.getController();
        monopoly.setNumOfPlayers((Integer) spinner.getValue());
        monopoly.setPlayers(Arrays.copyOfRange(names, 0, (Integer) spinner.getValue()));
        monopoly.start();
        Stage stage = (Stage) btnPlay.getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.show();
    }
}
