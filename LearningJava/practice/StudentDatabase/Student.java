import java.util.Random;

public class Student {
    private static int ID = 1000;
    private String name;
    private String email;
    private String ssn;
    private String userId;
    private int balance;
    private short numCourses = 0;
    private String[] courses = new String[7];
    private String phone ="NA";
    private String city = "NA";
    private String state = "NA";
    
    Student(String name, String ssn)
    {   
        this.name = name;
        this.email = name + "@example.com";
        this.ssn = ssn;
        Random randomGenerator = new Random();
        this.userId = ID + ""  + randomGenerator.nextInt(1000,9000) + ssn.substring(5,9);
        ID++;
        
    }

    public void enroll(int amnt, String course)
    {
        System.out.println("Enrolling");
        balance += amnt;
        courses[numCourses] = course;
        numCourses++;
    }

    public void pay(int amnt){
        balance -= amnt;

    }

    public void checkBalance()
    {
        System.out.println("Your balance is: " + this.balance);
    }


    public void showCourses()
    {
        for(String course : courses)
        {
            if(course != null)
                System.out.println(course);
        }
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", email=" + email + ", SSN=" + ssn + ", userId=" + userId + ", phone=" + phone
                + ", City=" + city + ", state=" + state + "]";
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

 


    
   
}
