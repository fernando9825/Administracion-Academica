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
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ferna
 */
public class conectarBD {

    Connection con;
    Statement stm;
    Statement st;

    // jdbc:mysql://mysql5005.smarterasp.net/db_a2b143_fer9825?user=a2b143_fer9825&password=982505va
    //LOCALHOST//private static String driver = "jdbc:mysql://localhost/admin_academica?user=root&password=";
    private static String servidor = "mysql5005.smarterasp.net";
    private static String baseDeDatos = "db_a2b143_fer9825";
    private static String usuarioCon = "a2b143_fer9825";
    private static String passwordCon = "982505va";
    private static String driver = "jdbc:mysql://" + servidor + "/" + baseDeDatos
            + "?user=" + usuarioCon + "&password=" + passwordCon;

    //Variables publicas para manejar el inicio de sesión
    public String usuarioBD, passwordBD, fullname, correo, materia, seccion;

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
                    seccion = result.getString("seccion");
                    //String email = result.getString("email");

                    //String output = "User #%d: %s - %s - %s - %s";
                    //System.out.println(String.format(output, ++count, usuarioBD, passwordBD, fullname, email));
                }
            } catch (SQLException e) {
            }
            cerrarConexion();
        }

    }

    public boolean ingresarNotas(String carnet, String materia, float nota) {
        boolean registrado = false;
        float notaRetorno = 0;
        if (abrirConexion()) {
            try {
                System.out.println("conexion abierta");

                //Asignando nota, dependiendo del carnet y materia.
                String query = "UPDATE notas set " + materia + " = " + nota + "  WHERE carnet= '" + carnet + "'";
                st.executeUpdate(query);

                //
                
                //Verificando que se ingreso
                query = "SELECT * FROM notas WHERE carnet = '" + carnet + "'";
                ResultSet result = stm.executeQuery(query);
                if (result.next()) {
                    notaRetorno = result.getFloat(materia);
                }
                
                if(notaRetorno == nota){
                    registrado = true;
                }
                //
                //Cerrar la conexion
                cerrarConexion();
            } catch (SQLException e) {
                System.err.println("Ha ocurrido un problema, lo sentimos, vuelva a intentarlo");
                System.err.println(e.getMessage());
                registrado = false;
            }
        }

        return registrado;
    }

    public boolean RegistrarMaestro(String correo, String nombre, String apellido, String passWord, String materia, String seccion) {
        boolean ingresado = false;
        if (abrirConexion()) {
            try {
                // the mysql insert statement
                String query = "INSERT INTO maestros(correo, nombre, apellido, password, materia, seccion) VALUES ('" + correo + "', '" + nombre + "', '" + apellido + "', '" + passWord + "', '" + materia + "', '" + seccion + "')";
                st.executeUpdate(query);

                //Parte que se encarga de modificar el valor de las tablas maestrodisp y materiadisp
                //Quitando disponibiblidad de materia.
                query = "UPDATE materias_disp SET " + materia + " = 0  WHERE 1 ";
                st.executeUpdate(query);

                //Quitando disponibiblidad de seccion.
                query = "UPDATE maestro_guia SET " + maestroQuery(seccion) + " = 0  WHERE 1 ";
                st.executeUpdate(query);

                //
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
    
    public boolean RegistrarMaestroNormal(String correo, String nombre, String apellido, String passWord, String materia, String seccion) {
        boolean ingresado = false;
        if (abrirConexion()) {
            try {
                // the mysql insert statement
                String query = "INSERT INTO maestros(correo, nombre, apellido, password, materia, seccion) VALUES ('" + correo + "', '" + nombre + "', '" + apellido + "', '" + passWord + "', '" + materia + "', '" + seccion + "')";
                st.executeUpdate(query);

                //Parte que se encarga de modificar el valor de las tablas materiadisp
                //Quitando disponibiblidad de materia.
                query = "UPDATE materias_disp SET " + materia + " = 0  WHERE 1 ";
                st.executeUpdate(query);
                //
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

    public boolean RegistrarAlumno(String carnet, String nombre, String apellido,
            String edad, String direccion, String sexo, String correo, String seccion,
            String passWord) {
        boolean ingresado = false;
        if (abrirConexion()) {
            try {

                // el mysql insert statement
                String query = "INSERT INTO alumnos(carnet, nombre, apellido, edad, direccion, sexo, correo, seccion, password) VALUES ('" + carnet + "', '" + nombre + "', '" + apellido + "', '" + edad + "', '" + direccion + "', '" + sexo + "', '" + correo + "', '" + seccion + "', '" + passWord + "')";
                st.executeUpdate(query);

                //
                query = "INSERT INTO notas(carnet, apellido, seccion) VALUES ('" + carnet + "', '" + apellido + "', '" + seccion + "')";
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
        return quitarNull(AñoOpcionSeccionDispCadena);
    }

    public String[] getMateria(String opcion) {

        String query = "SELECT * FROM materias_disp where 1";
        String[] materia = new String[14];

        int[] comprobar = new int[14];

        if (abrirConexion()) {
            try {
                ResultSet result = stm.executeQuery(query);
                while (result.next()) {
                    for (int i = 1; i < materia.length; i++) {
                        comprobar[i] = result.getInt(i);
                    }
                }
            } catch (SQLException e) {
            }
            cerrarConexion();
        }

        materia[0] = "Elija una materia";
        if (opcion.equalsIgnoreCase("general")) {
            for (int i = 1; i < materia.length; i++) {
                if (i == 1) {
                    if (comprobar[i] == 1) {
                        materia[i] = "Matemáticas";
                    }
                } else if (i == 2) {
                    if (comprobar[i] == 1) {
                        materia[i] = "Sociales";
                    }
                } else if (i == 3) {
                    if (comprobar[i] == 1) {
                        materia[i] = "Ciencia";
                    }
                } else if (i == 4) {
                    if (comprobar[i] == 1) {
                        materia[i] = "Lenguaje";
                    }
                } else if (i == 5) {
                    if (comprobar[i] == 1) {
                        materia[i] = "Ingles";
                    }
                } else if (i == 6) {
                    if (comprobar[i] == 1) {
                        materia[i] = "opv";
                    }
                } else if (i == 7) {
                    if (comprobar[i] == 1) {
                        materia[i] = "Seminario";
                    }
                } else if (i == 8) {
                    if (comprobar[i] == 1) {
                        materia[i] = "Informática";
                    }
                } else if (i == 9) {
                    if (comprobar[i] == 1) {
                        materia[i] = "Tecnología";
                    }
                }
            }
        }
        if (opcion.equalsIgnoreCase("técnico")) {
            for (int i = 1; i < materia.length; i++) {
                if (comprobar[i] == 1) {

                    System.out.println("Eran unos");
                    System.out.println(comprobar[i]);
                    if (i == 1) {
                        if (comprobar[i] == 1) {
                            materia[i] = "Matemáticas";
                        }
                    } else if (i == 2) {
                        if (comprobar[i] == 1) {
                            materia[i] = "Sociales";
                        }
                    } else if (i == 3) {
                        if (comprobar[i] == 1) {
                            materia[i] = "Ciencia";
                        }
                    } else if (i == 4) {
                        if (comprobar[i] == 1) {
                            materia[i] = "Lenguaje";
                        }
                    } else if (i == 5) {
                        if (comprobar[i] == 1) {
                            materia[i] = "Ingles";
                        }
                    } else if (i == 6) {
                        if (comprobar[i] == 1) {
                            materia[i] = "opv";
                        }
                    } else if (i == 7) {
                        if (comprobar[i] == 1) {
                            materia[i] = "Seminario";
                        }
                    } else if (i == 8) {
                        if (comprobar[i] == 1) {
                            materia[i] = "Informática";
                        }
                    } else if (i == 9) {
                        if (comprobar[i] == 1) {
                            materia[i] = "Tecnología";
                        }
                    } else if (i == 10) {
                        if (comprobar[i] == 1) {
                            materia[i] = "Matemáticas_financieras";
                        }
                    } else if (i == 11) {
                        if (comprobar[i] == 1) {
                            materia[i] = "Lab_creatividad";
                        }
                    }
                    if (i == 12) {
                        if (comprobar[i] == 1) {
                            materia[i] = "Prácticas_contables";
                        }
                    }
                } else {
                    if (i == 12) {
                        if (comprobar[i] == 0) {
                            materia[i] = "Prácticas_contables";
                        }
                    }
                    System.out.println("Eran ceros");
                    System.out.println(comprobar[i]);
                }

            }
        }

//                switch (i) {
//                    case 0: {
//                            materia[i] = "Elija una materia";
//                        
//                        break;
//                    }
//                    case 1: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Matemáticas";
//                        }
//                        break;
//                    }
//                    case 2: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Sociales";
//                        }
//                        break;
//                    }
//                    case 3: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Ciencia";
//                        }
//                        break;
//                    }
//                    case 4: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Lenguaje";
//                        }
//                        break;
//                    }
//                    case 5: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Ingles";
//                        }
//                        break;
//                    }
//                    case 6: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "opv";
//                        }
//                        break;
//                    }
//                    case 7: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Seminario";
//                        }
//                        break;
//                    }
//                    case 8: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Informática";
//                        }
//                        break;
//                    }
//                    case 9: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Tecnología";
//                        }
//                        break;
//                    }
//                }
//            }
//        }
//        if (opcion.equalsIgnoreCase("técnico")) {
//            for (int i = 0; i < materia.length; i++) {
//                switch (i) {
//
//                    case 0: {
//                        materia[i] = "Elija una materia";
//                        break;
//                    }
//                    case 1: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Matemáticas";
//                        }
//                        break;
//                    }
//                    case 2: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Sociales";
//                        }
//                        break;
//                    }
//                    case 3: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Ciencia";
//                        }
//                        break;
//                    }
//                    case 4: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Lenguaje";
//                        }
//                        break;
//                    }
//                    case 5: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Ingles";
//                        }
//                        break;
//                    }
//                    case 6: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "opv";
//                        }
//                        break;
//                    }
//                    case 7: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Seminario";
//                        }
//                        break;
//                    }
//                    case 8: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Informática";
//                        }
//                        break;
//                    }
//                    case 9: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Tecnología";
//                        }
//                        break;
//                    }
//                    case 10: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Matemáticas_financieras";
//                        }
//                        break;
//                    }
//                    case 11: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Lab_creatividad";
//                        }
//                        break;
//                    }
//                    case 12: {
//                        if (comprobar[i] == 1) {
//                            materia[i] = "Prácticas_contables";
//                        }
//                        break;
//                    }
//                }
//            }
//        }
        return quitarNull(materia);
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

    public String maestroQuery(String maestro) {
        String cadena = "";
        if (maestro.equalsIgnoreCase("1° General A")) {
            cadena = "pga";
        } else if (maestro.equalsIgnoreCase("1° General B")) {
            cadena = "pgb";
        } else if (maestro.equalsIgnoreCase("1° General C")) {
            cadena = "pgc";
        } else if (maestro.equalsIgnoreCase("2° General A")) {
            cadena = "sga";
        } else if (maestro.equalsIgnoreCase("2° General B")) {
            cadena = "sgb";
        } else if (maestro.equalsIgnoreCase("2° General C")) {
            cadena = "sgc";
        } else if (maestro.equalsIgnoreCase("1° Técnico vocacional A")) {
            cadena = "ptva";
        } else if (maestro.equalsIgnoreCase("2° Técnico vocacional A")) {
            cadena = "stva";
        } else if (maestro.equalsIgnoreCase("3° Técnico vocacional A")) {
            cadena = "ttva";
        }
        return cadena;
    }

    public String[] quitarNull(String[] a) {
        ArrayList<String> removedNull = new ArrayList<String>();
        for (String str : a) {
            if (str != null) {
                removedNull.add(str);
            }
        }
        return removedNull.toArray(new String[0]);
    }

    public void llenarTabla(JTable table, String Query) {
        try {
            abrirConexion();
            ResultSet rs = st.executeQuery(Query);

            //To remove previously added rows
            while (table.getRowCount() > 0) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow() - 1, row);
            }

            rs.close();
            st = null;
            con = null;
        } catch (SQLException e) {
        }
    }

    public String generadorCarnet(String apellido, String seccion) {
        String resultado = "";
        int numero = 0;
        String seccioncad = seccion.toUpperCase();
        try {
            //Determinando el numero de alumno

            if (abrirConexion()) {
                System.out.println("conexion abierta");
                String Query = "SELECT COUNT(*) AS total FROM alumnos";
                ResultSet result = stm.executeQuery(Query);
                if (result.next()) {

                    numero = result.getInt("total");
                }

                numero += 1;
                System.out.println(numero);
                String sPalabra = "";

                int x = 0;
                StringTokenizer stPalabras = new StringTokenizer(apellido);
                while (stPalabras.hasMoreTokens()) {

                    sPalabra = stPalabras.nextToken();
                    resultado += sPalabra.substring(0, 1).toUpperCase();
                    System.out.println(sPalabra.substring(0, 1));
                    if (x == 1) {
                        break;
                    }
                    x++;
                }
            } else {
                System.out.println("no se abrio la conexion");
            }

            resultado = resultado + "17" + seccioncad.toUpperCase() + numero;
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println("Entre aqui");
            System.out.println(e);
        }
        resultado = resultado.toUpperCase();
        return resultado;
    }

    public String generadorPassword() {
        String pass = "";
        int numero;
        for (int i = 0; i < 5; i++) {
            numero = (int) (Math.random() * 35) + 1;
            switch (numero) {
                case 1: {
                    pass += "a";
                    break;
                }
                case 2: {
                    pass += "b";
                    break;
                }
                case 3: {
                    pass += "c";
                    break;
                }
                case 4: {
                    pass += "d";
                    break;
                }
                case 5: {
                    pass += "f";
                    break;
                }
                case 6: {
                    pass += "g";
                    break;
                }
                case 7: {
                    pass += "h";
                    break;
                }
                case 8: {
                    pass += "i";
                    break;
                }
                case 9: {
                    pass += "j";
                    break;
                }

                case 10: {
                    pass += "k";
                    break;
                }
                case 11: {
                    pass += "l";
                    break;
                }
                case 12: {
                    pass += "m";
                    break;
                }
                case 13: {
                    pass += "n";
                    break;
                }
                case 14: {
                    pass += "o";
                    break;
                }
                case 15: {
                    pass += "p";
                    break;
                }
                case 16: {
                    pass += "q";
                    break;
                }
                case 17: {
                    pass += "r";
                    break;
                }
                case 18: {
                    pass += "s";
                    break;
                }
                case 19: {
                    pass += "t";
                    break;
                }
                case 20: {
                    pass += "u";
                    break;
                }
                case 21: {
                    pass += "v";
                    break;
                }
                case 22: {
                    pass += "w";
                    break;
                }
                case 23: {
                    pass += "x";
                    break;
                }
                case 24: {
                    pass += "y";
                    break;
                }
                case 25: {
                    pass += "z";
                    break;
                }
                case 26: {
                    pass += "0";
                    break;
                }
                case 27: {
                    pass += "1";
                    break;
                }
                case 28: {
                    pass += "2";
                    break;
                }
                case 29: {
                    pass += "3";
                    break;
                }
                case 30: {
                    pass += "4";
                    break;
                }
                case 31: {
                    pass += "5";
                    break;
                }
                case 32: {
                    pass += "6";
                    break;
                }
                case 33: {
                    pass += "7";
                    break;
                }
                case 34: {
                    pass += "8";
                    break;
                }
                case 35: {
                    pass += "9";
                    break;
                }

            }
        }
        return pass;
    }
}
