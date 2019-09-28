/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author UNI
 */
public class MedicoDao {
    
    
public static ResultSet resultado;

public static void Agregar_Medico(String Nombre, String Apellido, int ID_Especialidad){

    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call AgregarMedico (?,?,?)}");

           
                        consulta.setString(1, Nombre);
                        consulta.setString(2, Apellido);
                        consulta.setInt(3, ID_Especialidad);
                       
                        
  
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Medico guardado correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }


public static void Actualizar_Medico(int ID, String Nombre, String Apellido, int ID_Especialidad){
   
    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call ModificarMedico (?,?,?,?) }");

                        consulta.setInt(1,ID);
                        consulta.setString(2, Nombre);
                        consulta.setString(3, Apellido);
                        consulta.setInt(4, ID_Especialidad);
                        
                       

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Medico Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}
 
public static void Usuario_Medico(int ID_M, int ID_U, String Usuario){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call UsuarioMedico (?,?)}");

               consulta.setInt(1, ID_M);
               consulta.setInt(2, ID_U);
               consulta.execute();
     JOptionPane.showMessageDialog(null,"Medico agregado con Nombre Usuario: "+Usuario,
             "Información",JOptionPane.INFORMATION_MESSAGE); 
            
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Desactivar_Medico(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Medico (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
         
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Activar_Medico(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Medico (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
        
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

}
