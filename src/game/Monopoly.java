package game;

import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Monopoly implements Initializable {
    public GridPane board;
    List<Player> players;
    private Integer numOfPlayers;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Integer getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(Integer numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
