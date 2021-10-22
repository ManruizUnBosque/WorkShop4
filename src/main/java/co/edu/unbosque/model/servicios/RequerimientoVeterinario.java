package co.edu.unbosque.model.servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class RequerimientoVeterinario {

    //Cuenta la cantidad de veterinarios en la base de datos.

    public static void cantidadVeterinarios(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()){
            String sql = "SELECT COUNT(*) AS count FROM Vet";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            System.out.println("Hay "+rs.getInt("count")+" veterinarios.");
            rs.close();
        }
    }
}
