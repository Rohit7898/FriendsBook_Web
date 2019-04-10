/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author AgrawalG1680
 */
@Named(value = "friendsbook")
@ManagedBean(name ="userbean", eager = true)
@RequestScoped
public class FriendsBook {

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    private String user_id;
    private String password;
    private ArrayList<Updates> updates;
    private ArrayList<Updates> update;
    public ArrayList<String> friends;
    public ArrayList<String> users;

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }
    private ArrayList<Updateprofile> profiles;
   // private ArrayList<Post> posts;
   // private List<String> postList;
    private ArrayList<Notification> notifications;
    private ArrayList<Notification> messages;
   
    private String post;
    private String profile;
    private String name;
    private String gender;
    private String school;
    private String birthday;  
    
    private boolean isThere;
    
    public ArrayList<Updates> getUpdate() {
        return update;
    }

    public void setUpdate(ArrayList<Updates> update) {
        this.update = update;
    }

    public boolean isIsThere() {
        return isThere;
    }

    public void setIsThere(boolean isThere) {
        this.isThere = isThere;
    }

     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

   

    
    public ArrayList<Updates> getUpdates() {
        return updates;
    }

    public void setUpdates(ArrayList<Updates> updates) {
        this.updates = updates;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }

     
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public FriendsBook(){
        
    }
     public FriendsBook(String u, String p)
    {
        user_id = u;
        password = p;
        updates = new ArrayList<Updates>();
        update = new ArrayList<Updates>();
        friends = new ArrayList<String>();
        users = new ArrayList<String>();
        profiles = new ArrayList<Updateprofile>();
        //posts = new ArrayList<Post>();
        notifications = new ArrayList<Notification>();
        messages = new ArrayList<Notification>();  //ArrayList w/ read and unread messages from or to user's friends   
         
        
        post="";
        profile ="";
        name="";
        gender="";
        school="";
        birthday="";
        
        isThere = false;
        
        
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/prajapatir1738";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        
        try
        {
            conn = DriverManager.getConnection(DB_URL,"prajapatir1738","1629042");
            st = conn.createStatement();
            rs = st.executeQuery("Select * from friends where Id1='"+user_id+"' or Id2='"+ user_id+"'");
            while(rs.next())
            {
                if(user_id.equals(rs.getString(1)))
                {
                    friends.add(rs.getString(2));
                }
                else
                {
                    friends.add(rs.getString(1));
                }
            } 
            rs = st.executeQuery("Select * from user");
            while(rs.next())
            {
                
                    users.add(rs.getString(1));
                
            }  
            
            rs= st.executeQuery("Select * from post order by Pid desc");
            while(rs.next())
            {
                for(String f: friends)
                {
                    if(rs.getString(2).equals(f))
                    {
                        //update.add(new Updates(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));                     
                    }
                }
            }
        /*    for(Updates up: update)
            {              
                    for(Updates ups: updates)
                    {
                        if(ups.getPost_id()== up.getPost_id())
                        {
                            if(up.getUser_id().equals(ups.getUser_id()))
                            {
                                isThere = true;
                            }
                        }                       
                    }                            
                if(isThere == false)
                {
                    updates.add(new Update(up.getSeq_num(), up.getUser_id(), up.getPost_id(), up.getDatetime()));
                }             
            }
            
            )
          */  
            
            rs = st.executeQuery("Select * from user where Id='"+user_id+ "'");
            while(rs.next())
            {
                 this.name=rs.getString(2);
                 

// profiles.add(new Updateprofile(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), rs.getDate(6)));
            }
            
         /*   
            rs = st.executeQuery("Select * from post");
            while(rs.next())
            {
                posts.add(new Post(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4)));
            }
           
            
            */
            rs = st.executeQuery("Select * from notification where receiver = '"+ user_id+"' and (status ='unread' or status ='request')"); 
            while(rs.next())
            {
                notifications.add(new Notification(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
            
            rs = st.executeQuery("Select * from notification where (sender = '"+ user_id+"' or receiver = '"
                                     + user_id +"')and (status ='read' or status ='unread') order by noti_num"); 
            while(rs.next())
            {
                messages.add(new Notification(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
       
        }
        
        
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                conn.close();
                st.close();
                rs.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
                    
        }
                
        
    }

   
     
      

    

    

   
    
}
