public class Main {
    public static void main(String[] args){
         UserService userService = new UserService();

        userService.addUser(new User("Jon", 31));
        userService.addUser(new User("Alice", 28));
        userService.addUser(new User("Bob", 35));

        userService.printAllUsers();

        User userFound = userService.findByName("Alice");

        if(userFound !=null){
            System.out.println("Found user: " + userFound.getName());
        }
    }
}


        

        

            