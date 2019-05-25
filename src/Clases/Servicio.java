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
public class Servicio {
    
    
public static ResultSet resultado;

public static void Agregar_Servicio(String Nombre,String Descripcion, double Precio){

    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call AgregarServicio (?,?,?)}");

                        consulta.setString(1, Nombre);
                        consulta.setString(2, Descripcion);
                        consulta.setDouble(3, Precio);
                       
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Servicio guardado correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }


public static void Actualizar_Servicio(int ID, String Nombre,String Descripcion, double Precio ){
    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call ModificarServicio (?,?,?,?) }");

                        consulta.setInt(1,ID);
                        consulta.setString(2, Nombre);
                        consulta.setString(3, Descripcion);
                        consulta.setDouble(4, Precio);                   

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Servicio Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}
 
public static void Activar_Servicio(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Servicio (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Desactivar_Servicio(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Servicio (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
         
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

}
