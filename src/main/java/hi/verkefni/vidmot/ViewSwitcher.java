package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Notandi;
import hi.verkefni.vinnsla.Notendur;
import hi.verkefni.vinnsla.UserFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * The ViewSwitcher class is a singleton class that manages the switching of
 * views in the application.
 */
public class ViewSwitcher {

    private Scene scene;

    public Notendur notendur = new Notendur();
    public Notandi currentUser;

    private static ViewSwitcher instance = null;

    private ViewSwitcher() {
        // private constructor
    }

    /**
     * Returns the single instance of the ViewSwitcher class.
     *
     * @return the single instance of the ViewSwitcher class
     */
    public static ViewSwitcher getInstance() {
        if (instance == null) {
            instance = new ViewSwitcher();
        }
        return instance;
    }

    /**
     * Creates a new user with the given username and password and adds it to the
     * list of users.
     *
     * @param s the username of the new user
     * @param t the password of the new user
     */
    public void newUser(String s, String t) {
        Notandi u = UserFactory.createUser(s, t);
        notendur.add(u);
        currentUser = u;
    }

    /**
     * Sets the current user to the given user.
     *
     * @param u the user to set as the current user
     */
    public void setCurrentUser(Notandi u) {
        currentUser = u;
    }

    /**
     * Returns the current user.
     *
     * @return the current user
     */
    public Notandi getCurrentUser() {
        return currentUser;
    }

    /**
     * Sets the scene to the given scene.
     *
     * @param scene the scene to set
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * Switches the view to the given view.
     *
     * @param view the view to switch to
     */
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
