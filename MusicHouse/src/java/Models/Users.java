/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.sql.*;
import com.mysql.jdbc.Driver;

/**
 *
 * @author Sangita Barala
 */
public class Users {
    
    /**
     *
     * @param user
     * @return
     */
    public boolean registerUser(String user[])
    {
  
    String name=user[0];
    String email=user[1];
    String password=user[2];
    String address=user[3];
    String postalCode=user[4];
    String phoneNumber=user[5];
    try{
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/musichouse","root","sang12529");
        
        String query="insert into user(name,email,password,address,postalCode,phoneNumber)values(?,?,?,?,?,?)";
        
        PreparedStatement ps=conn.prepareStatement(query);
        ps.setString(1,name);
        ps.setString(2,email);
        ps.setString(3,password);
        ps.setString(4,address);
        ps.setString(5,postalCode);
        ps.setString(6,phoneNumber);
        
        int result=ps.executeUpdate();
        if(result!=0)
        {
          return true;
        }
        else
        {
          return false;
        }
       
        
    }catch(Exception e)
    {
        System.out.print("something went wrong!");
       // return e.toString();
    }
        
        return false;
      //return "";
    }

    /**
     *
     * @param user
     * @return
     */
    public String[] loginUser(String user[]){
    String email=user[0];
    String password=user[1];
    String[] response=new String[3];
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/musichouse","root","sang12529");
        String query="select * from user where email='"+email+"'and password='"+password+"';";
      
        Statement sm=conn.createStatement();
        ResultSet res=sm.executeQuery(query);
        //String name="";
        while(res.next())
        {
             //name=res.getString("name");
            response[0]=res.getString("user_id");
            response[1]=res.getString("name");
            response[2]=res.getString("email");
        }
       // return name;
       return response;
        
    }catch(Exception e)
    {
        //System.out.print("LOGIN:Something went wrong!");
      
        response[0]="Error: Something went wrong!";
        response[1] = e.toString();
        return response;
    }   
      //  return null;
    }
}
