/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

/**
 *
 * @author stark001
 */
public class SalariedEmployee extends Employee{
  
  public SalariedEmployee(int id,String name,int mob,String category,String modeofPayment,String address,int salary){
      super(id, name,mob, category, modeofPayment, address);
    this.salary = salary;
  }
}