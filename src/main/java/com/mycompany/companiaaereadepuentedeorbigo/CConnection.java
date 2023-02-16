/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.companiaaereadepuentedeorbigo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;




/**
 *
 * @author chris
 */
public class CConnection {
     
    Connection con =null;
    
      String driver="com.mysql.jdbc.Driver";
      String user="root";
      String pass="";
      String url="jdbc:mysql://localhost:3306/ChristianAirways";

   public Connection estableceConexion(){
   try{
       
       Class.forName("com.mysql.cj.jdbc.Driver");
       con = DriverManager.getConnection(url,user,pass);
       JOptionPane.showMessageDialog(null, "Conexión establecida");
   
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, "Error al conectarse" + e.toString());
   }
           return con;
           
           }
}

    
    

