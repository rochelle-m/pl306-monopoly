package game;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class Monopoly {
    public GridPane monopoly;
    public ListView<String> playerList;
    public Label dice;
    public Pane S1, S0;
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

    public void setPlayers(String[] names, Color[] colors) {
        this.players = new ArrayList<>();
        int i = 0;
        for (String name: names) {
            Player p = new Player((i+1), name, colors[i]);
            players.add(p);
            i++;
        }
    }

    public Integer getNumOfPlayers() {
        return numOfPlayers;
    }

    public void start() {
        // displays names in listview
        ObservableList<String> namesList = FXCollections.observableArrayList();
        for (Player p : this.players) {
            namesList.add(p.getName());
        }
        playerList.setItems(namesList);

        /*
            TODO Timer
         */

        Dice d1 = new Dice(),
                d2 = new Dice();

        initialRolls = new ArrayList<>();

        Square go = new CornerBox("GO", 0, 200, S0);
        Square jail = new CornerBox("JAIL", 7, 100, null);
        Square pub = new CornerBox("PUB", 14, 250, null);
        Square resthouse = new CornerBox("restHouse", 21, 200, null);

        Square waterworks = new Company("WATERWORKS", 5, 150, 80, null);
        Square airways = new Company("AIRWAYS", 8, 320, 190, null);
        Square waterways = new Company("WATERWAYS", 15, 280, 110, null);
        Square roadways = new Company("ROADWAYS", 19, 170, 50, null);
        Square electricity = new Company("ELECTRICITY", 24, 180, 60, null);
        Square railways = new Company("RAILWAYS", 27, 210, 90, null);

        Square bangalore = new City("Bangalore", 1, "Red", 300, new float[]{0, 0, 0, 0 }, S1);
        Square hyderabad = new City("Hyderabad", 3, "Red", 220, new float[]{0, 0, 0, 0 }, null);
        Square mumbai = new City("Mumbai", 6, "Red", 500, new float[]{0, 0, 0, 0}, null);
        Square kolkata = new City("Kolkata", 10, "Yellow", 200, new float[]{0, 0, 0, 0}, null);
        Square pune = new City("Pune", 11, "Yellow", 400, new float[]{0, 0, 0, 0 }, null);
        Square patna = new City("Patna", 13, "Yellow", 230, new float[]{0, 0, 0, 0}, null);
        Square chennai = new City("Chennai", 16, "Blue", 300, new float[]{0, 0, 0, 0}, null);
        Square delhi = new City("Delhi", 17, "Blue", 450, new float[]{0, 0, 0, 0 }, null);
        Square jaipur = new City("Jaipur", 20, "Blue", 260, new float[]{0, 0, 0, 0}, null);
        Square chandigarh = new City("Chandigarh", 23, "Green", 290, new float[]{0, 0, 0, 0}, null);
        Square indore = new City("Indore", 25, "Green", 420, new float[]{0, 0, 0, 0 }, null);
        Square kanpur = new City("Kanpur", 26, "Green", 260, new float[]{0, 0, 0, 0}, null);

        Square chance1 = new Chance("chance1", 2,null);
        Square chance2 = new Chance("chance2",18 ,null);

        Square cchest1 = new CommunityChest("cchest1", 9,null);
        Square cchest2 = new CommunityChest("cchest2",22 ,null);

        Square incomeTax= new Square("Income Tax",4,null);
        Square luxuryTax= new Square("Luxury Tax",12,null);

        Square[] board = {go, bangalore, chance1, hyderabad, incomeTax, waterworks, mumbai, jail, airways, cchest1,
                kolkata, pune, luxuryTax, patna, pub, waterways, chennai, delhi, chance2, roadways, jaipur,
                resthouse, cchest2, chandigarh, electricity, indore, kanpur, railways};


        currentPlayerIndex = getFirstPlayerIndex(players, d1, d2);
        currentPlayer = players.get(currentPlayerIndex);
        currentPlayer.setTurn(true);
        System.out.println("Who goes first? "+ currentPlayer.getName());

        // test
        Integer x = currentPlayer.getPosition()+ currentPlayer.roll(d1, d2);
        System.out.println(x);
//        list.get(1).addPlayerToSquare(currentPlayer.getTokenColor());
        board[1].addPlayerToSquare(currentPlayer.getTokenColor());
        currentPlayer.setPosition(currentPlayer.roll(d1, d2));
        System.out.println(currentPlayer.getPosition());
        // perform task
        System.out.println("next player index: "+ (currentPlayerIndex + 1) % numOfPlayers);

        ((Chance)chance1).chanceConditions(4);
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


