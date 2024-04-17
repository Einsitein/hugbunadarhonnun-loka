package hi.verkefni.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import hi.verkefni.vinnsla.CoinService;

/**
 * The controller class for the Heima view.
 * This class handles the logic and event handling for the UI elements in the
 * Heima view.
 */
public class HeimaController {
    @FXML
    private Label fxUser;
    @FXML
    private Label fxCoins;
    @FXML
    private Button fxKubbur;
    @FXML
    private Button fxBud;
    @FXML
    private Button fxInnskraning;
    @FXML
    private Button fxNyskraning;
    @FXML
    private Button fxLogout;

    private ViewSwitcher viewSwitcher = ViewSwitcher.getInstance();

    private static final String ILAGI = "Ja!";
    private static final String NEI = "nei";

    /**
     * Initializes the Heima view.
     * This method is called automatically when the view is loaded.
     */
    public void initialize() {
        fxKubbur.getStyleClass().add("kubburOut");
        if (viewSwitcher.getCurrentUser() != null) {
            fxCoins.setText("Coins: " + String.valueOf(viewSwitcher.getCurrentUser().getPeningur()));
            fxUser.setText(viewSwitcher.getCurrentUser().getNotendaNafn());
            fxKubbur.setDisable(false);
            fxBud.setVisible(true);
            fxInnskraning.setVisible(false);
            fxNyskraning.setVisible(false);
            fxLogout.setVisible(true);
        } else {
            fxKubbur.setDisable(true);
            fxBud.setVisible(false);
            fxInnskraning.setVisible(true);
            fxNyskraning.setVisible(true);
            fxLogout.setVisible(false);
        }
    }

    @FXML
    protected void onLogout(ActionEvent actionEvent) {
        viewSwitcher.setCurrentUser(null);
        viewSwitcher.switchTo(View.HEIM);
    }

    @FXML
    protected void onKaupa(ActionEvent actionEvent) {
        viewSwitcher.switchTo(View.BUD);
    }

    @FXML
    protected void onNyskraning(ActionEvent actionEvent) {
        viewSwitcher.switchTo(View.NYSKRANING);
    }

    @FXML
    protected void onKubburPressed(ActionEvent actionEvent) {
        if (!CoinService.hasEnoughCoins(viewSwitcher.getCurrentUser())) {
            ButtonType bType = new ButtonType(ILAGI, ButtonBar.ButtonData.OK_DONE);
            ButtonType hType = new ButtonType(NEI, ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert a = new Alert(Alert.AlertType.WARNING,
                    "Þú þarft a.m.k." + CoinService.getKubburCost() + " krónur til að spila. Kaupa meira?", bType,
                    hType);
            a.setHeaderText("Ekki nægilegt fjármagn");

            a.showAndWait();
            if (a.getResult().equals(bType)) {
                viewSwitcher.switchTo(View.BUD);
            }
            return;
        }
        viewSwitcher.switchTo(View.KUBBUR);
    }

    @FXML
    protected void onInnskraning(ActionEvent actionEvent) {
        viewSwitcher.switchTo(View.INNSKRANING);
    }

    @FXML
    protected void inKubbur(MouseEvent mouseEvent) {
        fxKubbur.getStyleClass().remove("kubburOut");
        fxKubbur.getStyleClass().add("kubburIn");
    }

    @FXML
    protected void outKubbur(MouseEvent mouseEvent) {
        fxKubbur.getStyleClass().remove("kubburIn");
        fxKubbur.getStyleClass().add("kubburOut");
    }
}
