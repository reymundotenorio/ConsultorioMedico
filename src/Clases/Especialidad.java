/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author UNI
 */
public class Especialidad {

    public static ResultSet resultado;

    public static void Agregar_Especialidad(String Nombre, String Descripcion) {

        try {

            CallableStatement consulta = Conexion.con.prepareCall("{call AgregarEspecialidad (?,?)}");

            consulta.setString(1, Nombre);
            consulta.setString(2, Descripcion);

            consulta.execute();

            JOptionPane.showMessageDialog(null, "Datos de la Especialidad guardado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Actualizar_Especialidad(int ID, String Nombre, String Descripcion) {

        try {

            CallableStatement consulta = Conexion.con.prepareCall("{call ModificarEspecialidad (?,?,?) }");

            consulta.setInt(1, ID);
            consulta.setString(2, Nombre);
            consulta.setString(3, Descripcion);

            consulta.execute();

            JOptionPane.showMessageDialog(null, "Datos de La Especialidad Actualizados Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

 
    public static void Activar_Especialidad(int ID) {

        try {

            CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Especialidad (?)}");

            consulta.setInt(1, ID);
            consulta.execute();
      JOptionPane.showMessageDialog(null,"Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Desactivar_Especialidad(int ID) {

        try {

            CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Especialidad (?)}");

            consulta.setInt(1, ID);
            consulta.execute();
      JOptionPane.showMessageDialog(null,"Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

}
