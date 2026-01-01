package com.jon.learning;
import com.jon.learning.controller.UserController;
import com.jon.learning.service.UserService;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        UserService service = new UserService();
        UserController controller = new UserController(service);
        controller.start();
    }
}
