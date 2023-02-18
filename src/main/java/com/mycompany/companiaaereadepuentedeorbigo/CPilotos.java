/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.companiaaereadepuentedeorbigo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author chris
 */
public class CPilotos {
    Integer Id;
    String nombre;
    String apellidos;
    String rango;
    Integer edad;
    String genero;

     public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }
    
    
    
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

    public void InsertPilot(JTextField paramNombres, JTextField paramApellidos, JTextField paramRangos, JTextField paramEdades, JTextField paramGeneros) {
        
        setNombre(paramNombres.getText());
        setApellidos(paramApellidos.getText());
        setRango(paramRangos.getText());
        setEdad(Integer.valueOf(paramEdades.getText()));
        setGenero(paramGeneros.getText());

        CConnection objetoConnection = new CConnection();

        String consulta = "insert into Pilotos (Nombre,Apellidos,Rango,Edad,Genero) values (?,?,?,?,?);";

        try {

            CallableStatement cs = objetoConnection.establishedConnection().prepareCall(consulta);

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

    public void ShowPilots(JTable paramTablaTotalPilotos) {

        CConnection objetoConnection = new CConnection();

        DefaultTableModel modelo = new DefaultTableModel();

        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        paramTablaTotalPilotos.setRowSorter(OrdenarTabla);

        String sql = "";

        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Rango");
        modelo.addColumn("Edad");
        modelo.addColumn("Genero");

        paramTablaTotalPilotos.setModel(modelo);

        sql = "select * from Pilotos";

        String[] datos = new String[6];
        Statement st;

        try {
            st = objetoConnection.establishedConnection().createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);

                modelo.addRow(datos);

            }
            paramTablaTotalPilotos.setModel(modelo);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros:" + e.toString());

        }

    }

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

    public void ChangePilot(JTextField paramId,JTextField paramName, JTextField paramSurname, JTextField paramGrade, JTextField paramAge, JTextField paramGender) {
        
        setId(Integer.valueOf(paramId.getText()));
        setNombre(paramName.getText());
        setApellidos(paramSurname.getText());
        setRango(paramGrade.getText());
        setEdad(Integer.valueOf(paramAge.getText()));
        setGenero(paramGender.getText());

        CConnection objetoConnection = new CConnection();

        String consultation = "UPDATE pilotos SET pilotos.Nombre = ?, pilotos.Apellidos = ?, pilotos.Rango = ?, pilotos.Edad = ?, pilotos.Genero = ? WHERE pilotos.idpilotos= ? ";

        try {

            CallableStatement cs = objetoConnection.establishedConnection().prepareCall(consultation);
            
            
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

    
    
    
    public void DeletePilot (JTextField paramId){
    
        setId(Integer.parseInt(paramId.getText()));
        
        CConnection objetoConnection = new CConnection();
        
        String consultation = "DELETE FROM pilotos WHERE pilotos.idpilotos = ?;";
        
        try {
            
            CallableStatement cs = objetoConnection.establishedConnection().prepareCall(consultation);
            
            cs.setInt(1,getId());
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se ha borrado correctamente");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "No se pudo eliminar:" + e.toString());
            
        }
        
    }
}
