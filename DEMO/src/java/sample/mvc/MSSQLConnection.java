/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.mvc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ThangVo
 */
public class MSSQLConnection {

     private static Connection conn = null;
    public static Connection getConnection() {
       
        try {
//Establish the connection
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=test;user=sa;password=11199303");
          Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdata", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
