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

    final String[] names = {"Chetana", "Shruti", "Rochelle", "Jane Doe"};


    final String[] colorsS = {"#800080", "#800000", "#404040", "#008080"};
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
