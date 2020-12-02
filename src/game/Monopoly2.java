package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Monopoly {
    List<Player> players;
    private Integer numOfPlayers;

    public Monopoly(Integer numOfPlayers) {
        Integer[] ids = {1, 2, 3, 4};
        String[] names = {"A", "B", "C", "D"};

        this.numOfPlayers = numOfPlayers;
        players = new ArrayList<>();
        IntStream.range(0, numOfPlayers).mapToObj(i -> new Player(ids[i], names[i], (float) 1000.00, false)).
                forEachOrdered(p -> players.add(p));


    }


    void removePlayer(){
        players.removeIf(p -> p.getPlayerMoney() == (float) 0.0);
    }

    public Integer getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(Integer numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }



}

