import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public void printAllUsers(){
        for(User user: users){
            System.out.println(user.getName() + "(" + user.getAge() + ")");
        }
    }

    public User findByName(String name){
        for(User user : users){
            if(user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }

        return null;
    }


}
