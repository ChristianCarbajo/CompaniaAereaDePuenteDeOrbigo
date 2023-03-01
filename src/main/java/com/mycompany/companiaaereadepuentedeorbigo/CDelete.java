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
public class CDelete extends CPilotos{
    
     public void DeletePilot (JTextField paramId){
    
        setId(Integer.parseInt(paramId.getText()));
        
        connect();
        
        String consultation = "DELETE FROM pilotos WHERE pilotos.idpilotos = ?;";
        
        try {
            
            CallableStatement cs = con.establishedConnection().prepareCall(consultation);
            
            cs.setInt(1,getId());
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se ha borrado correctamente");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "No se pudo eliminar:" + e.toString());
            
        }
        
    }
    
}
