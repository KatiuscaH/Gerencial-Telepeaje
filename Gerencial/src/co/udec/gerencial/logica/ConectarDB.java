package co.udec.gerencial.logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarDB {

    private static Connection cone;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/telepeaje";

    public ConectarDB() {
        cone = null;
        try {
            Class.forName(DRIVER);
            cone = DriverManager.getConnection(URL, USER, PASSWORD);
            if (cone != null) {
                System.out.printf("%s%n%s%n", "Conexion establecida...", "Congratulations");
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.printf("%s%n%s%n", "Error al tratar de conectar: ", e);
        }
    }

    public Connection getConnection() {
        return cone;
    }

    public void desconectar(){
        cone = null;
        if(cone==null)
            System.out.println("¡Conexión acabada!");

    }
}
