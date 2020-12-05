package game;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Square {
    private final String SQUARE_NAME;
    private final Integer SQUARE_ID;
    private final Pane PANE;

    public Square(String squareName, Integer id, Pane pane){
        this.SQUARE_ID = id;
        this.SQUARE_NAME = squareName ;
        this.PANE = pane;
    }

    // trial
    public void addPlayerToSquare(Paint color){
        Circle c = new Circle();
        c.setRadius(5.0);
        c.setLayoutX(10.0);
        c.setLayoutY(20.0);
        c.setFill(color);
        this.PANE.getChildren().add(c);
    }

    public String getSQUARE_NAME() {
        return SQUARE_NAME;
    }

    public Integer getSQUARE_ID() {
        return SQUARE_ID;
    }

    public Pane getPANE() {
        return PANE;
    }
}

