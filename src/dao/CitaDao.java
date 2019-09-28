/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author UNI
 */
public class CitaDao {
    
    
public static ResultSet resultado;

public static void Agregar_Cita(Date Fecha, String Hora, int ID_Medico,  int ID_Paciente, String Dia_Semana,
        int Semana_Cita){

 String Estado = "Pendiente";  
 
 long date = Fecha.getTime();
 java.sql.Date FechaC = new java.sql.Date(date);
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call AgregarCita (?,?,?,?,?,?,?)}");

           
                        consulta.setDate(1, FechaC);
                        consulta.setString(2, Hora);
                        consulta.setInt(3, ID_Medico);
                        consulta.setInt(4, ID_Paciente);
                        consulta.setString(5, Estado);
                        consulta.setString(6, Dia_Semana);
                        consulta.setInt(7, Semana_Cita);
                        
  
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos de la Cita guardado correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }


public static void Actualizar_Cita(int ID, String Titulo, 
       double Cuota, double Matricula, String Ruta_Imagen ){
   
    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call ModificarCita (?,?,?,?,?) }");

                        consulta.setInt(1,ID);
                        consulta.setString(2, Titulo);
                        consulta.setDouble(3, Cuota);
                        consulta.setDouble(4, Matricula);
                        consulta.setString(5, Ruta_Imagen);
                        
                       

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos de La Cita Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}
 
public static void Cita_Atendida(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call CitaAtendida (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 //     JOptionPane.showMessageDialog(null,"Estudiante Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Cancelar_Cita(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Cancelar_Cita (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Cancelada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
         
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

}
