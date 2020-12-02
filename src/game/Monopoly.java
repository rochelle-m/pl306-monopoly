package game;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.List;

public class Monopoly {
    public GridPane monopoly;
    public ListView<String> playerList;
    public Label dice;
    List<Player> players;
    private Integer numOfPlayers;

    public void setNumOfPlayers(Integer numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    void removePlayer() {
        players.removeIf(p -> p.getPlayerMoney() == (float) 0.0);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers() {
        Integer[] ids = {1, 2, 3, 4};
        String[] names = {"Chetana", "Shruti", "Rochelle", "Jay"};
        this.players = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {
            Player p = new Player(ids[i],
                    names[i],
                    (float) 1000.00,
                    false);
            players.add(p);

        }
    }

    public Integer getNumOfPlayers() {
        return numOfPlayers;
    }

    public void start(Integer numOfPlayers) {
        setNumOfPlayers(numOfPlayers);
        setPlayers();
        ObservableList<String> namesList = FXCollections.observableArrayList();
        for (Player p : this.players) {
            namesList.add(p.getName());
        }
        playerList.setItems(namesList);

    }
}
