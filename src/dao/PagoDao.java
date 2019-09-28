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
public class PagoDao {
    
    
public static ResultSet resultado;

public static void Agregar_Pago(int ID_Paciente, int ID_Usuario){

    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call AgregarPago (?,?)}");

           
                        consulta.setInt(1, ID_Paciente);
                        consulta.setInt(2, ID_Usuario);

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Pago guardado correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }

public static void Agregar_DetellePago(int ID_Pago, int ID_Servicio, int Cantidad){

    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call AgregarDetallePago (?,?,?)}");

           
                        consulta.setInt(1, ID_Pago);
                        consulta.setInt(2, ID_Servicio);
                        consulta.setInt(3, Cantidad);

                        consulta.execute();

      //   JOptionPane.showMessageDialog(null,"Datos del Detalle Pago guardado correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }

        
}


public static void Actualizar_Pago(int ID, String Titulo, 
       double Cuota, double Matricula, String Ruta_Imagen ){
   
    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call ModificarPago (?,?,?,?,?) }");

                        consulta.setInt(1,ID);
                        consulta.setString(2, Titulo);
                        consulta.setDouble(3, Cuota);
                        consulta.setDouble(4, Matricula);
                        consulta.setString(5, Ruta_Imagen);
                        
                       

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos de La Pago Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}

public static void Cancelar_Pago(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Cancelar_DPago (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 //     JOptionPane.showMessageDialog(null,"Estudiante Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
         
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
    
     try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Cancelar_Pago (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Cancelado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
         
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

}
