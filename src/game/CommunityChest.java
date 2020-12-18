package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class CommunityChest extends Square {
    public CommunityChest(String squareName, Integer id, Pane pane, String _imgPath) {
        super(squareName, id, pane, _imgPath);
    }


    public int task(Player player, Bank bank, Pane resPane) {
        Label l1 = (Label) resPane.getChildren().get(0);
        Label l = (Label) resPane.getChildren().get(1);
        Button yes = (Button) resPane.getChildren().get(2);
        Button no = (Button) resPane.getChildren().get(3);
        int squareNext = player.getPosition();
        switch (player.getCurrentRoll()) {
            case 2:

                l.setText("> monopoly init");
                yes.setOnAction(event -> {

                    player.setPosition(0);

                });
                break;
            case 3:
                l.setText("PC repairs. Pay Rs. 100");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 100);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 4:
                l.setText("You win bonus. Collect Rs. 200");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.giveMoneyToPlayer(player, 200);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 5:
                l.setText("Course Fees. Pay Rs.150");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 150);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 6:
                l.setText("Go take some time off you little nerd. Holiday fund. Collect Rs.100");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.giveMoneyToPlayer(player, 100);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 7:
                l.setText("Merge Conflict. Pay RS.120");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 120);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 8:

                l.setText("Go 2 spaces forward");
                yes.setOnAction(event -> {
                    Integer currPos = player.getPosition();
                    Integer newPos = (currPos + 2) % 28;
                    player.setPosition(newPos);

                });
                break;
            case 9:
                l.setText("Didn't show up at a sprint meeting. Pay fine Rs. 200");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 200);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 10:
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    l.setText("You got 3rd place in a Hackathon. Collect Rs.200");
                    bank.giveMoneyToPlayer(player, 200);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;
            case 11:
                l.setText("Go to the Pub");
                yes.setOnAction(event -> {

                    player.setPosition(14);

                });

                break;
            case 12:
                l.setText("PManager is happy. Collect Rs.150");
                yes.setOnAction(event -> {
                    System.out.println("Before: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                    bank.giveMoneyToPlayer(player, 150);
                    System.out.println("After: player" + player.getPlayerMoney() + " bank:" + bank.getBankMoney());
                });
                break;

        }
        return squareNext;
    }
}
