package Clases;

import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion {
public static Connection con;
public static Statement state,state1;
public static ResultSet result,result1;

public void Conectar(String user,String pass)throws SQLException,ClassNotFoundException
{  
    
//    try {
            // Get connection
            
            DriverManager.registerDriver( new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost/Clinica", user, pass);

//            if (con!= null) {
//                      
//             
//                DatabaseMetaData meta = con.getMetaData();     
//                System.out.println("\nDriver Information");
//                System.out.println("Driver Name: " + meta.getDriverName());
//                System.out.println("Driver Version: " + meta.getDriverVersion());
//                System.out.println("\nDatabase Information ");
//                System.out.println("Database Name: " + meta.getDatabaseProductName());
//                System.out.println("Database Version: " + meta.getDatabaseProductVersion());
//            }
            
           

 //   Class.forName("sun.jdbc.odb.JdbcOdbcDriver");   
   // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  //con=DriverManager.getConnection("jdbc:odbc:Driver={SQL Server};Server=UNIASUS"
     //   + "; Database=Comedor;Uid="+user+"; Pwd="+pass); //Conexion Directa
// con=DriverManager.getConnection(url,user,pass); // Conexion ODBC
    
    
    state=con.createStatement(result.TYPE_SCROLL_SENSITIVE,result.CONCUR_UPDATABLE);
    
//   JOptionPane.showMessageDialog(null,"Conexión Establecida", "Conexión Establecida",JOptionPane.INFORMATION_MESSAGE);

//      } catch (SQLException se) {
//            JOptionPane.showMessageDialog(null,se.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
//           
//             
//        }
}//fin del constructor
 public static ResultSet consulta(String sql)throws SQLException{

        state1 = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,result1.CONCUR_READ_ONLY);
        result1 = state1.executeQuery(sql);//aqui hago consultas y devuelvo los resultados
        return result1;
}
 
 
         }
