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
public class Hora_Medico {
    
    
public static ResultSet resultado;

public static void Agregar_Hora_Medico(int ID_Dia_Medico, String HoraInicio, String HoraFinal){

    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call AgregarHora_Medico (?,?,?)}");

                        consulta.setInt(1, ID_Dia_Medico);
                        consulta.setString(2, HoraInicio);
                        consulta.setString(3, HoraFinal);
                    
                       
                        consulta.execute();

       //  JOptionPane.showMessageDialog(null,"Datos de Hora Medico guardado correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }


public static void Actualizar_Hora_Medico(int ID, String Titulo, 
       double Cuota, double Matricula, String Ruta_Imagen ){
   
    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call ModificarHora_Medico (?,?,?,?,?) }");

                        consulta.setInt(1,ID);
                        consulta.setString(2, Titulo);
                        consulta.setDouble(3, Cuota);
                        consulta.setDouble(4, Matricula);
                        consulta.setString(5, Ruta_Imagen);
                        
                       

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos de La Hora_Medico Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}
public static void Activar_Desactivar_Hora_Medico(int ID){
  
    try{
        
            String estado = null;
            resultado = Conexion.consulta("Select Estado_Hora_Medico from revista where ID_Hora_Medico = "+ID);
            while(resultado.next()){

            estado = resultado.getString(1);
            }
            
            
            if("Activo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Hora_Medico (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Hora_Medico Desactivada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            }
            
            if("Inactivo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Hora_Medico (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Hora_Medico Activada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            }
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}
 
public static void Activar_Hora_Medico(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Hora_Medico (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 //     JOptionPane.showMessageDialog(null,"Estudiante Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Desactivar_Hora_Medico(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Hora_Medico (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 //     JOptionPane.showMessageDialog(null,"Estudiante Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
         
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

}
