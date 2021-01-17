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

    final String[][] PLAYER_DETAILS = {{"Chetana", "#800080"}, {"Shruti", "#800000"}, {"Rochelle", "#404040"}, {"Jane Doe", "#008080"}};

    public Button btnPlay;
    public Spinner spinner;

    public void play() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("monopoly.fxml"));
        Parent parent = loader.load();

        Monopoly monopoly = loader.getController();
        Integer numOfPlayers = (Integer) spinner.getValue();
        monopoly.initialise(Arrays.copyOfRange(PLAYER_DETAILS, 0, numOfPlayers));
        monopoly.start();

        Stage stage = (Stage) btnPlay.getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.setMaximized(true);
        stage.show();
    }
}
