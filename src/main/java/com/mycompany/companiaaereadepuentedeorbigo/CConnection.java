/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.companiaaereadepuentedeorbigo;

import java.sql.Connection;
import javax.swing.JOptionPane;




/**
 *
 * @author chris
 */
public class CConnection {
     
MySQL mySQLConnection = new MySQL();

Connection manolo =null;

   public Connection  establishedConnection(){
  
try{
  manolo = mySQLConnection.establishedConnectionMySQL();
  
  
}catch(Exception e){
    JOptionPane.showMessageDialog(null, "Error al conectarse" + e.toString()); 
   }
    return manolo;
   
    
   }    

};

    
    

