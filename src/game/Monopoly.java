package game;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class Monopoly {
    public GridPane monopoly;
    public Pane p0GO, p1Bangalore, p2Chance1, pane, p3Hyderabad, p4IncomeTax,p5WaterWorks, p6Mumbai, p7Jail, p8Airways,
                p9Cchest1, p10Kolkata, p11Pune, p12luxuryTax, p13Patna, p14Pub, p15Waterways, p16Chennai, p17Delhi,
                p18Chance2, p20Jaipur, p19roadways, p21Resthouse, p27railroad, p22Community2, p24Electricity,
                p23Chandigarh, p25Indore, p26Kanpur;
    public Pane resultPane;
    public Label textLabel;
    public Boolean gameOver = false;

    List<Player> players;
    private Integer numOfPlayers;
    Integer currentPlayerIndex;
    Player currentPlayer;
    List<Integer> initialRolls;
    Square[] board;
    Dice d1, d2;
    Bank bank;

    public void start() {
        d1 = new Dice();
        d2 = new Dice();

        bank = new Bank(numOfPlayers * 10000);

        Square go = new CornerBox("GO", 0, 200, p0GO);
        Square jail = new CornerBox("JAIL", 7, 100, p7Jail);
        Square pub = new CornerBox("PUB", 14, 250, p14Pub);
        Square resthouse = new CornerBox("restHouse", 21, 200, p21Resthouse);

        Square waterworks = new Company("WATERWORKS", 5, 150, 80, p5WaterWorks);
        Square airways = new Company("AIRWAYS", 8, 320, 190, p8Airways);
        Square waterways = new Company("WATERWAYS", 15, 280, 110, p15Waterways);
        Square roadways = new Company("ROADWAYS", 19, 170, 50, p19roadways);
        Square electricity = new Company("ELECTRICITY", 24, 180, 60, p24Electricity);
        Square railways = new Company("RAILWAYS", 27, 210, 90, p27railroad);

        Square bangalore = new City("Bangalore", 1, "Red",
                300, new float[]{0, 0, 0, 0 }, p1Bangalore);
        Square hyderabad = new City("Hyderabad", 3, "Red",
                220, new float[]{0, 0, 0, 0 }, p3Hyderabad);
        Square mumbai = new City("Mumbai", 6, "Red",
                500, new float[]{0, 0, 0, 0}, p6Mumbai);
        Square kolkata = new City("Kolkata", 10, "Yellow",
                200, new float[]{0, 0, 0, 0}, p10Kolkata);
        Square pune = new City("Pune", 11, "Yellow",
                400, new float[]{0, 0, 0, 0 }, p11Pune);
        Square patna = new City("Patna", 13, "Yellow",
                230, new float[]{0, 0, 0, 0}, p13Patna);
        Square chennai = new City("Chennai", 16, "Blue",
                300, new float[]{0, 0, 0, 0}, p16Chennai);
        Square delhi = new City("Delhi", 17, "Blue",
                450, new float[]{0, 0, 0, 0 }, p17Delhi);
        Square jaipur = new City("Jaipur", 20, "Blue",
                260, new float[]{0, 0, 0, 0}, p20Jaipur);
        Square chandigarh = new City("Chandigarh", 23, "Green",
                290, new float[]{0, 0, 0, 0}, p23Chandigarh);
        Square indore = new City("Indore", 25, "Green",
                420, new float[]{0, 0, 0, 0 }, p25Indore);
        Square kanpur = new City("Kanpur", 26, "Green",
                260, new float[]{0, 0, 0, 0}, p26Kanpur);

        Square chance1 = new Chance("chance1", 2, p2Chance1);
        Square chance2 = new Chance("chance2",18 ,p18Chance2);

        Square communityChest1 = new CommunityChest("cchest1", 9,p9Cchest1);
        Square communityChest2 = new CommunityChest("cchest2",22 ,p22Community2);

        Square incomeTax= new Square("Income Tax",4,p4IncomeTax);
        Square luxuryTax= new Square("Luxury Tax",12,p12luxuryTax);

        board = new Square[]{go, bangalore, chance1, hyderabad, incomeTax, waterworks, mumbai, jail, airways, communityChest1,
                kolkata, pune, luxuryTax, patna, pub, waterways, chennai, delhi, chance2, roadways, jaipur,
                resthouse, communityChest2, chandigarh, electricity, indore, kanpur, railways};

        currentPlayerIndex = getFirstPlayerIndex(players, d1, d2);
        currentPlayer = players.get(currentPlayerIndex);

        for(Player p: players){
            board[0].addPlayerToSquare(p);
        }
        displayNamesInListView();

        // TODO new method passing control to players based on task & very basic UI / logging for player decisions
        // TODO generic type trial
        // TODO Display square property in a little popup
        currentPlayer.setTurn(true);

        currentPlayerIndex = nextMove(currentPlayer);
    }

    private Integer nextMove(Player currentPlayer) {
        Integer roll = currentPlayer.roll(d1, d2);
        Integer currPos = currentPlayer.getPosition();
        board[currPos].removePlayerToSquare(currentPlayer);

        Integer newPos = (currPos+ roll) % 28;
        //There's a bug here
        System.out.println(newPos);
        board[newPos].addPlayerToSquare(currentPlayer);
        currentPlayer.setPosition(newPos);

        textLabel.setText(currentPlayer.getName() + "! You've landed in "+ board[newPos].getSQUARE_NAME());
        textLabel.setTextFill(Color.DARKSLATEBLUE);
        textLabel.setStyle("-fx-padding: 2;" +"-fx-font-size: 16px;");

        board[newPos].task(currentPlayer, bank);

        return (currentPlayerIndex + 1) % numOfPlayers;
    }

    private void displayNamesInListView() {
        int i = 0;
        for (Player p : this.players) {
            Label l = new Label(p.getName() + "\t\t\t"+ initialRolls.get(i++));
            l.setTextFill(Color.WHITE);
            l.setStyle("-fx-background-color :"+p.getTokenColor()+";" + " -fx-padding: 10;" +"-fx-font-size: 16px;");
            l.setLayoutX(68.0);
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

        // TODO refactor @Chetana
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
