import controller.UserController;
import service.UserService;


public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        UserController controller = new UserController(userService);

        controller.start();
    }
}
