package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    Connection conectar = null;
    public Connection conexion(){
        try{
          Class.forName("com.mysql.jdbc.Driver");
          conectar = DriverManager.getConnection("jdbc:mysql://localhost/centrocultural", "root", "root");
        }catch(ClassNotFoundException | SQLException e){
            System.out.print(e.getMessage());
        }
        return conectar;
    }
    
}