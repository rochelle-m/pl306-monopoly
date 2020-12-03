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
    Player currentPlayer;
    List<Integer> initialRolls;

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
            Player p = new Player(ids[i], names[i]);
            players.add(p);
        }
    }

    public Integer getNumOfPlayers() {
        return numOfPlayers;
    }

    public void start() {

        ObservableList<String> namesList = FXCollections.observableArrayList();
        for (Player p : this.players) {
            namesList.add(p.getName());
        }
        playerList.setItems(namesList);

        // start game

        /* TODO Timer


         */

        initialRolls = new ArrayList<>();

        Dice d1 = new Dice();
        Dice d2 = new Dice();

        currentPlayer = getFirstPlayer(players, d1, d2);
        System.out.println(currentPlayer.getName());
    }

    private Player getFirstPlayer(List<Player> players, Dice d1, Dice d2) {

        for (int i = 0; i < numOfPlayers; i++) {
            currentPlayer = players.get(i);
            Integer roll1 = currentPlayer.roll(d1, d2);
            initialRolls.add(roll1);
            System.out.println("This player rolls the dice " + currentPlayer.getName() + " with " + roll1);
        }
        Integer max = findMaxSum(initialRolls);
        playerList.getSelectionModel().select(initialRolls.indexOf(max));
        return players.get(initialRolls.indexOf(max));
    }

    public Integer findMaxSum(List <Integer> initialRolls) {

        int MaxVal = initialRolls.get(0);
        int indexOfMax = -1;
        for (int i = 0; i < initialRolls.size(); i++) {
            if (initialRolls.get(i) > MaxVal) {
                MaxVal = initialRolls.get(i);
                indexOfMax = i;

            }
        }
        return MaxVal;
    }

    



}


