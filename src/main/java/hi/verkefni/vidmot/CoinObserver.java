package hi.verkefni.vidmot;

/**
 * The CoinObserver interface represents an observer that is notified when the
 * amount of coins changes.
 */
public interface CoinObserver {
    /**
     * Called when the amount of coins changes.
     *
     * @param newAmount the new amount of coins
     */
    void onCoinChange(int newAmount);
}
