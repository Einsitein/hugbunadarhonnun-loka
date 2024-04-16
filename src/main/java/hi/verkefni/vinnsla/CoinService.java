package hi.verkefni.vinnsla;

public class CoinService {

    private static int kubburCost = 20;

    private CoinService() {
        throw new UnsupportedOperationException("CoinService is a utility class and should not be instantiated.");
    }

    public static void addCoins(Notandi user, int amount) {
        int currentCoins = user.getPeningur();
        user.setPeningur(currentCoins + amount);
    }

    public static void subtractCoins(Notandi user, int amount) {
        int currentCoins = user.getPeningur();
        if (currentCoins < amount) {
            throw new IllegalArgumentException("Not enough coins");
        }
        user.setPeningur(currentCoins - amount);
    }

    public static boolean hasEnoughCoins(Notandi user) {
        return user.getPeningur() >= kubburCost;
    }

    public static int getKubburCost() {
        return kubburCost;
    }
}
