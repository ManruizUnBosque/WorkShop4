package co.edu.unbosque.controller;

import co.edu.unbosque.model.dto.CasoMascota;
import co.edu.unbosque.model.servicios.CasosMascotas;
import co.edu.unbosque.model.servicios.Usuarios;
import co.edu.unbosque.model.servicios.RequerimientoVeterinario;
import co.edu.unbosque.model.servicios.RequerimientoVisitas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Controller {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "";

    public Controller() {
        Opciones();
    }

    //Metodo para seleccionar el caso con el cual se quiere utilizar

    public void Opciones () {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        Date date = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Class.forName(JDBC_DRIVER);
            do {
                System.out.println("""
                    Elija una acción:
                    1. Registrar nuevo caso!
                    2. Contar la lista de veterinarias
                    3. Consultar lista de usuarios por rol
                    4. Consultar visitas registradas de las mascotas
                    
                    5. Salir
                    """);
                switch (scan.nextInt()) {
                    case 1 -> {
                        System.out.print("Ingrese tipo de caso: ");
                        String type = scan.next();
                        System.out.println("Ingrese descripcion: ");
                        String description = scan.next();
                        System.out.print("Ingrese id de la mascota: ");
                        int id = scan.nextInt();
                        CasosMascotas.NuevoCaso(conn, new CasoMascota(df.format(date), type, description, id));

                    }
                    case 2 -> RequerimientoVeterinario.cantidadVeterinarios(conn);

                    case 3 -> {
                        System.out.print("Ingrese rol: ");
                        Usuarios.usuariosPorRol(conn, scan.next());

                    }
                    case 4 -> {
                        System.out.print("Ingrese id de la mascota: ");
                        RequerimientoVisitas.visitante(conn, scan.nextInt());
                    }
                    case 5 -> System.exit(0);
                    default -> System.out.println("La opcion no es valida");
                }
            } while (true);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getInstance() {
        new Controller();
    }
}
