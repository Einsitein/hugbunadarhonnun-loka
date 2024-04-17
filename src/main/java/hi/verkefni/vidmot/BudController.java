package hi.verkefni.vidmot;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.fxml.FXML;
import hi.verkefni.vinnsla.CoinService;

/**
 * The BudController class is responsible for handling user interactions and
 * updating the view for the Bud application.
 * It implements the CoinObserver interface to receive notifications about
 * changes in the user's coin amount.
 */
public class BudController implements CoinObserver {

    private ViewSwitcher viewSwitcher = ViewSwitcher.getInstance();

    /**
     * Called when the user's coin amount changes.
     * Displays an information alert with the updated coin amount.
     *
     * @param newAmount the new coin amount
     */
    @Override
    public void onCoinChange(int newAmount) {

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Money money money");
        a.setContentText("Þú átt nú " + newAmount + " krónur");
        a.show();
    }

    /**
     * Switches the view to the "Heim" view when the "Heim" button is clicked.
     *
     * @param actionEvent the action event
     */
    @FXML
    protected void onHeim(ActionEvent actionEvent) {
        viewSwitcher.switchTo(View.HEIM);
    }

    /**
     * Adds 50 coins to the current user's coin amount when the "Get50" button is
     * clicked.
     *
     * @param actionEvent the action event
     */
    @FXML
    protected void onGet50(ActionEvent actionEvent) {
        CoinService.addCoins(viewSwitcher.getCurrentUser(), 50);
    }

    /**
     * Adds 100 coins to the current user's coin amount when the "Get100" button is
     * clicked.
     *
     * @param actionEvent the action event
     */
    @FXML
    protected void onGet100(ActionEvent actionEvent) {
        CoinService.addCoins(viewSwitcher.getCurrentUser(), 100);
    }

    /**
     * Adds 150 coins to the current user's coin amount when the "Get150" button is
     * clicked.
     *
     * @param actionEvent the action event
     */
    @FXML
    protected void onGet150(ActionEvent actionEvent) {
        CoinService.addCoins(viewSwitcher.getCurrentUser(), 150);
    }

    /**
     * Initializes the controller by adding itself as an observer to the current
     * user.
     */
    public void initialize() {
        viewSwitcher.getCurrentUser().addObserver(this);
    }

}
