package game;

import javafx.scene.layout.Pane;

public class Company extends Square {
    private Integer cost;
    private Integer rent;

    public Company(String squareName, Integer id, Integer cost, Integer rent, Pane pane) {
        super(squareName, id, pane);
        this.cost = cost;
        this.rent = rent;
    }

    //s
    public void totalRent( Company company, Player player){
        if( company.getSQUARE_NAME() == "WATERWORKS" ){

        }
        else if (company.getSQUARE_NAME() == " AIRWAYS"){

        }
        else if (company.getSQUARE_NAME() == " WATERWAYS"){

        }
        else if (company.getSQUARE_NAME() == " ROADWAYS"){

        }
        else if (company.getSQUARE_NAME() == " ELECTRICITY"){

        }
        else if (company.getSQUARE_NAME() == " RAILWAYS"){

        }

    }


    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

}
