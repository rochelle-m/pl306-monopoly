package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

public class Controller {
    public Button btnPlay;
    public Spinner spinner;
    public Label title;

    public void play() {
        System.out.println(spinner.getValue());
    }

}
