package game;

import javafx.scene.layout.Pane;

public class Chance extends Square{


    public Chance(String squareName, Integer id, Pane pane) {
        super(squareName, id, pane);
    }

    public void chanceConditions( int x) {

        switch (x) {

            case 2:
                System.out.println("You won beauty contest. collect Rs.200 from bank");
                break;
            case 3:
                System.out.println("Get out of the jail free");
                break;
            case 4:
                System.out.println("you donated rs.100 to the orphanage. pay Rs.100");
                break;
            case 5:
                System.out.println("You crossed the signal. pay fine RS.200");
                break;
            case 6:
                System.out.println("Go to jail");
                break;
            case 7:
                System.out.println("You won the debate. collect RS.100");
                break;
            case 8:
                System.out.println("General repair for properties. pay rs.100");
                break;
            case 9:
                System.out.println("Go back 3 spaces");
                break;
            case 10:
                System.out.println("Its ur birthday. collect rs.130");
                break;
            case 11:
                System.out.println("Go 4 spaces forward");
                break;
            case 12:
                System.out.println(" ");
                break;


        }
    }
}
