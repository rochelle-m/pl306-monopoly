package game;

import javafx.scene.layout.GridPane;

import java.util.List;

public class Board{
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

}
