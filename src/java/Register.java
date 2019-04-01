
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AgrawalG1680
 */
@Named(value = "register")
@ManagedBean
@RequestScoped
public class Register {
          String id="";
          String Name="";
          String password="";
          String Gender="";
          String Education="";
          String Birthday="";

    public  String getId() {
        return id;
    }

    public  void setId(String id) {
        this.id = id;
    }

    public  String getName() {
        return Name;
    }

    public  void setName(String Name) {
        this.Name = Name;
    }

    public  String getPassword() {
        return password;
    }

    public  void setPassword(String password) {
        this.password = password;
    }

    public  String getGender() {
        return Gender;
    }

    public  void setGender(String Gender) {
        this.Gender = Gender;
    }

    public  String getEducation() {
        return Education;
    }

    public  void setEducation(String Education) {
        this.Education = Education;
    }

    public  String getBirthday() {
        return Birthday;
    }

    public  void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }
    public String Regi()
    {
        ArrayList<String> names = new ArrayList<String>();
        final String DB_URL="jdbc:mysql://mis-sql.uhcl.edu/prajapatir1738";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            System.out.println("This has an internal error");
            return ("internalError");
           
        }
        try
        {
            conn = DriverManager.getConnection(DB_URL,"prajapatir1738","1629042");
            st = conn.createStatement();
            rs=st.executeQuery("Select Id from User");
            while(rs.next())
            {
                names.add(rs.getString(1));
            }
            if(names.contains(id))
            {
                System.out.print("Id already Exist");
                 return("SQLNoRecords");
            }
            else
            {
                int r = st.executeUpdate("Insert into user value('"+id+"', '"+Name+"', '"+password+"', '"+Gender+"', '"+Education+"', '"+Birthday+"')");
                return ("congrats");
                    //new User().Login();
            }
        }
            
        
        catch(SQLException e)
        {
            e.printStackTrace();
            return ("SQLError");
        }
        finally
        {
            try
            {
                conn.close();
                st.close();
                rs.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return ("SQLError");
            }
        }
    }
}


