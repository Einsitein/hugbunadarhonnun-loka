package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Notandi;
import hi.verkefni.vinnsla.Notendur;
import hi.verkefni.vinnsla.UserFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ViewSwitcher {

    private Scene scene;

    public Notendur notendur = new Notendur();
    public Notandi currentUser;

    private static ViewSwitcher instance = null;

    private ViewSwitcher() {
        // private constructor
    }

    public static ViewSwitcher getInstance() {
        if (instance == null) {
            instance = new ViewSwitcher();
        }
        return instance;
    }

    public void newUser(String s, String t) {
        Notandi u = UserFactory.createUser(s, t);
        notendur.add(u);
        currentUser = u;
    }

    public void setCurrentUser(Notandi u) {
        currentUser = u;
    }

    public Notandi getCurrentUser() {
        return currentUser;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void switchTo(View view) {
        if (scene == null) {
            System.out.println("No scene was set");
            return;
        }

        try {
            Parent root;
            System.out.println("Loading from FXML");
            // lesa inn .fxml skrána og rótin verður root
            root = FXMLLoader.load(
                    ViewSwitcher.class.getResource(view.getFileName()));
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
