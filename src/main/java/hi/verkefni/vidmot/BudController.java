package hi.verkefni.vidmot;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.fxml.FXML;
import hi.verkefni.vinnsla.CoinService;

public class BudController implements CoinObserver {

    private ViewSwitcher viewSwitcher = ViewSwitcher.getInstance();

    @Override
    public void onCoinChange(int newAmount) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Takk fyrir að kaupa!");
        a.setContentText("Þú átt nú " + newAmount + " krónur");
        a.show();
    }

    @FXML
    protected void onHeim(ActionEvent actionEvent) {
        viewSwitcher.switchTo(View.HEIM);
    }

    @FXML
    protected void onGet50(ActionEvent actionEvent) {
        CoinService.addCoins(viewSwitcher.getCurrentUser(), 50);
    }

    @FXML
    protected void onGet100(ActionEvent actionEvent) {
        CoinService.addCoins(viewSwitcher.getCurrentUser(), 100);
    }

    @FXML
    protected void onGet150(ActionEvent actionEvent) {
        CoinService.addCoins(viewSwitcher.getCurrentUser(), 150);
    }

    public void initialize() {
        viewSwitcher.getCurrentUser().addObserver(this);
    }

}
