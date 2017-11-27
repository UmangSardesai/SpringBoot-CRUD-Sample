package com.disorderlylabs.CRUDDemo.repositories;

public class User
{

  private String firstname;
  private String lastname;
  private String address;
  private String paymentinfo;

  public User()
  {

  }
  
  public User(String firstname, String lastname, String address, String paymentinfo)
  {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.paymentinfo = paymentinfo;
  }

  public void setFirstname(String name)
  {
    this.firstname = name;
  }

  public void setLastname(String name)
  {
    this.lastname = name;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public void setPaymentinfo(String paymentinfo)
  {
    this.paymentinfo = paymentinfo;
  }

  public String getFirstname()
  {
     return this.firstname;
  }

  public String getLastname()
  {
    return this.lastname;
  }

  public String getAddress()
  {
    return this.address;
  }

  public String getPaymentinfo()
  {
    return this.paymentinfo;
  }

  public String toString()
  {
    return "Firstname: "+ firstname + "\nLastname: " + lastname + "\nAddress: " + address + "\nPaymentInfo: " + paymentinfo + "\n"; 
  }         
}