/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

import java.time.LocalDate;
import java.util.Scanner;
/**
 *
 * @author stark001
 */
public class FKPayrollDesign {
    
    
    public static void main(String []args){
    System.out.println("Select the option");
    System.out.println("1.Add New Employee");
    System.out.println("2.Delete an Employee");
    System.out.println("3.Post a Time Card");
    System.out.println("4.Post a Sales Receipt");
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
  }
}
