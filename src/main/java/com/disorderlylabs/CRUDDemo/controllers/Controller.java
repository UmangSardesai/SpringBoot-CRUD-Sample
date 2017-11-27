package com.disorderlylabs.CRUDDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.jdbc.core.JdbcTemplate;
import com.disorderlylabs.CRUDDemo.mappers.UserMapper;
import com.disorderlylabs.CRUDDemo.repositories.User;
import java.util.ArrayList;

@RestController
public class Controller {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @RequestMapping("/")
  public String index() {
      return "Greetings from Spring Boot!";
  }

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public String getUser() 
  {
    try
    {
      String sql = "select * from user";
      ArrayList<User> users = new ArrayList<User>(jdbcTemplate.query(sql, new UserMapper()));
      String ans = "";
      for (User user: users)
        ans = ans + user.toString();
      return ans;
    }
    catch(Exception e)
    {
      return e.getMessage();
    }
  }

  @RequestMapping(value = "/user", method = RequestMethod.PUT)
  public String updateUser(@RequestParam(value="firstname", required=true) String firstname, @RequestParam(value="paymentinfo", required=true) String paymentinfo)
  {
    String sql = "UPDATE user SET paymentinfo = '"+ paymentinfo + "' WHERE firstname = '"+ firstname + "'";
    jdbcTemplate.execute(sql);
    return "Payment info for user "+ firstname + " changed to "+ paymentinfo;
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public String createUser(@RequestParam(value="firstname", required=true) String firstname, @RequestParam(value="lastname", required=true) String lastname,
                           @RequestParam(value="address", required=true) String address, @RequestParam(value="paymentinfo", required=true) String paymentinfo)
  {
    String sql = "insert into user values ('"+ firstname +"', '"+ lastname +"', '"+ address +"', '"+ paymentinfo +"')";
    jdbcTemplate.execute(sql);
    return "User named "+ firstname + " "+ lastname + " created";
  }    

  @RequestMapping(value = "/user", method = RequestMethod.DELETE)
  public String deleteUser(@RequestParam(value="firstname", required=true) String firstname) 
  {
    String sql = "delete from user where firstname like '%" + firstname + "%'";
    jdbcTemplate.execute(sql);
    return "Deleted user with firstname "+ firstname;
  }  
}