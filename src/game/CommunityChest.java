package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class CommunityChest extends Square{
    public CommunityChest(String squareName, Integer id, Pane pane) {
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

                l.setText("You're sent to GO");
                yes.setOnAction(event -> {

                    player.setPosition(0);
                    l.setText("You landed in Go");
                });
                break;
            case 3:
                l.setText("Hospital fee. Pay rs.100");
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 100);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    l.setText("You paid the amount");
                });

                break;
            case 4:
               l.setText("Bank in ur favour, collect RS.200");
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                bank.giveMoneyToPlayer(player,200);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    l.setText("You received the amount");
                });
                break;
            case 5:
                l.setText("School fees. pay Rs.150");
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 150);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    l.setText("You paid the amount");
                });
                break;
            case 6:
                l.setText("Holiday fund. collect Rs.100");
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    bank.giveMoneyToPlayer(player,100);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    l.setText("You received the amount");
                });
                break;
            case 7:
                l.setText("You were fined dumping garbage. Pay RS.120");
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 120);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    l.setText("You paid the amount");
                });
                break;
            case 8:

                l.setText("Go 2 spaces forward");
                yes.setOnAction(event -> {
                    Integer currPos = player.getPosition();
                    Integer newPos = (currPos+ 2) % 28;
                    player.setPosition(newPos);
                    l.setText("You went 2 spaces forward");
                });
                break;
            case 9:
                l.setText("You did not wear a mask. Pay fine worth rs200");
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                bank.takeMoneyFromPlayer(player, 200);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    l.setText("You paid the amount");
                });
                break;
            case 10:
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                l.setText("You got third place in dance competition. Collect Rs.200");
                bank.giveMoneyToPlayer(player,200);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    l.setText("You received the amount");
                });
                break;
            case 11:
                l.setText("Go to Pub");
                yes.setOnAction(event -> {

                    player.setPosition(14);
                    l.setText("You landed in pub");
                });

                break;
            case 12:
                l.setText("You won a lottery. Collect Rs.150");
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                bank.giveMoneyToPlayer(player,150);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    l.setText("You received the amount");
                });
                break;

        }
        return squareNext;
    }
}
