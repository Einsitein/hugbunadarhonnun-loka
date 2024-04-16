package hi.verkefni.vidmot;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Application klasinn sem að keyrir forritið.
 * 
 * @author Einar Andri Víðisson
 */

public class KubburApplication extends Application {
    private ViewSwitcher viewSwitcher = ViewSwitcher.getInstance();

    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Pane());
        viewSwitcher.setScene(scene);
        viewSwitcher.switchTo(View.HEIM);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
