
class A
{
    public void show()
    {
        System.out.println("in A show");
    }

    public void config()
    {
        System.out.println("in A config");
    }
}

class B extends A{

    @Override
    public void show()
    {
        System.out.println("in B show");
    }
}


public class Demo {

    public static void main(String[] args) {
        B obj = new B();
        obj.show();
        obj.config();
    }
    
}
