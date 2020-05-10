/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

import static SourceCode.SalariedEmployee.CalculateBonusPay;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Date;
/**
 *
 * @author stark001
 */
public class FKPayrollDesign {
    private static void handleSalariedEmployees(){
        Date d=new Date();  
        int dayValue = d.getDay();        
        Conn.setConn();
        try{
            String query;
            if (dayValue!=5){
            query = "update Employee set CardFlag =? where Category=?";
            PreparedStatement ps = null;
            ps=Conn.con.prepareStatement(query);
            ps.setInt(1, 0);
            ps.setString(2,"Salaried");
            ps.executeUpdate();
            }
            else{
            query ="update Employee set AmountReceived=AmountReceived+PendingPayment,CardFlag =?,PendingPayment=? where Category=?";
            PreparedStatement ps = null;
            ps=Conn.con.prepareStatement(query);
            ps.setInt(1, 0);
            ps.setInt(2,0);
            ps.setString(3,"Salaried");
            ps.executeUpdate();  
            }
        }
        catch(java.sql.SQLException e){
            System.out.println(e);
        }
   }
    
    
    public static void main(String []args){
    System.out.println("Select the option");
    System.out.println("1.Add New Employee");
    System.out.println("2.Delete an Employee");
    System.out.println("3.Post a Time Card");
    System.out.println("4.Post a Sales Receipt");
    System.out.println("5.Change Hourly Rate");
    Scanner scan = new Scanner(System.in);
    int value = scan.nextInt();  // Read user input

    if(value==1){
        String name,category,modeOfPayment,address,bankDetails ;
        LocalDate lastPaymentDate; 
        int mobNumber,commissionRate,id,charges,totalRecievedAmount;
        int hourlyRate,salary; 
        System.out.println("ID");
        id = scan.nextInt();
        System.out.println("Name");
        scan.nextLine();
        name=scan.nextLine();
        System.out.println("Mobile Number");
        mobNumber=scan.nextInt();
        System.out.println("Address");
        scan.nextLine();
        address=scan.nextLine();
        System.out.println("Bank Account");
        //scan.nextLine();
        bankDetails=scan.nextLine();
        System.out.println("Enter Commission Rate");
        commissionRate=scan.nextInt();
        System.out.println("ModeOfPayment:Address or Paymaster or Bank");
        scan.nextLine();
        modeOfPayment = scan.nextLine();
        System.out.println("Category: Salaried or Hourly");
        //scan.nextLine();
        category=scan.nextLine();
        Employee emp;
        if(category.equals("Salaried")){
            System.out.println("Enter Salary");
            salary = scan.nextInt();
            emp = new SalariedEmployee(id,name,mobNumber,category,modeOfPayment,address,salary);

         }
        else
        {
            System.out.println("Enter Hourly Rate");
            hourlyRate = scan.nextInt();
            emp = new HourlyEmployee(id,name,mobNumber,category,modeOfPayment,address,hourlyRate);
        }
        emp.setBankDetails(bankDetails);
//        System.out.println("Commission Rate");
//        commissionRate = scan.nextInt();
        emp.setCommissionRate(commissionRate);
        emp.AddEmployee();
        }
    else if(value==2){
        Employee.DeleteEmployee();
    }
    else if (value==3)
    {
        HourlyEmployee.PostTimeCard();
    }
    else if(value==4)
    {
        SalariedEmployee.PostSalesReceipt();
    }
    else if(value==5)
    {
        HourlyEmployee.ChangeHourlyRate();
    }
    else if(value==6)
    {
        handleSalariedEmployees();
    }
  }
}
