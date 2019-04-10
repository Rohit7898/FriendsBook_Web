/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author gowla
 */
@ManagedBean
@RequestScoped
public class FriendReq {

    /**
     * Creates a new instance of FriendReq
     */
   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    //this takes the user id whom you want to send requrst from form
private String f_Id="";
FriendsBook user;
Login l;
    public String getF_Id() {
        return f_Id;
    }

    public void setF_Id(String f_Id) {
        this.f_Id = f_Id;
    }


    public void SendFriendReq()
    {
        
        int nextNum=0;
        String n_Id="";
        //check if sending request to same id
        while(f_Id==user.getUser_id())
        {
           // return statement;
        }
        final String DB_URL="jdbc:mysql://mis-sql.uhcl.edu/prajapatir1738";
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try
        {
            conn = DriverManager.getConnection(DB_URL,"prajapatir1738","1629042");
            statement = conn.createStatement();
            resultSet=statement.executeQuery("select * from nextnum");
            if(user.users.contains(f_Id))
            {
                if(user.friends.contains(f_Id)){
                   //return already friend
                }
                else{
                    
                 //return send request;
                    if(resultSet.next())
                    {
                        n_Id= "" + resultSet.getInt(1);
                        nextNum = resultSet.getInt(1) + 1;
                    }
                    int t = statement.executeUpdate("Update nextnum set n_num = '" + nextNum + "'");
                    int r = statement.executeUpdate("insert into notification values ('"+n_Id+"','" +user.getUser_id()+ "', '"+f_Id+ "','R', 'Add Me','"+0+"')");
                    
                    
                }
                
            }
            else
            {
              //  retrun not found;
            }
            
                
                
        }
        catch(SQLException e)
        {
            System.out.println("Friend's Id NOT FOUND!!Try Again!!");
            e.printStackTrace();
        }
        finally
        {
            try
            {
                
                resultSet.close();
                statement.close();
                conn.close();
                ;
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }     
    }
}

    
