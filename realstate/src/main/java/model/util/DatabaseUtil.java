package model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String URL = "jdbc:mariadb://localhost:3307/inmobiliaria";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Manejo personalizado de la excepción, como mostrar un mensaje de error al usuario
            System.err.println("Error: No se pudo cargar el driver JDBC");
            // Lanzar una nueva excepción SQLException con un mensaje personalizado
            throw new SQLException("Error: No se pudo cargar el driver JDBC", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

