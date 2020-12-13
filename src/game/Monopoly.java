package game;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class Monopoly {
    public GridPane monopoly;
    public Label dice;
    public Pane p0GO, p1Bangalore, p2Chance1;
    public Pane pane;
    public Pane p17Delhi;
    public Pane p18Chance2;
    public Pane p20Jaipur;
    public Pane p19roadways;
    public Pane p21Resthouse;
    public Pane p27railroad;
    public Pane p22Community2;
    public Pane p24Electricity;
    public Pane p23Chandigarh;
    public Pane p25Indore;
    public Pane p26Kanpur;
    List<Player> players;
    private Integer numOfPlayers;
    Integer currentPlayerIndex;
    Player currentPlayer;
    List<Integer> initialRolls;
    Square[] board;
    Dice d1, d2;

    public void start() {
        d1 = new Dice();
        d2 = new Dice();

        Square go = new CornerBox("GO", 0, 200, p0GO);
        Square jail = new CornerBox("JAIL", 7, 100, null);
        Square pub = new CornerBox("PUB", 14, 250, null);
        Square resthouse = new CornerBox("restHouse", 21, 200, null);

        Square waterworks = new Company("WATERWORKS", 5, 150, 80, null);
        Square airways = new Company("AIRWAYS", 8, 320, 190, null);
        Square waterways = new Company("WATERWAYS", 15, 280, 110, null);
        Square roadways = new Company("ROADWAYS", 19, 170, 50, p19roadways);
        Square electricity = new Company("ELECTRICITY", 24, 180, 60, p24Electricity);
        Square railways = new Company("RAILWAYS", 27, 210, 90, p27railroad);

        Square bangalore = new City("Bangalore", 1, "Red", 300, new float[]{0, 0, 0, 0 }, p1Bangalore);
        Square hyderabad = new City("Hyderabad", 3, "Red", 220, new float[]{0, 0, 0, 0 }, null);
        Square mumbai = new City("Mumbai", 6, "Red", 500, new float[]{0, 0, 0, 0}, null);
        Square kolkata = new City("Kolkata", 10, "Yellow", 200, new float[]{0, 0, 0, 0}, null);
        Square pune = new City("Pune", 11, "Yellow", 400, new float[]{0, 0, 0, 0 }, null);
        Square patna = new City("Patna", 13, "Yellow", 230, new float[]{0, 0, 0, 0}, null);
        Square chennai = new City("Chennai", 16, "Blue", 300, new float[]{0, 0, 0, 0}, null);
        Square delhi = new City("Delhi", 17, "Blue", 450, new float[]{0, 0, 0, 0 }, p17Delhi);
        Square jaipur = new City("Jaipur", 20, "Blue", 260, new float[]{0, 0, 0, 0}, p20Jaipur);
        Square chandigarh = new City("Chandigarh", 23, "Green", 290, new float[]{0, 0, 0, 0}, p23Chandigarh);
        Square indore = new City("Indore", 25, "Green", 420, new float[]{0, 0, 0, 0 }, p25Indore);
        Square kanpur = new City("Kanpur", 26, "Green", 260, new float[]{0, 0, 0, 0}, p26Kanpur);

        Square chance1 = new Chance("chance1", 2, p2Chance1);
        Square chance2 = new Chance("chance2",18 ,p18Chance2);

        Square cchest1 = new CommunityChest("cchest1", 9,null);
        Square cchest2 = new CommunityChest("cchest2",22 ,p22Community2);

        Square incomeTax= new Square("Income Tax",4,null);
        Square luxuryTax= new Square("Luxury Tax",12,null);

        board = new Square[]{go, bangalore, chance1, hyderabad, incomeTax, waterworks, mumbai, jail, airways, cchest1,
                kolkata, pune, luxuryTax, patna, pub, waterways, chennai, delhi, chance2, roadways, jaipur,
                resthouse, cchest2, chandigarh, electricity, indore, kanpur, railways};

        currentPlayerIndex = getFirstPlayerIndex(players, d1, d2);
        currentPlayer = players.get(currentPlayerIndex);

        // temp
        for(Player p: players){
            board[0].addPlayerToSquare(p);
        }

        displayNamesInListView();

        nextMove(currentPlayer);
    }

    private void nextMove(Player currentPlayer) {
        currentPlayer.setTurn(true);

        Integer roll = currentPlayer.roll(d1, d2);
        Integer newPos = currentPlayer.getPosition()+ roll;
//        board[newPos].addPlayerToSquare(currentPlayer);
        currentPlayer.setPosition(newPos);

        currentPlayerIndex = (currentPlayerIndex + 1) % numOfPlayers;

//        currentPlayer.setTurn(false);
    }

    private void displayNamesInListView() {
        int i = 0;
        for (Player p : this.players) {
            Label l = new Label(p.getName() + "\t\t\t"+ initialRolls.get(i++));
            l.setTextFill(Color.WHITE);
            l.setStyle("-fx-background-color :"+p.getTokenColor()+";" + " -fx-padding: 10;" +"-fx-font-size: 18px;");
            l.setLayoutX(40.0);
            l.setMinWidth(200);
            l.setLayoutY(p.getId() * 50);
            l.setId(String.valueOf(p.getId()));
            pane.getChildren().add(l);
        }
    }

    private Integer getFirstPlayerIndex(List<Player> players, Dice d1, Dice d2) {
        initialRolls = new ArrayList<>();
        players.forEach(player -> {
            Integer roll1 = player.roll(d1, d2);
            initialRolls.add(roll1);
        });
        Integer max = findMaxSum(initialRolls);
//        Integer max = Collections.max(initialRolls)
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

    void removePlayer() {
        players.removeIf(p -> p.getPlayerMoney() == (float) 0.0);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setNumOfPlayers(Integer numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public Integer getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setPlayers(String[] names, String[] colors) {
        this.players = new ArrayList<>();
        int i = 0;
        for (String name: names) {
            Player p = new Player((i+1), name, colors[i]);
            players.add(p);
            i++;
        }
    }

}
