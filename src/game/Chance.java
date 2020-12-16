package game;

import javafx.scene.layout.Pane;

public class Chance extends Square{


    public Chance(String squareName, Integer id, Pane pane) {
        super(squareName, id, pane);
    }

    public void chanceConditions(int x, Player curretPlayer, Bank bank ) {

        switch (x) {

            case 2:
                System.out.println("You won beauty contest. collect Rs.200 from bank");
               bank.giveMoneyToPlayer(curretPlayer,200);

                break;
            case 3:
                System.out.println("Get out of the jail free");
                break;
            case 4:
                System.out.println("you donated rs.100 to the orphanage. pay Rs.100");
                bank.takeMoneyFromPlayer(curretPlayer, 100);
                break;
            case 5:
                System.out.println("You crossed the signal. pay fine RS.200");
                bank.takeMoneyFromPlayer(curretPlayer, 200);
                break;
            case 6:
                System.out.println("Go to jail");
                curretPlayer.getPosition();
                break;
            case 7:
                System.out.println("General repair for properties. pay rs.100");
                bank.takeMoneyFromPlayer(curretPlayer, 100);
                break;
            case 8:
                System.out.println("You won the debate. collect RS.100");
                bank.giveMoneyToPlayer(curretPlayer,100);
                break;
            case 9:
                System.out.println("Go back 3 spaces");

                break;
            case 10:
                System.out.println("Its ur birthday. collect rs.150");
                bank.giveMoneyToPlayer(curretPlayer,150);
                break;
            case 11:
                System.out.println("Go 4 spaces forward");
                break;
            case 12:
                System.out.println("You met with an accident. pay rs.150 as hospital charges");
                bank.takeMoneyFromPlayer(curretPlayer, 150);
                break;


        }


    }

}
