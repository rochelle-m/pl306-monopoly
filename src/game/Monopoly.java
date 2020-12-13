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
    public Label dice;
    public Pane p0GO, p1Bangalore, p2Chance1;
    public Pane pane;
    public Pane p3Hyderabad;
    public Pane p4IncomeTax;
    public Pane p5WaterWorks;
    public Pane p6Mumbai;
    public Pane p7Jail;
    public Pane p8Airways;
    public Pane p9Cchest1;
    public Pane p10Kolkata;
    public Pane p11Pune;
    public Pane p12luxaryTax;
    public Pane p13Patna;
    public Pane p14Pub;
    public Pane p15Waterways;
    public Pane p16Chennai;
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
        Square jail = new CornerBox("JAIL", 7, 100, p7Jail);
        Square pub = new CornerBox("PUB", 14, 250, p14Pub);
        Square resthouse = new CornerBox("restHouse", 21, 200, null);

        Square waterworks = new Company("WATERWORKS", 5, 150, 80, p5WaterWorks);
        Square airways = new Company("AIRWAYS", 8, 320, 190, p8Airways);
        Square waterways = new Company("WATERWAYS", 15, 280, 110, p15Waterways);
        Square roadways = new Company("ROADWAYS", 19, 170, 50, null);
        Square electricity = new Company("ELECTRICITY", 24, 180, 60, null);
        Square railways = new Company("RAILWAYS", 27, 210, 90, null);

        Square bangalore = new City("Bangalore", 1, "Red", 300, new float[]{0, 0, 0, 0 }, p1Bangalore);
        Square hyderabad = new City("Hyderabad", 3, "Red", 220, new float[]{0, 0, 0, 0 }, p3Hyderabad);
        Square mumbai = new City("Mumbai", 6, "Red", 500, new float[]{0, 0, 0, 0}, p6Mumbai);
        Square kolkata = new City("Kolkata", 10, "Yellow", 200, new float[]{0, 0, 0, 0}, p10Kolkata);
        Square pune = new City("Pune", 11, "Yellow", 400, new float[]{0, 0, 0, 0 }, p11Pune);
        Square patna = new City("Patna", 13, "Yellow", 230, new float[]{0, 0, 0, 0}, p13Patna);
        Square chennai = new City("Chennai", 16, "Blue", 300, new float[]{0, 0, 0, 0}, p16Chennai);
        Square delhi = new City("Delhi", 17, "Blue", 450, new float[]{0, 0, 0, 0 }, null);
        Square jaipur = new City("Jaipur", 20, "Blue", 260, new float[]{0, 0, 0, 0}, null);
        Square chandigarh = new City("Chandigarh", 23, "Green", 290, new float[]{0, 0, 0, 0}, null);
        Square indore = new City("Indore", 25, "Green", 420, new float[]{0, 0, 0, 0 }, null);
        Square kanpur = new City("Kanpur", 26, "Green", 260, new float[]{0, 0, 0, 0}, null);

        Square chance1 = new Chance("chance1", 2, p2Chance1);
        Square chance2 = new Chance("chance2",18 ,null);

        Square cchest1 = new CommunityChest("cchest1", 9,p9Cchest1);
        Square cchest2 = new CommunityChest("cchest2",22 ,null);

        Square incomeTax= new Square("Income Tax",4,p4IncomeTax);
        Square luxuryTax= new Square("Luxury Tax",12,p12luxaryTax);

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
