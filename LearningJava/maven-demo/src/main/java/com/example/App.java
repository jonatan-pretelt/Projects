package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        /**
         * Import package
         * create connection
         * create statement
         * execute statement
         * process the results
         * close
         */

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres",
                "Sampues53!!@@");
        System.out.println("connection established");

        String sql = "SELECT name FROM Employee where id = 1";
        Statement st = con.createStatement();

        ResultSet results = st.executeQuery(sql);

        System.out.println(results.next()); // returns true if results have a next row so data was returned.

        String name = results.getString("name");

        System.out.println("name is " + name);

        con.close();
        System.out.println("Connection closed");
    }
}
