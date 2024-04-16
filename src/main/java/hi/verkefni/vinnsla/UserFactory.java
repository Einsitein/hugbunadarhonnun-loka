package hi.verkefni.vinnsla;

public class UserFactory {
    public static Notandi createUser(String username, String password) {
        return new Notandi(username, password);
    }
}
