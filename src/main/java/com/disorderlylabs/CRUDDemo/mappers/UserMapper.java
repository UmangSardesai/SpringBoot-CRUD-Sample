package com.disorderlylabs.CRUDDemo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.disorderlylabs.CRUDDemo.repositories.*;

public class UserMapper implements RowMapper {

public User mapRow(ResultSet rs, int rowNum) throws SQLException {  
  User u = new User();  
  u.setFirstname(rs.getString("firstname"));
  u.setLastname(rs.getString("lastname"));
  u.setAddress(rs.getString("address"));
  u.setPaymentinfo(rs.getString("paymentinfo")); 
  return u;  
 }  
}