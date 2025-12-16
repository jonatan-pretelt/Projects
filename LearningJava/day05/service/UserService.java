package service;

import model.User;
import java.util.List;
import java.util.ArrayList;

public class UserService {
    private List<User> users = new ArrayList <>();

    public void addUser(String name, int age){
        users.add(new User(name, age));
    }

    public List<User> getAllUsers(){
        return users;
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
