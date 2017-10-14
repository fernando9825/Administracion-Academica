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
                String query = "INSERT INTO maestros(correo, nombre, apellido, password, materia) VALUES ('"+correo + "', '" + nombre + "', '" + apellido + "', '" + passWord + "', '" + materia +"')";
                
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

}
