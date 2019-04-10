/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author AgrawalG1680
 */

@ManagedBean(name ="loginbean", eager = true)
@SessionScoped
public class Login implements Serializable {

    String id="";
    String password="";
    FriendsBook userAccount;

    public FriendsBook getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(FriendsBook userAccount) {
        this.userAccount = userAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Creates a new instance of Login
     */
    public String createlogin() {
        final String DB_URL="jdbc:mysql://mis-sql.uhcl.edu/prajapatir1738";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            return ("internalError");
        }
        
        try
        {
            conn = DriverManager.getConnection(DB_URL,"prajapatir1738","1629042");
            st = conn.createStatement();
            rs=st.executeQuery("Select * from user Where Id='"+id+"'and Password='"+password+"'");
            while(rs.next())
            {
                userAccount=new FriendsBook(id, password);
               // new authentication().set(id, password);
                return ("LogedinSuccess");
            }
//            else
//            {
                return ("Idexist");
//            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return ("congrats");
        }
//        finally
//        {
//            try
//            {
//                conn.close();
//                st.close();
//                rs.close();
//            }
//            catch(Exception e)
//            {
//                e.printStackTrace();
//                return ("SQLError");
//            }
//        }
    }
//    public static void Logedin()
//    {
//        final String DB_URL="jdbc:mysql://mis-sql.uhcl.edu/prajapatir1738";
//        ArrayList <String> friends =new ArrayList<String>();
//        Connection conn = null;
//        Statement st1 = null;
//        ResultSet rs1 = null;
//        Statement st2 = null;
//        ResultSet rs2 = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        Statement statement1 = null;
//        ResultSet resultSet1 = null;
//        try
//        {
//            conn = DriverManager.getConnection(DB_URL,"prajapatir1738","1629042");
//            statement = conn.createStatement();
//            statement1 = conn.createStatement();
//            st1 = conn.createStatement();
//            st2 = conn.createStatement();
//            rs1=st1.executeQuery("Select * from post order by time desc Limit 3");
//            rs2=st2.executeQuery("Select * from friends Where id1='"+uid+"' or id2='"+uid+"'");
//            String Selection="";
//            while(rs2.next()){
//                if(rs2.getString(1).equals(uid)){
//                    friends.add(rs2.getString(2));
//                }
//                else if(rs2.getString(2).equals(uid)){
//                    friends.add(rs2.getString(1));
//                }
//            }
//            while(!Selection.equals("x"))
//            {
//                while(rs1.next())
//                {
//                    if(friends.contains(rs1.getString(2)))
//                    {
//                        System.out.println(rs1.getString(2)+": "+rs1.getString(3));
//                    }
//                }
//                resultSet = statement.executeQuery("Select * from notification where receiver='"+uid+ "'and status ='"+0+"' and type='M'");
//                resultSet1 = statement1.executeQuery("Select * from notification where receiver='"+uid+ "'and status ='"+0+" 'and type ='R'");
//                int countr = 0,countm=0;
//                while (resultSet.next()) 
//                {
//                     countm++;
//                }
//                while (resultSet1.next()) 
//                {
//                     countr++;
//                }
//                System.out.println("1.Select an update and post");
//                if(countm==0&&countr==0){
//                    System.out.println("2:Check Notification");
//                }
//                else if(countm==0)
//                {
//                    System.out.println("2:Check Notification ("+countr+" Request)");
//                }
//                else if(countr==0)
//                {
//                    System.out.println("2:Check Notification ("+countm+" new msg)");
//                }
//                else
//                {
//                    System.out.println("2:Check Notification ("+countr+" Request and "+countr+" msg)");
//                }
//                System.out.println("3:Create a new post");
//                System.out.println("4:Friends");
//                System.out.println("5:Update Profile");
//                System.out.println("6:Send a message");
//                System.out.println("7:Send a friend request");
//                System.out.println("8:See Hashtag in trend");
//                System.out.println("x:Logout");
//                System.out.println();
//                Selection = input1.nextLine();
//                System.out.println();
//                if(Selection.equals("1"))
//                {
//                    PostComment.post_update();
//                }
//                if(Selection.equals("2"))
//                {
//                    new Notification().CheckNotification();
//                }
//                if(Selection.equals("3"))
//                {
//                    new Post().new_post();
//                }
//                if(Selection.equals("4"))
//                {
//                   new AllFriends().myFriends();
//                }
//                if(Selection.equals("5"))
//                {
//                     new Profile().Update();
//                }
//                if(Selection.equals("6"))
//                {
//                   new Message().send_msg();
//                }
//                if(Selection.equals("7"))
//                {
//                   Friend_Request.SendFriendReq();
//                }
//                if(Selection.equals("8"))
//                {
//                    new hashtag().show_tag();
//                }
//                if(Selection.equals("x"))
//                {
//                    ;
//                }
//            }
//
//        }
//        catch(SQLException e)
//        {
//            e.printStackTrace();
//        }
//        finally
//        {
//            try
//            {
//                conn.close();
//                st1.close();
//                rs1.close();
//                st2.close();
//                rs2.close();
//                statement.close();
//                //resultSet.close();
//            }
//            catch(Exception e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }
//    }
    
}
