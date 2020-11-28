package game;

import java.util.Random;
import javafx.util.Pair;

public class Dice {

    private Integer dice1;
    private Integer dice2;

    public Dice(Integer dice1, Integer dice2){
            this.dice1 = dice1;
            this.dice2 = dice2;
    }

    Random rand = new Random();

    public Pair<Integer,Integer> rollTheDice()
    {
        diceOperation(dice1);
        diceOperation(dice2);

        return new Pair<Integer, Integer>(dice1,dice2);
    }

    //returns sum of dice
    private int diceSum(){
        return dice1 + dice2;
    }

    public void diceOperation(Integer dice){
        dice = rand.nextInt(6)+1;
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

}