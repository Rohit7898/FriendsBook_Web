/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gowla
 */
public class authentication {
     String id="";
     String pass="";
    public void set(String id, String pass){
        this.id=id;
        this.pass=pass;
    } 
    public void reset(){
        this.id=null;
        this.pass=null;
    }
}
