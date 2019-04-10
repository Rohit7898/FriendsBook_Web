
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gowla
 */

public class Updateprofile {
    String id="";
    String name="";
    String education="";
    Date bday;
    String pass="";
    String gender="";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getBday() {
        return bday;
    }

    public void setBday(Date bday) {
        this.bday = bday;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    //
    public Updateprofile(String id, String name,String pass, String Gender, String Education, Date Bday){
        this.id=id;
        this.name=name;
        gender=Gender;
        education=Education;
        bday=Bday;
    }
    
   /* public String Fetch(){
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
        */
       /* try
        {
            conn = DriverManager.getConnection(DB_URL,"prajapatir1738","1629042");
            st = conn.createStatement();
            rs=st.executeQuery("Select * from user Where Id='"+a.id+"'");
            while(rs.next())
            {
                name=rs.getString(2);
                pass=rs.getString(3);
                gender=rs.getString(4);
                education=rs.getString(5);
                bday=rs.getString(6);
            }
            return "";
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return ("congrats");
        }
    }    */
    public String update(){
       // String id=a.id;
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
            //return ("SQLError");
            System.out.println("This has an internal error");
            return ("internalError");
        }
    try
    {
       conn = DriverManager.getConnection(DB_URL,"prajapatir1738","1629042");
            st = conn.createStatement();
            rs=st.executeQuery("Select * from user");
            while(rs.next())
            {
                //name="aashna";
                int r=st.executeUpdate("Update user set UName='"+name+"',Gender='"+gender+"'");
                return("Updateprofileconfirm");
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
    return("SQLError");
}
  
}

    
