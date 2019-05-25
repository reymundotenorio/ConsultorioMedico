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
public class Dia_Medico {
    
    
public static ResultSet resultado;

public static void Agregar_Dia_Medico(int ID_Medico, String Dia){

    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call AgregarDia_Medico (?,?)}");

                        consulta.setInt(1, ID_Medico);
                        consulta.setString(2, Dia);
                    
                       
                        consulta.execute();

     //    JOptionPane.showMessageDialog(null,"Datos del Dia Medico guardado correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }


public static void Actualizar_Dia_Medico(int ID, String Titulo, 
       double Cuota, double Matricula, String Ruta_Imagen ){
   
    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call ModificarDia_Medico (?,?,?,?,?) }");

                        consulta.setInt(1,ID);
                        consulta.setString(2, Titulo);
                        consulta.setDouble(3, Cuota);
                        consulta.setDouble(4, Matricula);
                        consulta.setString(5, Ruta_Imagen);
                        
                       

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos de La Dia_Medico Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}
public static void Activar_Desactivar_Dia_Medico(int ID){
  
    try{
        
            String estado = null;
            resultado = Conexion.consulta("Select Estado_Dia_Medico from revista where ID_Dia_Medico = "+ID);
            while(resultado.next()){

            estado = resultado.getString(1);
            }
            
            
            if("Activo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Dia_Medico (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Dia_Medico Desactivada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            }
            
            if("Inactivo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Dia_Medico (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Dia_Medico Activada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            }
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}
 
public static void Activar_Dia_Medico(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Dia_Medico (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 //     JOptionPane.showMessageDialog(null,"Estudiante Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Desactivar_Dia_Medico(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Dia_Medico (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 //     JOptionPane.showMessageDialog(null,"Estudiante Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
         
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

}
