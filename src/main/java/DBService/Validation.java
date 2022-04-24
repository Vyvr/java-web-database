package DBService;

public class Validation {
    public static boolean isAuthorized(String user, String password) {
        return user.equals("admin") && password.equals("123");
    }
}
