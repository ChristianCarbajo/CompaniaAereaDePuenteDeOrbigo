/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.companiaaereadepuentedeorbigo;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author chris
 */
public class CSelection extends CPilotos {
    
     public void SelectionPilots(JTable paramTablePilots, JTextField paramId, JTextField paramName, JTextField paramSurname, JTextField paramGrade, JTextField paramAge, JTextField paramGender) {

        try {

            int row = paramTablePilots.getSelectedRow();
            if (row >= 0) {

                paramId.setText((String) paramTablePilots.getValueAt(row, 0));
                paramName.setText((String) paramTablePilots.getValueAt(row, 1));
                paramSurname.setText((String) paramTablePilots.getValueAt(row, 2));
                paramGrade.setText((String) paramTablePilots.getValueAt(row, 3));
                paramAge.setText((String) paramTablePilots.getValueAt(row, 4));
                paramGender.setText((String) paramTablePilots.getValueAt(row, 5));
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "No se ha podido seleccionar" + e.toString());
        }
    }
    
}
