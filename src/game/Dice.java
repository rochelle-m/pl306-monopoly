package game;

import java.util.Random;
import javafx.util.Pair;

public class Dice {

    private Integer dice1;
    private Integer dice2;
    private Integer sumOfDice;

    public Dice(){
            this.dice1 =1;
            this.dice2 =1;

    }

    Random rand = new Random();

    public Pair<Integer,Integer> rollTheDice()
    {
        diceOperation(dice1);
        diceOperation(dice2);

        return new Pair<Integer, Integer>(dice1,dice2);
    }

    private int diceSum(){
        return dice1 + dice2;
    }

    public void diceOperation(Integer dice){
        rand.nextInt(6);
        while(true){
            if(dice != 0)
                break;
        }
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