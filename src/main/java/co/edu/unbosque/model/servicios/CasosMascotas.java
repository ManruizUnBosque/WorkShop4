package co.edu.unbosque.model.servicios;

import co.edu.unbosque.model.dto.CasoMascota;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public final class CasosMascotas {

    //Eleccion de opción.

    public static void NuevoCaso(Connection conn, CasoMascota casoMascota) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            String sql = "UPDATE CasoMascota SET created_at = '" + casoMascota.getCreated_at() + "'," +
                    " type = '" + casoMascota.getType() + "'," +
                    " description = '" + casoMascota.getDescription() + "'" +
                    " WHERE pet_id = " + casoMascota.getPet_id();
            int rowUpdated = stmt.executeUpdate(sql);
            System.out.println("Se han actualizado las filas: " + rowUpdated);
        }
    }
}
