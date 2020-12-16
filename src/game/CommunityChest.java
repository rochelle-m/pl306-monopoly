package game;

import javafx.scene.layout.Pane;

public class CommunityChest extends Square{
    public CommunityChest(String squareName, Integer id, Pane pane) {
        super(squareName, id, pane);
    }

    public void ComChestConditions( int x,  Player curretPlayer, Bank bank) {

        switch (x) {

            case 2:
                System.out.println("Advance to GO");
                break;
            case 3:
                System.out.println("Hospital fee. Pay rs.100");
                bank.takeMoneyFromPlayer(curretPlayer, 100);
                break;
            case 4:
                System.out.println("Bank in ur favour, collect RS.200");
                bank.giveMoneyToPlayer(curretPlayer,200);
                break;
            case 5:
                System.out.println("School fees. pay Rs.150");
                bank.takeMoneyFromPlayer(curretPlayer, 150);
                break;
            case 6:
                System.out.println("Holiday fund. collect rs.100");
                bank.giveMoneyToPlayer(curretPlayer,100);
                break;
            case 7:
                System.out.println("You were fined dumping garbage. Pay RS.120");
                bank.takeMoneyFromPlayer(curretPlayer, 120);
                break;
            case 8:
                System.out.println("Go 2 spaces forward");
                break;
            case 9:
                System.out.println("You did not wear a mask. Pay fine worth rs200");
                bank.takeMoneyFromPlayer(curretPlayer, 200);
                break;
            case 10:
                System.out.println("You got third place in dance competition. collect rs200");
                bank.giveMoneyToPlayer(curretPlayer,200);
                break;
            case 11:
                System.out.println("go 5 spaces backward");
                break;
            case 12:
                System.out.println("You won a lottery. collect rs150");
                bank.giveMoneyToPlayer(curretPlayer,150);
                break;

        }
    }
}
