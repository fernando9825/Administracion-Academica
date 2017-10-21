/*
 * //Configuracion para Smarterasp.net
        server = "mysql5005.smarterasp.net";
        database = "db_a2b143_fer9825";
        uid = "a2b143_fer9825"; //Username
        password = "982505va"; //password


        connectionString = "SERVER=" + server + ";" + "DATABASE=" +
        database + ";" + "UID=" + uid + ";" + "PASSWORD=" + password + ";";
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ferna
 */
public class conectarBD {

    Connection con;
    Statement stm;
    Statement st;
    //LOCALHOST//private static String driver = "jdbc:mysql://localhost/admin_academica?user=root&password=";
    private static String servidor = "mysql5005.smarterasp.net";
    private static String baseDeDatos = "db_a2b143_fer9825";
    private static String usuarioCon = "a2b143_fer9825";
    private static String passwordCon = "982505va";
    private static String driver = "jdbc:mysql://" + servidor + "/" + baseDeDatos
            + "?user=" + usuarioCon + "&password=" + passwordCon;

    //Variables publicas para manejar el inicio de sesión
    public String usuarioBD, passwordBD, fullname, correo, materia;

    public conectarBD() {
        //CONSTRUCTOR DE LA CLASE
        abrirConexion();
    }

    //Con este metodo nos conectamos y retorna la conexion.
    public boolean abrirConexion() {
        boolean conex = false;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(driver);
            if (con != null) {
                conex = true;
            }

            stm = con.createStatement();
            st = (Statement) con.createStatement();
            //ResultSet rs = stm.executeQuery("select * from maestros");

        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(conectarBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conex;
    }

    //Con este método cerramos la conexion
    public void cerrarConexion() {
        con = null;
    }

    public void IniciarSesion(String usuario, String password) {

        String query = "SELECT * FROM maestros WHERE correo = '" + usuario + "'";
        if (abrirConexion()) {
            try {
                ResultSet result = stm.executeQuery(query);
                while (result.next()) {
                    usuarioBD = result.getString("correo");
                    passwordBD = result.getString("password");
                    fullname = result.getString("nombre") + " " + result.getString("apellido");
                    materia = result.getString("materia");
                    //String email = result.getString("email");

                    //String output = "User #%d: %s - %s - %s - %s";
                    //System.out.println(String.format(output, ++count, usuarioBD, passwordBD, fullname, email));
                }
            } catch (SQLException e) {
            }
            cerrarConexion();
        }

    }

    public boolean RegistrarMaestro(String correo, String nombre, String apellido, String passWord, String materia) {
        boolean ingresado = false;
        if (abrirConexion()) {
            try {
                // the mysql insert statement
                String query = "INSERT INTO maestros(correo, nombre, apellido, password, materia) VALUES ('" + correo + "', '" + nombre + "', '" + apellido + "', '" + passWord + "', '" + materia + "')";

                st.executeUpdate(query);
                //Cerrar la conexion
                cerrarConexion();
                ingresado = true;
            } catch (SQLException e) {
                System.err.println("Ha ocurrido un problema, lo sentimos, vuelva a intentarlo");
                System.err.println(e.getMessage());
                ingresado = false;
            }
        }
        return ingresado;
    }

    public String[] MaestroGuia() {

        //Me equivoque en el nombre de las variables cuando habia avanzado, pero esta parte del codigo 
        //determinara si hay cupo disponible para maestros guias
        String[] AñoOpcionSeccionDispCadena = new String[10];
        String query = "SELECT * FROM maestro_guia";
        int[] AñoOpcionSeccionDisp = new int[10];
        if (abrirConexion()) {
            try {
                ResultSet result = stm.executeQuery(query);
                AñoOpcionSeccionDisp[0] = 1;
                //AñoOpcionSeccionDisp[9] = 1;
                while (result.next()) {
                    for (int i = 1; i < AñoOpcionSeccionDisp.length; i++) {
                        AñoOpcionSeccionDisp[i] = result.getInt((i));
                        
                    }
                    
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            cerrarConexion();
        }

        for (int i = 0; i < AñoOpcionSeccionDispCadena.length; i++) {

            if (i >= 0 && i <= 3) {
                switch (i) {
                    case 0: {
                        AñoOpcionSeccionDispCadena[i] = "Elija una sección";
                        break;
                    }
                    case 1: {
                        if (AñoOpcionSeccionDisp[i] == 1) {
                            AñoOpcionSeccionDispCadena[i] = "1° General A";
                        }
                        break;
                    }
                    case 2: {
                        if (AñoOpcionSeccionDisp[i] == 1) {
                            AñoOpcionSeccionDispCadena[i] = "1° General B";
                        }
                        break;
                    }
                    case 3: {
                        if (AñoOpcionSeccionDisp[i] == 1) {
                            AñoOpcionSeccionDispCadena[i] = "1° General C";
                        }
                        break;
                    }
                }
            } else if (i >= 4 && i <= 6) {

                switch (i) {
                    case 4: {
                        if (AñoOpcionSeccionDisp[i] == 1) {
                            AñoOpcionSeccionDispCadena[i] = "2° General A";
                        }
                        break;
                    }
                    case 5: {
                        if (AñoOpcionSeccionDisp[i] == 1) {
                            AñoOpcionSeccionDispCadena[i] = "2° General B";
                        }
                        break;
                    }
                    case 6: {
                        if (AñoOpcionSeccionDisp[i] == 1) {
                            AñoOpcionSeccionDispCadena[i] = "2° General C";
                        }
                        break;
                    }
                }

            } else {

                if (i == 7) {
                    if (AñoOpcionSeccionDisp[i] == 1) {
                        AñoOpcionSeccionDispCadena[i] = "1° Técnico vocacional A";
                    }
                } else if (i == 8) {
                    if (AñoOpcionSeccionDisp[i] == 1) {
                        AñoOpcionSeccionDispCadena[i] = "2° Técnico vocacional A";
                    }
                } else {
                    if (AñoOpcionSeccionDisp[i] == 1) {
                        AñoOpcionSeccionDispCadena[i] = "3° Técnico vocacional A";
                    }
                }
            }
        }
        int x = 0;
        for (int i = 0; i < AñoOpcionSeccionDispCadena.length; i++) {
            if (AñoOpcionSeccionDispCadena[i] != null) {
                x++;
            }
        }

        String[] AñoOpcionSeccionDispCadenaCorregido = new String[x];
        for (int i = 0; i < x; i++) {
            for (int j = i; j < AñoOpcionSeccionDispCadena.length; j++) {
                if (AñoOpcionSeccionDispCadena[j] != null) {
                    AñoOpcionSeccionDispCadenaCorregido[i] = AñoOpcionSeccionDispCadena[j];
                    break;
                }

            }
        }
        return AñoOpcionSeccionDispCadena;
    }

    public String[] getMateria(String opcion) {

        String query = "SELECT * FROM materias_disp";
        String[] materia = new String[13];

        int[] comprobar = new int[13];

        if (abrirConexion()) {
            try {
                ResultSet result = stm.executeQuery(query);
                while (result.next()) {
                    for (int i = 0; i < 12; i++) {
                        comprobar[i] = result.getInt((i + 1));
                    }
                }
            } catch (SQLException e) {
            }
            cerrarConexion();
        }

        if (opcion.equalsIgnoreCase("general")) {
            for (int i = 0; i < materia.length; i++) {
                switch (i) {
                    case 0: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Elija una materia";
                        }
                        break;
                    }
                    case 1: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Matemáticas";
                        }
                        break;
                    }
                    case 2: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Sociales";
                        }
                        break;
                    }
                    case 3: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Ciencia";
                        }
                        break;
                    }
                    case 4: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Lenguaje";
                        }
                        break;
                    }
                    case 5: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Ingles";
                        }
                        break;
                    }
                    case 6: {
                        if (comprobar[i] == 1) {
                            materia[i] = "opv";
                        }
                        break;
                    }
                    case 7: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Seminario";
                        }
                        break;
                    }
                    case 8: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Informática";
                        }
                        break;
                    }
                    case 9: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Tecnología";
                        }
                        break;
                    }
                }
            }
        }
        if (opcion.equalsIgnoreCase("técnico")) {
            for (int i = 0; i < materia.length; i++) {
                switch (i) {

                    case 0: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Elija una materia";
                        }
                        break;
                    }
                    case 1: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Matemáticas";
                        }
                        break;
                    }
                    case 2: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Sociales";
                        }
                        break;
                    }
                    case 3: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Ciencia";
                        }
                        break;
                    }
                    case 4: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Lenguaje";
                        }
                        break;
                    }
                    case 5: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Ingles";
                        }
                        break;
                    }
                    case 6: {
                        if (comprobar[i] == 1) {
                            materia[i] = "opv";
                        }
                        break;
                    }
                    case 7: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Seminario";
                        }
                        break;
                    }
                    case 8: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Informática";
                        }
                        break;
                    }
                    case 9: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Tecnología";
                        }
                        break;
                    }
                    case 10: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Matemáticas_financieras";
                        }
                        break;
                    }
                    case 11: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Lab_creatividad";
                        }
                        break;
                    }
                    case 12: {
                        if (comprobar[i] == 1) {
                            materia[i] = "Prácticas_contables";
                        }
                        break;
                    }
                }
            }
        }

        int x = 0;
        for (int i = 0; i < materia.length; i++) {
            if (materia[i] != null) {
                x++;
            }
        }
        String[] materiaCorregido = new String[x];
        for (int i = 0; i < x; i++) {
            for (int j = i; j < materia.length; j++) {
                if (materia[j] != null) {
                    materiaCorregido[i] = materia[j];
                    break;
                }

            }
        }

        return materiaCorregido;
    }

    public String mostrarDisp(String[] arreglo) {
        String cadena = "";
        if (arreglo != null) {
            for (int i = 0; i < arreglo.length; i++) {
                cadena += arreglo[i] + ".\n";
            }
        }
        return cadena;
    }

}
