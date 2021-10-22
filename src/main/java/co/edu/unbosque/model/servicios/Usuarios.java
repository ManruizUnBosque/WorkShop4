package co.edu.unbosque.model.servicios;

import co.edu.unbosque.model.dto.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class Usuarios {

    //Muestra la lista de usuarios filtrada por el rol.

    public static void usuariosPorRol (Connection conn, String rol) throws SQLException {
        List<Usuario> users = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM UsurioApp WHERE role = '"+rol+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String email = rs.getString("email");
                users.add(new Usuario(username, password, role, email));
            }
            users.forEach(System.out::println);
            rs.close();
        }
    }
}
