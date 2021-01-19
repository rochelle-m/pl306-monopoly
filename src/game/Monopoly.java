package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.io.FileNotFoundException;
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
    public Boolean gameOver = false;
    public Button rollbtn;
    public Label currentPlayerLabel;
    public Pane playerPane;

    List<Player> players;
    Integer currentPlayerIndex;
    Player currentPlayer;
    Square[] board;
    Dice d1, d2;
    Bank bank;
    private Integer numOfPlayers;

    public void start() throws FileNotFoundException {
        d1 = new Dice();
        d2 = new Dice();

        Square init = new CornerBox("init", 0, 200, p0GO, "images/init.jpg");
        Square ddos = new CornerBox("DDOS", 7, 100, p7Jail, "images/ddos.jpg");
//        Square gitpub = new CornerBox("GitPub", 14, 250, p14Pub, "");
//        Square resthouse = new CornerBox("Rest House", 21, 200, p21Resthouse, "");

//        Square ram = new Company("RAM", 5, 150, 80, p5WaterWorks, "");
//        Square gpu = new Company("GPU", 8, 320, 190, p8Airways, "");
//        Square processor = new Company("Processor", 15, 280, 110, p15Waterways, "");
//        Square monitor = new Company("Monitor", 19, 170, 50, p19roadways, "");
//        Square ssd = new Company("SSD", 24, 180, 60, p24Electricity, "");
//        Square io = new Company("I/O", 27, 210, 90, p27railroad, "");

        Square apple = new City("Apple", 1, "#FF3139",
                300, new float[]{150, 350, 550, 300}, p1Bangalore, new float[]{500, 350}, "images/apple.png");
        Square microsoft = new City("Microsoft", 3, "#FF3139",
                220, new float[]{100, 220, 450, 250}, p3Hyderabad, new float[]{300, 450}, "images/microsoft.jpg");
        Square google = new City("Google", 6, "#FF3139",
                500, new float[]{140, 290, 440, 310}, p6Mumbai, new float[]{300, 200}, "images/google.jpg");
        Square tencent = new City("Tencent", 10, "Yellow",
                200, new float[]{140, 290, 440, 310}, p10Kolkata, new float[]{300, 280}, "images/tencent.png");
        Square facebook = new City("Facebook", 11, "Yellow",
                400, new float[]{140, 290, 440, 320 }, p11Pune, new float[]{200, 170}, "images/facebook.png");
        Square ibm = new City("IBM", 13, "Yellow",
                230, new float[]{100, 210, 320, 210}, p13Patna, new float[]{200, 100}, "images/ibm.png");
        Square netflix = new City("Netflix", 16, "Blue",
                300, new float[]{140, 300, 440, 310}, p16Chennai, new float[]{400, 250}, "images/netflix.jpg");
        Square intel = new City("Intel", 17, "Blue",
                450, new float[]{120, 270, 420, 290 }, p17Delhi, new float[]{300, 150}, "images/intel.jpg");
        Square adobe = new City("Adobe", 20, "Blue",
                260, new float[]{0, 0, 0, 0}, p20Jaipur, new float[]{400, 125}, "images/adobe.png");
        Square oracle = new City("Oracle", 23, "Green",
                290, new float[]{140, 290, 440, 310}, p23Chandigarh, new float[]{400, 250}, "images/oracle.png");
        Square amazon = new City("Amazon", 25, "Green",
                420, new float[]{140, 290, 440, 310 }, p25Indore, new float[]{400, 250}, "images/amazon.jpg");
        Square cisco = new City("Cisco", 26, "Green",
                260, new float[]{90, 190, 290, 180}, p26Kanpur, new float[]{200, 300}, "images/cisco.jpg");
//
//        Square chance1 = new Chance("Chance", 2, p2Chance1, "");
//        Square chance2 = new Chance("Chance",18 ,p18Chance2,"");
//
//        Square communityChest1 = new CommunityChest("Comm. Chest", 9,p9Cchest1, "");
//        Square communityChest2 = new CommunityChest("Comm. Chest",22 ,p22Community2, "");
//
//        Square incomeTax= new Square("Income Tax",4,p4IncomeTax, "");
//        Square luxuryTax= new Square("Luxury Tax",12,p12luxuryTax, "");

//        board = new Square[]{init, apple, chance1, microsoft, incomeTax, ram, google, ddos, gpu, communityChest1,
//                kolkata, facebook, luxuryTax, ibm, gitpub, processor, netflix, intel, chance2, monitor, adobe,
//                resthouse, communityChest2, oracle, ssd, amazon, cisco, io};


        board = new Square[]{init, google};
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
        no.setLayoutX(60.0);
        resultPane.getChildren().add(no);

        // initially
        players.forEach(p -> {
            board[0].addPlayerToSquare(p);
            p.roll(d1, d2);
        });

        currentPlayerIndex = getFirstPlayerIndex();
        currentPlayer = players.get(currentPlayerIndex);

        displayNamesInListView();

        currentPlayerLabel.setText(currentPlayer.getName());
        currentPlayerLabel.setTextFill(Color.DARKSLATEBLUE);
        currentPlayerLabel.setStyle("-fx-padding: 2;" + "-fx-font-size: 16px;");

        rollbtn.setOnAction(event -> {
            currentPlayerIndex = nextMove(currentPlayer);
            currentPlayer = players.get(currentPlayerIndex);
            currentPlayerLabel.setText(currentPlayer.getName());
        });
    }

    private Integer nextMove(Player currentPlayer) {
//        rollbtn.setDisable(true);
        removePlayer();

        updateNameInListView(currentPlayer);
        Integer roll = currentPlayer.roll(d1, d2);
        Integer currPos = currentPlayer.getPosition();
        board[currPos].removePlayerToSquare(currentPlayer);

        Integer newPos = (currPos + roll) % 28;
        board[newPos].addPlayerToSquare(currentPlayer);
        currentPlayer.setPosition(newPos);

        textLabel.setText(currentPlayer.getName() + "! You've landed in " + board[newPos].getSQUARE_NAME());
        textLabel.setTextFill(Color.DARKSLATEBLUE);
        textLabel.setStyle("-fx-padding: 2;" + "-fx-font-size: 16px;");

        if(board[newPos].task(currentPlayer, bank, resultPane) > 0)
            updateNameInListView(currentPlayer);
        return (currentPlayerIndex + 1) % numOfPlayers;
    }

    private void displayNamesInListView() {
        // TODO set static pane
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

    private void updateNameInListView(Player player) {
        playerPane.getChildren().forEach(node -> {
            if (player.getName().equals(node.getId())) {
                Label n = (Label) node;
                n.setText(player.getName() + "\t\t\uD83C\uDFB2 " + player.getCurrentRoll() + "\t\t\uD83D\uDCB0 " + player.getPlayerMoney());
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


    void removePlayer() {
        players.removeIf(p -> p.getPlayerMoney() <= (float) 0.0);
        if(players.size() == 1){
            // we have a winner
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Integer getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(Integer numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public void setPlayersAndBank(String[] names, String[] colors) {
        bank = new Bank(numOfPlayers * 10000);
        this.players = new ArrayList<>();
        int i = 0;
        for (String name : names) {
            Player p = new Player((i + 1), name, colors[i]);
            players.add(p);
            bank.giveMoneyToPlayer(p, 1500);
            i++;
        }
    }

}
