package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Chance extends Square {


    public Chance(String squareName, Integer id, Pane pane) {
        super(squareName, id, pane);
    }

    public int task(Player player, Bank bank, Pane resPane) {
        Label l1 = (Label) resPane.getChildren().get(0);
        Label l = (Label) resPane.getChildren().get(1);
        Button yes = (Button) resPane.getChildren().get(2);
        Button no = (Button) resPane.getChildren().get(3);
        int squareNext = player.getPosition();
        switch (player.getCurrentRoll()) {
            case 2:
                l.setText("You won a gaming competition. Collect Rs.200 from bank");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.giveMoneyToPlayer(player, 200);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 3:
                l.setText("You did not maintain social distancing. Pay fine worth Rs.100");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 100);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 4:
                l.setText("You won coding competition. Collect Rs.100");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.giveMoneyToPlayer(player, 100);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 5:
                l.setText("You've been hacked. Pay Rs.200 to recover");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 200);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 6:
                l.setText("DDOS attack incoming");
                yes.setOnAction(event -> {
                    player.setPosition(7);
                });
                break;
            case 7:
                l.setText("Learn Python. Course Fees Rs.100");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 100);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 8:
                l.setText("You won the debate. Collect RS.100");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.giveMoneyToPlayer(player, 100);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 9:
                l.setText("Go back 2 spaces. Oh life is such");
                yes.setOnAction(event -> {
                    Integer currPos = player.getPosition();
                    Integer newPos = (currPos - 2) % 28;
                    player.setPosition(newPos);

                });
                break;
            case 10:
                l.setText("It's your birthday! Collect Rs.150 and enjoy");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.giveMoneyToPlayer(player, 150);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 11:
                l.setText("Go 4 spaces forward");
                yes.setOnAction(event -> {
                    Integer currPos = player.getPosition();
                    Integer newPos = (currPos + 4) % 28;
                    player.setPosition(newPos);

                });
                break;
            case 12:
                l.setText("Sponsor for a tech event. Pay Rs. 150");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 150);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;


        }

        return squareNext;
    }

}
