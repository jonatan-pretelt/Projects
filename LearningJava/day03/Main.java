public class Main {
    public static void main(String[] args) {
        User user = new User("Jon", 31);
        UserService service = new UserService();

        System.out.println("User Info:");
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());

        // user.setAge(user.getAge() + 1);
        System.out.println("Next year you will be " + (user.getAge() + 1));

        service.celebrateBirthday(user);
    }
}
