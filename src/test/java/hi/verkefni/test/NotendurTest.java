package hi.verkefni.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hi.verkefni.vinnsla.Notandi;
import hi.verkefni.vinnsla.Notendur;
import hi.verkefni.vinnsla.UserFactory;

class NotendurTest {

    private Notandi user = UserFactory.createUser("Testing", "1234");
    private Notendur users;

    @BeforeEach
    public void setUp() {
        users = new Notendur();
    }

    @Test
    void testAddUserAndContains() {
        users.add(user);
        Assertions.assertTrue(users.contains("Testing"));
    }

    @Test
    void testGetUser() {
        users.add(user);
        Assertions.assertEquals(user, users.getUser("Testing"));
    }
}