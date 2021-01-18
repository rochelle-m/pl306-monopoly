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
        int x = -1;
        switch (player.getCurrentRoll()) {
            case 2:
                l.setText("You won beauty contest. Collect Rs.200 from bank");
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
                l.setText("You won quiz competition. Collect Rs.100");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.giveMoneyToPlayer(player, 100);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 5:
                l.setText("You crossed the red signal. Pay fine RS.200");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 200);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 6:
                l.setText("Go to jail");

                player.setPosition(7);
                x = 7;
                break;
            case 7:
                l.setText("General repair for properties. Pay Rs.100");
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
                l.setText("Go back 2 spaces");
                    Integer newPos = (squareNext - 2) % 28;
                    player.setPosition(newPos);
                    x = newPos;


                break;
            case 10:
                l.setText("Its ur Birthday. Collect Rs.150");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.giveMoneyToPlayer(player, 150);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 11:
                l.setText("Go 4 spaces forward");

                Integer newPos2 = (squareNext + 4) % 28;
                player.setPosition(newPos2);
                x = newPos2;

                break;
            case 12:
                l.setText("You met with an accident. Pay Rs.150 as hospital charges");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 150);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;


        }

        return x;
    }

}
