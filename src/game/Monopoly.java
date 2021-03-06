package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Monopoly {
    public GridPane monopoly;
    public Pane p0GO, p1Bangalore, p2Chance1, pane, p3Hyderabad, p4IncomeTax, p5WaterWorks, p6Mumbai, p7Jail, p8Airways,
            p9Cchest1, p10Kolkata, p11Pune, p12luxuryTax, p13Patna, p14Pub, p15Waterways, p16Chennai, p17Delhi,
            p18Chance2, p20Jaipur, p19roadways, p21Resthouse, p27railroad, p22Community2, p24Electricity,
            p23Chandigarh, p25Indore, p26Kanpur;
    public Pane resultPane;
    public Label textLabel;
    public Button rollbtn;
    public Label currentPlayerLabel;
    public Pane playerPane;
    public Boolean gameOver = false;
    List<Player> players;
    Integer currentPlayerIndex;
    Player currentPlayer;
    Square[] board;
    Dice d1, d2;
    Bank bank;
    private Integer numOfPlayers;

    public void start() {
        d1 = new Dice();
        d2 = new Dice();

        Square go = new CornerBox("GO", 0, 200, p0GO);
        Square jail = new CornerBox("JAIL", 7, 100, p7Jail);
        Square pub = new CornerBox("PUB", 14, 250, p14Pub);
        Square resthouse = new CornerBox("Rest House", 21, 200, p21Resthouse);

        Square waterworks = new Company("WATERWORKS", 5, 150, 80, p5WaterWorks);
        Square airways = new Company("AIRWAYS", 8, 320, 190, p8Airways);
        Square waterways = new Company("WATERWAYS", 15, 280, 110, p15Waterways);
        Square roadways = new Company("ROADWAYS", 19, 170, 50, p19roadways);
        Square electricity = new Company("ELECTRICITY", 24, 180, 60, p24Electricity);
        Square railways = new Company("RAILWAYS", 27, 210, 90, p27railroad);

        Square bangalore = new City("Bangalore", 1, "Red",
                300, new float[]{150, 350, 550, 300}, p1Bangalore, new float[]{500, 350});
        Square hyderabad = new City("Hyderabad", 3, "Red",
                220, new float[]{100, 220, 450, 250}, p3Hyderabad, new float[]{300, 450});
        Square mumbai = new City("Mumbai", 6, "Red",
                500, new float[]{140, 290, 440, 310}, p6Mumbai, new float[]{300, 200});
        Square kolkata = new City("Kolkata", 10, "Yellow",
                200, new float[]{140, 290, 440, 310}, p10Kolkata, new float[]{300, 280});
        Square pune = new City("Pune", 11, "Yellow",
                400, new float[]{140, 290, 440, 320}, p11Pune, new float[]{200, 170});
        Square patna = new City("Patna", 13, "Yellow",
                230, new float[]{100, 210, 320, 210}, p13Patna, new float[]{200, 100});
        Square chennai = new City("Chennai", 16, "Blue",
                300, new float[]{140, 300, 440, 310}, p16Chennai, new float[]{400, 250});
        Square delhi = new City("Delhi", 17, "Blue",
                450, new float[]{120, 270, 420, 290}, p17Delhi, new float[]{300, 150});
        Square jaipur = new City("Jaipur", 20, "Blue",
                260, new float[]{0, 0, 0, 0}, p20Jaipur, new float[]{400, 125});
        Square chandigarh = new City("Chandigarh", 23, "Green",
                290, new float[]{140, 290, 440, 310}, p23Chandigarh, new float[]{400, 250});
        Square indore = new City("Indore", 25, "Green",
                420, new float[]{140, 290, 440, 310}, p25Indore, new float[]{400, 250});
        Square kanpur = new City("Kanpur", 26, "Green",
                260, new float[]{90, 190, 290, 180}, p26Kanpur, new float[]{200, 300});

        Square chance1 = new Chance("Chance", 2, p2Chance1);
        Square chance2 = new Chance("Chance", 18, p18Chance2);

        Square communityChest1 = new CommunityChest("Community Chest", 9, p9Cchest1);
        Square communityChest2 = new CommunityChest("Community Chest", 22, p22Community2);

        Square incomeTax = new Square("Income Tax", 4, p4IncomeTax);
        Square luxuryTax = new Square("Luxury Tax", 12, p12luxuryTax);

        board = new Square[]{go, bangalore, chance1, hyderabad, incomeTax, waterworks, mumbai, jail, airways, communityChest1,
                kolkata, pune, luxuryTax, patna, pub, waterways, chennai, delhi, chance2, roadways, jaipur,
                resthouse, communityChest2, chandigarh, electricity, indore, kanpur, railways};

        Label l = new Label();
        l.setId("q");
        l.setTextFill(Color.DARKSLATEBLUE);
        l.setStyle("-fx-padding: 10;" + "-fx-font-size: 16px;");
        l.setLayoutY(40.0);
        resultPane.getChildren().add(l);

        Button yes = new Button();
        yes.setTextFill(Color.WHITE);
        yes.setId("btnYes");
        yes.setStyle("-fx-background-color: green;");
        yes.setLayoutY(80.0);
        yes.setLayoutX(10.0);
        resultPane.getChildren().add(yes);

        Button no = new Button();
        no.setTextFill(Color.WHITE);
        no.setId("btn");
        no.setStyle("-fx-background-color: blue;");
        no.setLayoutY(80.0);
        no.setLayoutX(140.0);
        resultPane.getChildren().add(no);

        // initially
        players.forEach(p -> {
            board[0].addPlayerToSquare(p);
            p.roll(d1, d2);
        });

        currentPlayerIndex = getFirstPlayerIndex();
        currentPlayer = players.get(currentPlayerIndex);

        displayNamesInListView();

        currentPlayerLabel.setText(currentPlayer.getName() + " \uD83C\uDFB2 " + currentPlayer.getCurrentRoll());
        currentPlayerLabel.setTextFill(Color.DARKSLATEBLUE);
        currentPlayerLabel.setStyle("-fx-padding: 2;" + "-fx-font-size: 16px;");

        rollbtn.setOnAction(event -> {
            updateInListView();
            try {
                currentPlayerIndex = nextMove(currentPlayer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentPlayer = players.get(currentPlayerIndex);
        });
    }

    private Integer nextMove(Player currentPlayer) throws InterruptedException {
//        rollbtn.setDisable(true);
        removePlayer();

        Integer roll = currentPlayer.roll(d1, d2);
        currentPlayerLabel.setText(currentPlayer.getName() + " \uD83C\uDFB2 " + roll);
        Integer currPos = currentPlayer.getPosition();
        board[currPos].removePlayerFromSquare(currentPlayer);

        Integer newPos = (currPos + roll) % 28;
        board[newPos].addPlayerToSquare(currentPlayer);
        currentPlayer.setPosition(newPos);

        textLabel.setText(currentPlayer.getName() + "! You've landed in " + board[newPos].getSQUARE_NAME());
        textLabel.setTextFill(Color.DARKSLATEBLUE);
        textLabel.setStyle("-fx-padding: 2; -fx-font-size: 16px;");

        int a = board[newPos].task(currentPlayer, bank, resultPane);
        if(a > 0){
            rollbtn.setDisable(true);
            Thread.sleep(4000);
            textLabel.setText(currentPlayer.getName() + " ... ");
            board[newPos].removePlayerFromSquare(currentPlayer);
            board[a].addPlayerToSquare(currentPlayer);
            rollbtn.setDisable(false);
            return currentPlayerIndex;
        }

        rollbtn.setDisable(false);
        return (currentPlayerIndex + 1) % numOfPlayers;
    }

    private void displayNamesInListView() {
        this.players.forEach(p -> {
            Label l = new Label(p.getName() + "\t\t\uD83C\uDFB2 " + p.getCurrentRoll() + "\t\t\uD83D\uDCB0 " + p.getPlayerMoney());
            l.setTextFill(Color.WHITE);
            l.setId(p.getName());
            l.setStyle("-fx-background-color :" + p.getTokenColor() + ";" + " -fx-padding: 10;" + "-fx-font-size: 16px;");
            l.setLayoutX(8.0);
            l.setPrefWidth(300);
            l.setLayoutY((p.getId() - 1) * 50 + 10);

            playerPane.getChildren().add(l);
        });
    }

    private void updateInListView() {
        playerPane.getChildren().forEach(node -> {
            Stream<Player> pl = players.stream().filter(p -> p.getName().equals(node.getId()));
            Optional<Player> player = pl.findFirst();
            if (player.isPresent()) {
                Label n = (Label) node;
                n.setText(player.get().getName() + "\t\t\uD83C\uDFB2 " + player.get().getCurrentRoll() + "\t\t\uD83D\uDCB0 " +
                        player.get().getPlayerMoney());
            }
        });
    }

    private Integer getFirstPlayerIndex() {
        // get max roll
        Optional<Integer> max1 = players.stream().map(Player::getCurrentRoll).max(Integer::compare);
        Integer max = max1.get();

        // get player matching max roll
        Stream<Player> player = players.stream().filter(player1 -> player1.getCurrentRoll().equals(max));

        return player.findFirst().get().getId() - 1;
    }

    public Integer findMaxSum(List<Integer> initialRolls) {
        int MaxVal = initialRolls.get(0);
        for (Integer initialRoll : initialRolls) {
            if (initialRoll > MaxVal) {
                MaxVal = initialRoll;
            }
        }
        return MaxVal;
    }

    void removePlayer() {
        players.removeIf(p -> p.getPlayerMoney() <= (float) 0.0);
        if (players.size() == 1) {
            // we have a winner
            gameOver = true;
        }
    }

    public void initialise(String[][] playerDetails) {
        this.numOfPlayers = playerDetails.length;
        bank = new Bank(numOfPlayers * 10000);
        this.players = new ArrayList<>();
        int i = 0;
        for (String[] _players : playerDetails) {
            Player p = new Player((i + 1), _players[0], _players[1]);
            players.add(p);
            bank.giveMoneyToPlayer(p, 1500);
            i++;
        }
    }

}
