public class UserService {
    public void celebrateBirthday(User user){
        int newAge = user.getAge() + 1;
        user.setAge(newAge);
        System.out.println(user.getName() + " is now " + newAge + "!");
    }
}
