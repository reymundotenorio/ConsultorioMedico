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
public class PacienteDao {
    
    
public static ResultSet resultado;

public static void Agregar_Paciente(String Nombre, String Apellido, float Peso, float Altura,
        int Edad, String Alergias, String Enfermedades, String TipoSangre, String Telefono){

    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call AgregarPaciente (?,?,?,?,?,?,?,?,?)}");

           
                        consulta.setString(1, Nombre);
                        consulta.setString(2, Apellido);
                        consulta.setFloat(3, Peso);
                        consulta.setFloat(4, Altura);
                        consulta.setInt(5, Edad);
                        consulta.setString(6, Alergias);
                        consulta.setString(7, Enfermedades);
                        consulta.setString(8, TipoSangre);
                        consulta.setString(9, Telefono);
                        
  
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Paciente guardado correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }


public static void Actualizar_Paciente(int ID, String Nombre, String Apellido, float Peso, float Altura,
        int Edad, String Alergias, String Enfermedades, String TipoSangre, String Telefono){
   
    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call ModificarPaciente (?,?,?,?,?,?,?,?,?,?) }");

                        consulta.setInt(1,ID);
                        consulta.setString(2, Nombre);
                        consulta.setString(3, Apellido);
                        consulta.setFloat(4, Peso);
                        consulta.setFloat(5, Altura);
                        consulta.setInt(6,Edad);
                        consulta.setString(7, Alergias);
                        consulta.setString(8, Enfermedades);
                        consulta.setString(9, TipoSangre);
                        consulta.setString(10, Telefono);
                        
                       

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Paciente Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}

public static void Activar_Paciente(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Paciente (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Desactivar_Paciente(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Paciente (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
     JOptionPane.showMessageDialog(null,"Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
         
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

}
