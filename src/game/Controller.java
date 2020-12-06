package game;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Arrays;

public class Controller {

    final String[] names = {"Chetana", "Shruti", "Rochelle", "Jane Doe"};
    final Color[] colors = {Color.DARKBLUE, Color.YELLOWGREEN, Color.SPRINGGREEN, Color.CRIMSON};
    final String[] colorsS = {"#00008B", "#9ACD32", "#00FF7F", "#DC143C"};
    public Button btnPlay;
    public Spinner spinner;

    public void play() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("monopoly.fxml"));
        Parent parent = loader.load();

        Monopoly monopoly = loader.getController();
        Integer numOfPlayers = (Integer) spinner.getValue();
        monopoly.setNumOfPlayers(numOfPlayers);
        monopoly.setPlayers(Arrays.copyOfRange(names, 0, numOfPlayers), Arrays.copyOfRange(colorsS, 0, numOfPlayers));
        monopoly.start();

        Stage stage = (Stage) btnPlay.getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.show();
    }
}
