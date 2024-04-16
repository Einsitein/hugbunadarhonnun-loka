package hi.verkefni.vinnsla;

import hi.verkefni.vidmot.CoinObserver;
import java.util.ArrayList;
import java.util.List;

public class Notandi {
    private String notendaNafn;
    private String lykilord;
    private int peningur = 100;
    private List<CoinObserver> observers = new ArrayList<>();

    public Notandi(String notendanafn, String lykilord) {
        this.lykilord = lykilord;
        this.notendaNafn = notendanafn;
    }

    public int getPeningur() {
        return peningur;
    }

    public void setPeningur(int peningur) {
        this.peningur = peningur;
        notifyObservers();
    }

    public String getLykilord() {
        return lykilord;
    }

    public String getNotendaNafn() {
        return notendaNafn;
    }

    public void addObserver(CoinObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CoinObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (CoinObserver observer : observers) {
            observer.onCoinChange(peningur);
        }
    }

}
