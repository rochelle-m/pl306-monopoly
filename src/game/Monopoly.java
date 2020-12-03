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
    Integer currentPlayerIndex;
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

    public void setPlayers(String[] names) {
        this.players = new ArrayList<>();
        int i = 0;
        for (String name: names) {
            Player p = new Player((i+1), name);
            players.add(p);
            i++;
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

        /* TODO Timer
           TODO square mapping
         */

        initialRolls = new ArrayList<>();

        Dice d1 = new Dice(),
                d2 = new Dice();

        currentPlayerIndex = getFirstPlayerIndex(players, d1, d2);
        currentPlayer = players.get(currentPlayerIndex);
        currentPlayer.setTurn(true);
        System.out.println("Who goes first? "+ currentPlayer.getName());
        System.out.println(currentPlayer.getName() + " moves " + currentPlayer.roll(d1, d2) + " squares");
        System.out.println("next player index: "+ (currentPlayerIndex + 1) % numOfPlayers);

    }

    private Integer getFirstPlayerIndex(List<Player> players, Dice d1, Dice d2) {

        players.forEach(player -> {
            Integer roll1 = player.roll(d1, d2);
            initialRolls.add(roll1);
            System.out.println(player.getName() + " rolls " + roll1);
        });
        Integer max = findMaxSum(initialRolls);
//        Integer max = Collections.max(initialRolls)
        playerList.getSelectionModel().select(initialRolls.indexOf(max));
        return initialRolls.indexOf(max);
    }

    public Integer findMaxSum(List <Integer> initialRolls) {
        int MaxVal = initialRolls.get(0);
        for (Integer initialRoll : initialRolls) {
            if (initialRoll > MaxVal) {
                MaxVal = initialRoll;
            }
        }
        return MaxVal;
    }

}


