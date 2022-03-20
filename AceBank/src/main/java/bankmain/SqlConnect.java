/* 220311 1440
 * mySQL connection default
 * 
 * Dependencies added: mysql-connector-java > version 8.0.22
 * Right click at Dependencies, Add Dependency, Query: mysql
 */
package bankmain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author antw
 */
public class SqlConnect {
    
    public static Statement init() throws Exception {
        Connection conn = initConn();
        return conn.createStatement();
    }
    
    public static Connection initConn() throws Exception {
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/aceBank?"
                    + "useTimezone=true&serverTimezone=UTC&"
                    + "user=root&password=mysql_80");
        return conn;
    }
    
    public static void preTest() {
        try {
            SqlConnect.init();
            System.out.println("mySql connected!");
        } catch (Exception e) {
            System.out.println(" Exception here ....  " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        preTest();
    }
}

/*
mySQL pre-installed and up.

sql query:
CREATE DATABASE  IF NOT EXISTS `aceBank`;

do a refresh by click home and back. aceBank database will be shown.
*/