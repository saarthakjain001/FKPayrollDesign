/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author stark001
 */
public class Employee {
    protected String name,category,modeOfPayment,address,bankDetails;
    protected Date lastPaymentDate; 
    protected int commissionRate=0,id,charges=0,totalRecievedAmount=0;
    protected int hourlyRate=0,salary=0;
    protected int mob;
    final static String pswdString = "xxx";
    
    public Employee(int id,String name,int mob,String category,String modeOfPayment,String address){
    this.id=id;
    this.name=name;
    this.mob=mob;
    this.category=category;
    this.modeOfPayment=modeOfPayment;
    this.address = address;
    long d = System.currentTimeMillis();
    this.lastPaymentDate = new Date(d);
    }
      
    protected void setBankDetails(String bankDetails){
        this.bankDetails = bankDetails;
    }
    protected void setCommissionRate(int commissionRate){
        this.commissionRate=commissionRate;
    }
    protected void updateUnionCharges(int charges,boolean incrementCharges){
        if(incrementCharges==true){
            this.charges +=charges;
        }
        else
        {
            int subtract = (this.charges) - charges;
            if(subtract > 0)
            {
                this.charges -= charges;
            } 
            else
            {
                this.charges=0;
            }
        }
    }

     protected void AddEmployee(){
         Conn.setConn();
         try{
         String query = "Insert into Employee values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
         PreparedStatement ps =null;
         ps=Conn.con.prepareStatement(query);
         ps.setInt(1,id);
         ps.setString(2,name);
         ps.setInt(3,mob);
         ps.setString(4,category);
         ps.setString(5,address);
         ps.setString(6,bankDetails);
         ps.setInt(7,commissionRate);
         ps.setString(8,modeOfPayment);
         ps.setDate(9, lastPaymentDate);
         ps.setInt(10,charges);
         ps.setInt(11,salary);
         ps.setInt(12,hourlyRate);
         ps.setInt(13,totalRecievedAmount);
         ps.execute();
         System.out.println("Employee Registered");
         Conn.closeConn();
         }
         catch(java.sql.SQLException e){
             System.out.println(e);
         }
         catch(Exception e){
             System.out.println(e);
         }
     }
    protected static void DeleteEmployee(){
        String name;int mob;
        System.out.println("Enter Employee name");
        Scanner sc = new Scanner(System.in);
        System.out.println("Name");
        name = sc.nextLine();
        System.out.println("Mobile number");
        mob = sc.nextInt();
        Conn.setConn();
        try{
            String query ="select * from Employee where name = ? and mobileNumber = ?";
            PreparedStatement ps = null;
            ps=Conn.con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2,mob);
            ResultSet rs = ps.executeQuery();
            if(rs.next()==false)
            {
                System.out.println("No record found");
            }
            else
            {
                System.out.println("The name is "+ rs.getString("name") + " and mob number is " + rs.getInt("mobileNumber"));
                ps = null;
                query = "Delete from Employee where name = ? and mobileNumber = ?";
                ps=Conn.con.prepareStatement(query);
                ps.setString(1, name);
                ps.setInt(2,mob);
                try{
                    ps.execute();
                    System.err.println("Record Deleted");
                }
                catch(java.sql.SQLException e)
                {
                    //System.err.println(e);
                    System.err.println("Could not delete record");
                }
            }
            
            
        }
        catch(java.sql.SQLException e){
            System.out.println(e);
        }
    }
}



