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

        String query = "SELECT * FROM maestros WHERE usuario = '" + usuario + "'";
        if (abrirConexion()) {
            try {
                ResultSet result = stm.executeQuery(query);
                while (result.next()) {
                    usuarioBD = result.getString("usuario");
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

}
