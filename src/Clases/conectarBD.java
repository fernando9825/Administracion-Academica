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

/**
 *
 * @author ferna
 */
public class conectarBD {

    private static Connection conectar;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "a2b143_fer9825";
    private static final String password = "982505va";
    private static final String server = "jdbc:mysql://mysql5005.smarterasp.net/db_a2b143_fer9825";
    
    //Variables publicas para manejar el inicio de sesión
    public String usuarioBD, passwordBD, fullname, correo;

    public conectarBD() {
        conectar = null;

        try {
            Class.forName(server);
            conectar = DriverManager.getConnection(server, user, password);
            if (conectar != null) {
                System.out.println("Conexión establecida con la BD");
            } else {
                System.out.println("No se pudo conectar a la BD");
            }
        } catch (ClassNotFoundException | SQLException e) {

        }

    }

    //Este metodo retorna la conexion
    public Connection Conectar() {
        return conectar;
    }

    //Con este método cerramos la conexion
    public void Desconectar() {
        conectar = null;
        if (conectar == null) {
            System.out.println("Conexion cerrada");
        }
    }

    public void IniciarSesion(String usuario, String password) {
        String query = "SELECT * FROM maestros WHERE usuario = '" + usuario + "'";
        Connection con = Conectar();

        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);

            int count = 0;

            while (result.next()) {
                 usuarioBD = result.getString("usuario");
                 passwordBD = result.getString("password");
                 fullname = result.getString("nombre") + " " + result.getString("apellido");
                //String email = result.getString("email");

                //String output = "User #%d: %s - %s - %s - %s";
                //System.out.println(String.format(output, ++count, usuarioBD, passwordBD, fullname, email));
            }
        } catch (SQLException e) {
        }

    }

}



