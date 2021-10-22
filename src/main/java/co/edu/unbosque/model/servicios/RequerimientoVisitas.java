package co.edu.unbosque.model.servicios;

import co.edu.unbosque.model.dto.Visitas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class RequerimientoVisitas {

    //Muestra los campos de veterinario segun su id de mascota.

    public static void visitante (Connection conn, int petId) throws SQLException {
        List<Visitas> visitantes = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM Visitante WHERE pet_id = "+petId;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int visit_id = rs.getInt("visit_id");
                String created_at = rs.getString("created_at");
                String type = rs.getString("type");
                String description = rs.getString("description");
                String vet_id = rs.getString("vet_id");
                int pet_id = rs.getInt("pet_id");
                visitantes.add(new Visitas(visit_id, created_at, type, description, vet_id, pet_id));
            }
            visitantes.forEach(System.out::println);
            rs.close();
        }
    }
}
