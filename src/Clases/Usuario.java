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
public class Usuario {
    
    
public static ResultSet resultado;

public static void Agregar_Usuario(String Nombre, String Contrasena, String Rol){

    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call AgregarUsuario (?,?,?)}");

                        consulta.setString(1, Nombre);
                        consulta.setString(2, Contrasena);
                        consulta.setString(3, Rol);    
  
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Usuario guardado correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }

     

    }


public static void Actualizar_Usuario(int ID, String Nombre, String Contrasena, String Rol){
   
    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call ModificarUsuario (?,?,?,?) }");

                        consulta.setInt(1,ID);
                        consulta.setString(2, Nombre);
                        consulta.setString(3, Contrasena);
                        consulta.setString(4, Rol);  
       
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Usuario Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}
 
public static void Activar_Usuario(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Usuario (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Desactivar_Usuario(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Usuario (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
         
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

}
