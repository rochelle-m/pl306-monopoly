package game;

import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class Monopoly implements Initializable {
    public GridPane board;
    List<Player> players;
    private Integer numOfPlayers;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers() {
        Integer[] ids = {1, 2, 3, 4};
        String[] names = {"A", "B", "C", "D"};
        this.players = new ArrayList<>();
        System.out.println(this.numOfPlayers);
        int bound = numOfPlayers;
        IntStream.range(0, bound).mapToObj(i -> new Player(ids[i], names[i], (float) 1000.00, false)).forEach(player -> players.add(player));
    }

    public Integer getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(Integer numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        setPlayers();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
