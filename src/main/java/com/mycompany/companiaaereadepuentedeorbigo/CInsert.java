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
public class CInsert  extends CPilotos{
    
     public void InsertPilot  (JTextField paramNombres, JTextField paramApellidos, JTextField paramRangos, JTextField paramEdades, JTextField paramGeneros) {
        
        setNombre(paramNombres.getText());
        setApellidos(paramApellidos.getText());
        setRango(paramRangos.getText());
        setEdad(Integer.valueOf(paramEdades.getText()));
        setGenero(paramGeneros.getText());
        
        connect();

        String consulta = "insert into Pilotos (Nombre,Apellidos,Rango,Edad,Genero) values (?,?,?,?,?);";

        try {

            CallableStatement cs = con.establishedConnection().prepareCall(consulta);

            cs.setString(1, getNombre());
            cs.setString(2, getApellidos());
            cs.setString(3, getRango());
            cs.setInt(4, getEdad());
            cs.setString(5, getGenero());

            cs.execute();

            JOptionPane.showMessageDialog(null, "Se incorporó correctamente");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "No se incorporó correctamente" + e.toString());

        }

    }
}
