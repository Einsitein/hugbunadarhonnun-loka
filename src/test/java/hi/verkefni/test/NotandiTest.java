package hi.verkefni.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import hi.verkefni.vinnsla.Notandi;
import hi.verkefni.vinnsla.UserFactory;

class NotandiTest {

    private Notandi user = UserFactory.createUser("Testing", "1234");

    @Test
    void testGetAndSetPeningur() {
        user.setPeningur(16849);
        Assertions.assertEquals(16849, user.getPeningur());
    }

    @Test
    void testGetLykilord() {
        Assertions.assertEquals("1234", user.getLykilord());
    }

    @Test
    void testGetNotendaNafnAndLykilord() {
        Assertions.assertEquals("Testing", user.getNotendaNafn());
        Assertions.assertEquals("1234", user.getLykilord());
    }
}