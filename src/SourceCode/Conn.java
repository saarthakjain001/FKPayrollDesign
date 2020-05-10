package SourceCode;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stark001
 */


public class Conn {
    protected static Connection con;
    

    static Conn instance = null;



    public static Conn getInstance(){
        if(instance==null){
            instance=new Conn();
        }
        return instance;
    }

    public static void setConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver registered");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
            System.out.println("connection made");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void closeConn(){
        try{
            con.close();
            System.out.println("Conn Closed");
        }
        catch(Exception e)
        {
            System.out.println("Could not close connection");
        }
    }
    
//    public static ResultSet executeQuery(String query){
//         
//        ResultSet rs = null;
//        Statement statement;
//         try
//         {
//             statement= con.createStatement();
//             rs = statement.executeQuery(query); 
//         } 
//         catch(SQLException e)
//         {
//             System.out.println("Statement cannot be created");
//         }
//         finally{
//             return rs;
//         }
    
//}
    
   
}