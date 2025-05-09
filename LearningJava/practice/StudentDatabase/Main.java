public class Main {
    public static void main(String[] args) {
        Student obj = new Student("max","123456789");

        System.out.println(obj);

        obj.enroll(1000, "Science");
        obj.enroll(2000, "Math");
        obj.checkBalance();
        obj.pay(1000);
        obj.checkBalance();
        obj.showCourses();

        obj.setCity("tampa");
        obj.setState("FL");
        obj.setPhone("1234567777");
        System.out.println(obj);
    }
}
