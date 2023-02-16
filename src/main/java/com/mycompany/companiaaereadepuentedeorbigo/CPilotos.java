/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.companiaaereadepuentedeorbigo;

import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author chris
 */
public class CPilotos {

    String nombre;
    String apellidos;
    String rango;
    Integer edad;
    String genero;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void InsertarPiloto(JTextField paramNombres, JTextField paramApellidos, JTextField paramRangos, JTextField paramEdades, JTextField paramGeneros) {

        setNombre(paramNombres.getText());
        setApellidos(paramApellidos.getText());
        setRango(paramRangos.getText());
        setEdad(Integer.valueOf(paramEdades.getText()));
        setGenero(paramGeneros.getText());
        
     CConnection objetoConnection = new CConnection();
        
     
     String consulta="insert into Pilotos (Nombre,Apellidos,Rango,Edad,Género) values (?,?,?,?,?);";
     
     try{
     
     CallableStatement cs= objetoConnection.estableceConexion().prepareCall(consulta);
     
     cs.setString(1,getNombre());
     cs.setString(2,getApellidos());
     cs.setString(3,getRango());
     cs.setInt(4,getEdad());
     cs.setString(5,getGenero());
     
     cs.execute();
     
         JOptionPane.showMessageDialog(null, "Se incorporó correctamente");
     
             
     }catch(Exception e){
         
         JOptionPane.showMessageDialog(null, "No se incorporó correctamente" + e.toString());
         
         
    }
    
    
    
    }

    
    
}
