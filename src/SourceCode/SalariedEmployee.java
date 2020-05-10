/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

import static SourceCode.HourlyEmployee.CalculateBonusPay;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author stark001
 */
public class SalariedEmployee extends Employee {
  
  public SalariedEmployee(int id,String name,int mob,String category,String modeofPayment,String address,int salary){
      super(id, name,mob, category, modeofPayment, address);
    this.salary = salary;
  }
  public static double CalculateBonusPay(int commission,int sales){
       double value = (double)((commission*sales)/100);
       return value;
   }
  
  public static void PostSalesReceipt(){
       String name;int mob;
       int sales,flag;
        //System.out.println("Enter Employee name");
        Scanner sc = new Scanner(System.in);
        System.out.println("Name");
        name = sc.nextLine();
        System.out.println("Mobile number");
        mob = sc.nextInt();
        System.out.println("Sales");
        sales = sc.nextInt();
        Conn.setConn();
        try{
            String query ="select * from Employee where name = ? and mobileNumber = ? and CardFlag=? and Category = ?";
            PreparedStatement ps = null;
            ps=Conn.con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2,mob);
            ps.setInt(3,0);
            ps.setString(4,"Salaried");
            ResultSet rs = ps.executeQuery();
            //String category = rs.getString("Category");
            if(rs.next()==false)
            {
                //if(category.equals("Salaried"))
                    System.out.println("You are an Hourly Employee  OR Already submitted Sales Receipt for today");
               
            }
            else
            {
                //System.out.println("The name is "+ rs.getString("name") + " and mob number is " + rs.getInt("mobileNumber"));
                ps = null;
                int commission=rs.getInt("Commission");
                int pendingPayment=rs.getInt("PendingPayment");
                int increment =(int)(CalculateBonusPay(commission,sales));
                int updatedPayment = pendingPayment+increment;
                query = "update Employee set PendingPayment=?,CardFlag =? where name=? and mobileNumber=?";
                ps=Conn.con.prepareStatement(query);
                ps.setInt(1, updatedPayment);
                ps.setInt(2,1);
                ps.setString(3,name);
                ps.setInt(4,mob);
                try{
                    ps.execute();
                    System.err.println("Sales Receipt Stored");
                }
                catch(java.sql.SQLException e)
                {
                    //System.err.println(e);
                    System.err.println("Sales Receipt could not be stored,try again");
                }
            }
            
            
        }
        catch(java.sql.SQLException e){
            System.out.println(e);
        }
   }
}