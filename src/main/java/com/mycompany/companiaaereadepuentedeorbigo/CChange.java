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
public class CChange extends CPilotos{
    
    public void ChangePilot(JTextField paramId,JTextField paramName, JTextField paramSurname, JTextField paramGrade, JTextField paramAge, JTextField paramGender) {
        
        setId(Integer.valueOf(paramId.getText()));
        setNombre(paramName.getText());
        setApellidos(paramSurname.getText());
        setRango(paramGrade.getText());
        setEdad(Integer.valueOf(paramAge.getText()));
        setGenero(paramGender.getText());

       connect();

        String consultation = "UPDATE pilotos SET pilotos.Nombre = ?, pilotos.Apellidos = ?, pilotos.Rango = ?, pilotos.Edad = ?, pilotos.Genero = ? WHERE pilotos.idpilotos= ? ";

        try {

            CallableStatement cs = con.establishedConnection().prepareCall(consultation);
            
            
            cs.setString(1, getNombre());
            cs.setString(2, getApellidos());
            cs.setString(3, getRango());
            cs.setInt(4,getEdad());
            cs.setString(5, getGenero());
            cs.setInt (6,getId());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Modificación exitosa");

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "no se pudo modificar: " + e.toString());
        }

    }
    
}
