/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;
import java.util.Date;
import java.time.LocalDate;
/**
 *
 * @author stark001
 */
public class Employee {
    protected String name,category,modeOfPayment,address,bankDetails;
    protected LocalDate lastPaymentDate; 
    protected int commissionRate,id,charges=0,totalRecievedAmount=0;
    protected int hourlyRate=0,salary=0;

    public Employee(int id,String name,String category,String modeofPayment,String address){
    this.id=id;
    this.name=name;
    this.category=category;
    this.modeOfPayment=modeOfPayment;
    this.address = address;
    this.lastPaymentDate = java.time.LocalDate.now();
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

//     protected void AddEmployee(){
//         setConn();
//         String query = "INSERT INTO Employee " +"VALUES (100, 'Zara', 'Ali', 18)";
//         Resultset result = executQuery();
//         PreparedStatement stmt = con.prepareStatement("SELECT * FROM `prices` WHERE `poster` = ?");
// stmt.setString(1, poster);
// ResultSet rs = stmt.executeQuery();
//     }
    
}



