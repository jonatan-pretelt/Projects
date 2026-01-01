package service;

import model.User;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class UserService {
    private List<User> users = new ArrayList <>();

    public void addUser(String name, int age){
        if(name == null || name.isBlank()){
            throw new InvalidUserException("Name cannot be empty");
        }
        if(age<=0){
            throw new InvalidUserException("Age must be positive");
        }
        users.add(new User(name, age));
    }

    public List<User> getAllUsers(){
        return users;
    }

    public Optional<User> findByName(String name){
        return users.stream().filter(user -> user.getName().equalsIgnoreCase(name)).findFirst();

    
    }
}
