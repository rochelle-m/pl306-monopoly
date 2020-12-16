package game;

import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;

public class Square {
    private final String SQUARE_NAME;
    private final Integer SQUARE_ID;
    private final Pane PANE;
    List<Player> players;

    public Square(String squareName, Integer id, Pane pane) {
        this.SQUARE_ID = id;
        this.SQUARE_NAME = squareName;
        this.PANE = pane;
    }

    public void addPlayerToSquare(Player player) {
        Circle c = new Circle();
        String color = player.getTokenColor();
        int r = Integer.parseInt(color.substring(1, 3), 16);
        int g = Integer.parseInt(color.substring(3, 5), 16);
        int b = Integer.parseInt(color.substring(5, 7), 16);
        c.setFill(Color.rgb(r, g, b));
        c.setId(player.getName());
        c.setRadius(8.0);
        c.setLayoutX(player.getId() * 18.0);
        c.setLayoutY(24.0);
        c.toFront();
        // something might break here
        this.PANE.getChildren().add(player.getId(), c);
        Tooltip.install(c, new Tooltip(player.getName()));
    }

    public void removePlayerToSquare(Player player) {
        this.PANE.getChildren().removeIf(p -> player.getName().equals(p.getId()));
    }

    void task(Player player, Bank bank, Pane resPane) {
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
