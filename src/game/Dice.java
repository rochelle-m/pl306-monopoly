package game;

import java.util.Random;

public class Dice {

    Random rand = new Random();

    private int dice1;
    private Integer dice2;
    private Integer sumOfDice;

    public Dice( Integer dice1,  Integer dice2,  Integer sumOfDice){
            this.dice1 =  rand.nextInt(6);;
            while(true) {
                if(dice1 != 0)
                    break;
            }

            this.dice2 = rand.nextInt(7);
            while(true) {
                if(dice2 != 0)
                    break;
            }

           this.sumOfDice= dice1 + dice2;
    }

    public Integer getDice1() {
        return dice1;
    }

    public void setDice1(Integer dice1) {
        this.dice1 = dice1;
    }

    public Integer getDice2() {
        return dice2;
    }

    public void setDice2(Integer dice2) {
        this.dice2 = dice2;
    }

    public Integer getSumOfDice() {
        return sumOfDice;
    }

    public void setSumOfDice(Integer sumOfDice) {
        this.sumOfDice = sumOfDice;
    }
}