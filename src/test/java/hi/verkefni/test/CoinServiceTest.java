package hi.verkefni.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hi.verkefni.vinnsla.CoinService;
import hi.verkefni.vinnsla.Notandi;
import hi.verkefni.vinnsla.UserFactory;

class CoinServiceTest {

    private Notandi user = UserFactory.createUser("Testing", "1234");

    @BeforeEach
    public void setUp() {
        user.setPeningur(20);
    }

    @Test
    void testAddAndSubtractCoins() {
        int initialCoins = user.getPeningur();
        CoinService.addCoins(user, 10);
        Assertions.assertEquals(initialCoins + 10, user.getPeningur());
        CoinService.subtractCoins(user, 10);
        Assertions.assertEquals(initialCoins, user.getPeningur());
    }

    @Test
    void testHasEnoughCoins() {
        int kubburCost = CoinService.getKubburCost();
        user.setPeningur(kubburCost - 1);
        Assertions.assertFalse(CoinService.hasEnoughCoins(user));
        user.setPeningur(kubburCost);
        Assertions.assertTrue(CoinService.hasEnoughCoins(user));
    }


}